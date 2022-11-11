package screens;

import entities.UserFactory;
import intefaceAdapters.userRegister.FileUser;
import intefaceAdapters.userRegister.UserRegisterController;
import intefaceAdapters.userRegister.UserRegisterResponseFormatter;
import useCases.userRegister.UserRegisterDsGateway;
import useCases.userRegister.UserRegisterInputBoundary;
import useCases.userRegister.UserRegisterInteractor;
import useCases.userRegister.UserRegisterPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;

// Frameworks/Drivers layer

public class WelcomeScreen extends JFrame implements ActionListener {

    /**
     * A window with a title and a JButton.
     */
    private final RegisterScreen registerScreen;
    public WelcomeScreen(RegisterScreen registerScreen) {
        this.registerScreen = registerScreen;


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
     * @param evt the event to be processed
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Sign up")) {
            setRegisterScreen(registerScreen);
        }
        if (evt.getActionCommand().equals("Log in")) {
           setLoginScreen();
        }
        if (evt.getActionCommand().equals("Continue")) {
            setListingCRUDScreen();
        }
        System.out.println(evt.getActionCommand());
    }

    private void setLoginScreen() {
        UserLoginScreen loginUserScreen = new UserLoginScreen();
        this.setContentPane(loginUserScreen);
        loginUserScreen.getContinueButton().addActionListener(this);
        this.pack();
    }
    private void setRegisterScreen(RegisterScreen registerScreen) {
        this.setContentPane(registerScreen);
        this.pack();
    }

    private void setListingCRUDScreen() {
        ListingCRUDScreen listingCRUDScreen = new ListingCRUDScreen();
        this.setContentPane(listingCRUDScreen);
        this.pack();
    }
    private void setCRUDScreen() {
        ListingCRUDScreen listingCRUDScreen = new ListingCRUDScreen();
        this.setContentPane(listingCRUDScreen);
        this.pack();
    }
}
