package screens;

import entities.UserFactory;
import screens.userLoginScreen.LoginUserScreen;
import screens.userRegisterScreen.FileUser;
import screens.userRegisterScreen.RegisterScreen;
import screens.userRegisterScreen.UserRegisterController;
import screens.userRegisterScreen.UserRegisterResponseFormatter;
import useCases.userRegister.UserRegisterDsGateway;
import useCases.userRegister.UserRegisterInputBoundary;
import useCases.userRegister.UserRegisterInteractor;
import useCases.userRegister.UserRegisterPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

// Frameworks/Drivers layer

public class WelcomeScreen extends JFrame implements ActionListener {

    /**
     * A window with a title and a JButton.
     */
    public WelcomeScreen() {

        JLabel title = new JLabel("Welcome Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logIn = new JButton("Log in");
        JButton signUp = new JButton("Sign up");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(signUp);

        logIn.addActionListener(this);
        signUp.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Sign up")) {
            buildRegisterScreen();
        }
        if (evt.getActionCommand().equals("Log in")) {
            buildLoginScreen();
        }
    }

    public void buildLoginScreen() {
        LoginUserScreen loginUserScreen = new LoginUserScreen();
        this.setContentPane(loginUserScreen);
        this.pack();
    }
    public void buildRegisterScreen() {
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
        RegisterScreen registerScreen = new RegisterScreen(userRegisterController);
        this.setContentPane(registerScreen);
        this.pack();
    }
}
