package useCases.userLogin;

import entities.LoggedInUserSingleton;
import intefaceAdapters.userLogin.FindUser;
import intefaceAdapters.userLogin.UserLoginController;
import intefaceAdapters.userLogin.UserLoginResponseFormatter;
import intefaceAdapters.userLogin.UserLoginScreenInterface;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginInteractorTest {
    private final String SUCCESS_TEST_EMAIL = "manav@gmail.com";
    private final String SUCCESS_TEST_PASSWORD = "password";

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
    private final MockUserLoginScreen mockUserLoginScreen =  new MockUserLoginScreen();
    private UserLoginController userLoginController;

    @BeforeEach
    void setUp() {
        UserLoginDsGateway userLoginRepo;
        try {
            userLoginRepo = new FindUser("./test_users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file");
        }
        UserLoginPresenter userLoginResponseFormatter = new UserLoginResponseFormatter(mockUserLoginScreen);
        // no need to initialize the userLoginInterface since the controller does that for us.
        userLoginController = new UserLoginController(userLoginResponseFormatter, userLoginRepo);
    }

    @AfterEach
    void tearDown() {
        LoggedInUserSingleton.reset();
    }
    /**
     * Tests that we send the correct message to the user after a successful login
     */
    @Test
    void testLoginSuccessMessage() {
        userLoginController.callUserLoginInteractor(SUCCESS_TEST_EMAIL, SUCCESS_TEST_PASSWORD);
        String expectedSuccessMessage = "Welcome back to Ryde!";
        assertEquals(expectedSuccessMessage, mockUserLoginScreen.getMessage());
    }
    /**
     * Tests that we set the current logged-in user is set after a successful login.
     */
    @Test
    void checkUserLoggedIn() {
        userLoginController.callUserLoginInteractor(SUCCESS_TEST_EMAIL, SUCCESS_TEST_PASSWORD);
        boolean isDealership  = LoggedInUserSingleton.getInstance().getIsDealership();
        String loggedInUserEmail = LoggedInUserSingleton.getInstance().getEmail();
        assertEquals(false, isDealership);
        assertEquals(SUCCESS_TEST_EMAIL, loggedInUserEmail);
    }

    /**
     * Tests that we send the fail message to the user after an unsuccessful login.
     */
    @Test
    void testLoginFailMessage(){
        String FAIL_TEST_EMAIL = "fail@gmail.com";
        String FAIL_TEST_PASSWORD = "fake_password";
        userLoginController.callUserLoginInteractor(FAIL_TEST_EMAIL, FAIL_TEST_PASSWORD);
        String expectedFailMessage = "Incorrect email or password";
        assertEquals(expectedFailMessage, mockUserLoginScreen.getMessage());
    }

    /**
     * When a login is unsuccessful, check that we do not initialize the LoggedInUserSingleton
     */
    @Test
    void testLoginFail() {
        String FAIL_TEST_EMAIL = "fail@gmail.com";
        String FAIL_TEST_PASSWORD = "fake_password";
        userLoginController.callUserLoginInteractor(FAIL_TEST_EMAIL, FAIL_TEST_PASSWORD);
        
        AssertionError expectedAssertionError = Assert.assertThrows(AssertionError.class, () ->{
                throw new AssertionError("init has not been called first.");
        });
        
        try {
            LoggedInUserSingleton.getInstance();
        } catch (AssertionError e) {
            String actualAssertionError = e.getMessage();
            assertEquals(expectedAssertionError.getMessage(), actualAssertionError);
        }
    }
}