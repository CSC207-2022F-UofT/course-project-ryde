package useCases.userRegister;

import entities.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import screens.userRegisterScreen.MockUserMap;
import screens.userRegisterScreen.UserRegisterController;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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

        presenter = new UserRegisterPresenter() {
            @Override
            public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user) {
                assertEquals("manav", user.getLogin());
                assertNotNull(user.getCreationTime()); // any creation time is fine.
                assertTrue(userRepository.existsByEmail("manav@gmail.com"));
                return null;
            }

            @Override
            public UserRegisterResponseModel prepareFailView(String error) {
                fail("Unexpected Use case failure");
                return null;
            }
        };

        userFactory = new UserFactory();

        interactor = new UserRegisterInteractor(userRepository, presenter, userFactory);

        controller = new UserRegisterController(interactor);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createIndividualUser() {
        controller.create("manav@gmail.com", "password", "password", "manav");
    }

    @Test
    void createDealershipUser() {
        controller.create("manav@gmail.com", "password", "password", "manav", "M5S1J4");
    }
}