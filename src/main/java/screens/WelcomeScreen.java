package screens;

import intefaceAdapters.userLogin.FindUser;
import intefaceAdapters.userRegister.FileUser;
import useCases.userLogin.UserLoginDsGateway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

// Frameworks/Drivers layer

public class WelcomeScreen extends JFrame implements ActionListener {
    private final JPanel main;

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

        main = new JPanel();
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
            this.dispose();
            setCRUDScreen();
        }
        if (evt.getActionCommand().equals("Go Back") || evt.getActionCommand().equals("Exit")) {
            this.setContentPane(main);
            this.pack();
        }
        System.out.println(evt.getActionCommand());
    }

    private void setLoginScreen() {
        UserLoginDsGateway gateway;
        try {
            gateway = new FindUser("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file.");
        }
        UserLoginScreen loginUserScreen = new UserLoginScreen(gateway);
        this.setContentPane(loginUserScreen);
        loginUserScreen.getContinueButton().addActionListener(this);
        loginUserScreen.getExitLoginButton().addActionListener(this);
        this.pack();
    }
    private void setRegisterScreen(RegisterScreen registerScreen) {
        this.setContentPane(registerScreen);
        registerScreen.getBackButton().addActionListener(this);
        this.pack();
    }

    private void setCRUDScreen() {
        ListingCRUDScreen listingCRUDScreen = new ListingCRUDScreen();
        listingCRUDScreen.setVisible(true);
    }
}
