import entities.UserFactory;
import interface_adapters.user_register.FileUser;
import interface_adapters.user_register.UserCreationFailed;
import interface_adapters.user_register.UserRegisterController;
import interface_adapters.user_register.UserRegisterResponseFormatter;
import screens.RegisterScreen;
import screens.WelcomeScreen;
import use_cases.user_register.UserRegisterDsGateway;
import use_cases.user_register.UserRegisterInputBoundary;
import use_cases.user_register.UserRegisterInteractor;
import use_cases.user_register.UserRegisterPresenter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        RegisterScreen registerScreen = getRegisterScreen();
        WelcomeScreen welcomeScreen = new WelcomeScreen(registerScreen);
        welcomeScreen.setVisible(true);
    }

    private static RegisterScreen getRegisterScreen() {
        UserRegisterDsGateway user;
        try {
            user = new FileUser("./users.csv");
        } catch (IOException e) {
            throw new UserCreationFailed("Could not create file.");
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
