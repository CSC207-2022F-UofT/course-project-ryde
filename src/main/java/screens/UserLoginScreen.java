package screens;

import intefaceAdapters.userLogin.UserLoginResponseFormatter;
import intefaceAdapters.userLogin.UserLoginScreenInterface;
import intefaceAdapters.userLogin.UserLoginController;
import useCases.userLogin.UserLoginDsGateway;
import useCases.userLogin.UserLoginPresenter;
import useCases.userRegister.UserRegisterDsGateway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginScreen extends JPanel implements ActionListener, UserLoginScreenInterface {
    private final JLabel title;
    private final JTextField email = new JTextField(25);
    private final JPasswordField password = new JPasswordField(15);
    private final LabelTextPanel emailInfo;
    private final LabelTextPanel passwordInfo;
    public final JButton login;
    public final JButton continueToListings;
    public final JButton exitLogin;
    private final UserLoginController controller;

    /**
     * Builds the gui for the user login screen
     */
    public UserLoginScreen(UserLoginDsGateway gateway) {

        title = new JLabel("Login");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        emailInfo = new LabelTextPanel(
                new JLabel("Email"), email);
        passwordInfo = new LabelTextPanel(
                new JLabel("Enter password"), password);
        login = new JButton("login User");
        continueToListings = new JButton("Continue");
        JPanel continueButton = new JPanel();
        continueButton.add(continueToListings);
        exitLogin = new JButton("Exit");
        JPanel exitLoginButton = new JPanel();
        continueButton.add(exitLogin);
        JPanel buttons = new JPanel();
        buttons.add(login);
        login.addActionListener(this);
        continueToListings.addActionListener(this);
        continueToListings.setVisible(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(emailInfo);
        this.add(passwordInfo);
        this.add(buttons);
        this.add(continueButton);
        this.add(exitLoginButton);

        UserLoginPresenter presenter = new UserLoginResponseFormatter(this);
        controller = new UserLoginController(presenter, gateway);

    }

    /**
     * calls the controller with the entered email and password as arguments.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("login User")) {
            controller.callUserLoginInteractor(email.getText(), String.valueOf(password.getPassword()));
        }
    }

    /**
     * displays message dialog when login is successful.
     * @param loginMessage the view to be displayed to the user after successful log in.
     */
    @Override
    public void showLoggedInMessage(String loginMessage) {
        JOptionPane.showMessageDialog(this, loginMessage);
        login.setVisible(false);
        emailInfo.setVisible(false);
        passwordInfo.setVisible(false);
        title.setVisible(false);
        continueToListings.setVisible(true);
        this.revalidate();
    }

    /**
     * displays message dialog when login fails.
     * @param errorMessage te message to be displayed to the user after failed log in.
     */
    @Override
    public void showFailureLoginMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);

    }

    public JButton getContinueButton() {
        return continueToListings;
    }

    public JButton getExitLoginButton() { return exitLogin; }
}
