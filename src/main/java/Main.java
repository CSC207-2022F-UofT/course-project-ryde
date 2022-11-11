import entities.UserFactory;
import intefaceAdapters.userRegister.FileUser;
import intefaceAdapters.userRegister.UserRegisterController;
import intefaceAdapters.userRegister.UserRegisterResponseFormatter;
import screens.RegisterScreen;
import screens.WelcomeScreen;
import useCases.userRegister.UserRegisterDsGateway;
import useCases.userRegister.UserRegisterInputBoundary;
import useCases.userRegister.UserRegisterInteractor;
import useCases.userRegister.UserRegisterPresenter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window
        RegisterScreen registerScreen = getRegisterScreen();
        WelcomeScreen welcomeScreen = new WelcomeScreen(registerScreen);
        welcomeScreen.setVisible(true);
    }

    private static RegisterScreen getRegisterScreen() {
        UserRegisterDsGateway user;
        try {
            user = new FileUser("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        UserRegisterPresenter presenter = new UserRegisterResponseFormatter();
        UserFactory userFactory = new UserFactory();
        UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                user, presenter, userFactory);
        UserRegisterController userRegisterController = new UserRegisterController(
                interactor
        );
        return new RegisterScreen(userRegisterController);
    }
}
