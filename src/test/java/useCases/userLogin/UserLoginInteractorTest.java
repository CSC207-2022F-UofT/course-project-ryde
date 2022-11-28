package useCases.userLogin;

import entities.LoggedInUserSingleton;
import entities.User;
import intefaceAdapters.userLogin.FindUser;
import intefaceAdapters.userLogin.UserLoginController;
import intefaceAdapters.userLogin.UserLoginResponseFormatter;
import intefaceAdapters.userLogin.UserLoginScreenInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginInteractorTest {
    private final String SUCCESS_TEST_EMAIL = "manav@gmail.com";
    private final String SUCCESS_TEST_PASSWORD = "password";

    private final String FAIL_TEST_EMAIL = "fail@gmail.com";
    private final String FAIL_TEST_PASSWORD = "fake_password";
    class MockUserLoginScreen implements UserLoginScreenInterface {
        String message;

        public String getMessage() {
            return message;
        }
        @Override
        public void showLoggedInMessage(String loginMessage) {
            message = loginMessage;
        }

        @Override
        public void showFailureLoginMessage(String errorMessage) {
            message = errorMessage;
        }    }
    private MockUserLoginScreen mockUserLoginScreen =  new MockUserLoginScreen();
    private UserLoginDsGateway userLoginRepo;
    private UserLoginPresenter userLoginResponseFormatter;
    private UserLoginController userLoginController;

    @BeforeEach
    void setUp() {
        try {
            userLoginRepo = new FindUser("./test_users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file");
        }
        userLoginResponseFormatter = new UserLoginResponseFormatter(mockUserLoginScreen);
        // no need to initialize the userLoginInterface since the controller does that for us.
        userLoginController = new UserLoginController(userLoginResponseFormatter, userLoginRepo);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testLoginSuccessMessage() {
        userLoginController.callUserLoginInteractor(SUCCESS_TEST_EMAIL, SUCCESS_TEST_PASSWORD);
        String expectedSuccessMessage = "Welcome back to Ryde!";
        assertEquals(expectedSuccessMessage, mockUserLoginScreen.getMessage());
    }

    @Test
    void checkUserLoggedIn() {
        userLoginController.callUserLoginInteractor(SUCCESS_TEST_EMAIL, SUCCESS_TEST_PASSWORD);
        String loggedInUserEmail = LoggedInUserSingleton.getInstance().getEmail();
        assertEquals(SUCCESS_TEST_EMAIL, loggedInUserEmail);
    }

    @Test
    void testLoginFailMessage(){
        userLoginController.callUserLoginInteractor(FAIL_TEST_EMAIL, FAIL_TEST_PASSWORD);
        String expectedFailMessage = "Incorrect email or password";
        assertEquals(expectedFailMessage, mockUserLoginScreen.getMessage());
    }


}