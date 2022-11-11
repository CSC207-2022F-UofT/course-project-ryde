package screens;

import intefaceAdapters.userLogin.UserLoginResponseFormatter;
import intefaceAdapters.userLogin.UserLoginScreenInterface;
import intefaceAdapters.userLogin.UserLoginController;
import useCases.userLogin.UserLoginPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginScreen extends JPanel implements ActionListener, UserLoginScreenInterface {
    private final JTextField email = new JTextField(25);
    private final JPasswordField password = new JPasswordField(15);

    private final UserLoginController controller;

    /**
     * Builds the gui for the user login screen
     */
    public UserLoginScreen() {
        JLabel title = new JLabel("Register Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel("Email"), email);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Enter password"), password);
        JButton login = new JButton("login");
        JPanel buttons = new JPanel();
        buttons.add(login);
        login.addActionListener(this);
        this.add(title);
        this.add(emailInfo);
        this.add(passwordInfo);
        this.add(buttons);

        UserLoginPresenter presenter = new UserLoginResponseFormatter(this);
        controller = new UserLoginController(presenter);

    }

    /**
     * calls the controller with the entered email and password as arguments.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.callUserLoginInteractor(email.getText(), String.valueOf(password.getPassword()));
    }

    /**
     * displays message dialog when login is successful.
     * @param loginMessage the view to be displayed to the user after successful log in.
     */
    @Override
    public void showLoggedInMessage(String loginMessage) {
        JOptionPane.showMessageDialog(this, loginMessage);
    }

    /**
     * displays message dialog when login fails.
     * @param errorMessage te message to be displayed to the user after failed log in.
     */
    @Override
    public void showFailureLoginMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);

    }
}
