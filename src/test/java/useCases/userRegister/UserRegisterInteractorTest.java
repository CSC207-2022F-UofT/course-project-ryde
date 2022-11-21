package useCases.userRegister;

import entities.UserFactory;
import intefaceAdapters.userRegister.UserCreationFailed;
import intefaceAdapters.userRegister.UserRegisterResponseFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import intefaceAdapters.userRegister.MockUserMap;
import intefaceAdapters.userRegister.UserRegisterController;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This file tests the entire Registration Use Case
 */
class UserRegisterInteractorTest {
    UserRegisterDsGateway userRepository;
    UserRegisterPresenter presenter;
    UserFactory userFactory;
    UserRegisterInputBoundary interactor;
    UserRegisterController controller;

    @BeforeEach
    void setUp() {
//        Since this test does not use FileUser I will test FileUser separately
        userRepository = new MockUserMap();

        presenter = new UserRegisterResponseFormatter();

        userFactory = new UserFactory();

        interactor = new UserRegisterInteractor(userRepository, presenter, userFactory);

        controller = new UserRegisterController(interactor);
    }

    /**
     * Tests successful creation of an Individual User
     */
    @Test
    void createIndividualUser() {
        UserRegisterResponseModel response = controller.create("manav@gmail.com", "password", "password", "manav");
        assertEquals("manav", response.getLogin());
        assertNotNull(response.getCreationTime()); // any creation time is fine.
        assertTrue(userRepository.existsByEmail("manav@gmail.com"));
    }

    /**
     * Tests successful creation of a Dealership User
     */
    @Test
    void createDealershipUser() {
        UserRegisterResponseModel response = controller.create("manav@gmail.com", "password", "password", "manav", "M5S1J4");
        assertEquals("manav", response.getLogin());
        assertNotNull(response.getCreationTime()); // any creation time is fine.
        assertTrue(userRepository.existsByEmail("manav@gmail.com"));
    }

    /**
     * Tests if the use case shows an error message if the user already exists
     */
    @Test
    void testUserAlreadyExists() {
        controller.create("manav@gmail.com", "password", "password", "manav", "M5S1J4");
        UserCreationFailed exception = assertThrows(UserCreationFailed.class, () -> {
            controller.create("manav@gmail.com", "password", "password", "manav", "M5S1J4");
        });
        assertEquals("User already exists.", exception.getMessage());
    }

    /**
     * Tests if the use case shows an error message if the password is the same as the repeat password
     */
    @Test
    void testDifferentPasswords() {
        UserCreationFailed exception = assertThrows(UserCreationFailed.class, () -> {
            controller.create("manav@gmail.com", "password", "notpassword", "manav", "M5S1J4");
        });
        assertEquals("Passwords don't match.", exception.getMessage());
    }

    /**
     * Tests if the use case shows an error message if the location is not a valid Toronto Postal Code
     */
    @Test
    void testInvalidLocation() {
        UserCreationFailed exception = assertThrows(UserCreationFailed.class, () -> {
            controller.create("manav@gmail.com", "password", "password", "manav", "K5S1J4");
        });
        assertEquals("Please enter a valid location in Toronto", exception.getMessage());
    }

    /**
     * Tests if the use case shows an error message if the password shorter than 8 characters
     */
    @Test
    void testValidPassword() {
        UserCreationFailed exception = assertThrows(UserCreationFailed.class, () -> {
            controller.create("manav@gmail.com", "pass", "pass", "manav", "M5S1J4");
        });
        assertEquals("User password must have more than 7 characters.", exception.getMessage());
    }

    /**
     * Tests if the use case shows an error message if the email is invalid
     */
    @Test
    void testValidEmail() {
        UserCreationFailed exception = assertThrows(UserCreationFailed.class, () -> {
            controller.create("manavgmailcom", "password", "password", "manav", "M5S1J4");
        });
        assertEquals("Please enter a valid email address", exception.getMessage());
    }

    /**
     * Tests if the use case shows an error message if an empty form is submitted
     */
    @Test
    void testEmptyForm() {
        UserCreationFailed exception = assertThrows(UserCreationFailed.class, () -> {
            controller.create("", "", "", "");
        });
        assertEquals("Please fill out the the form fully", exception.getMessage());
    }
}