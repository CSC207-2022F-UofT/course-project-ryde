package screens.userLoginScreen;

import screens.userRegisterScreen.LabelTextPanel;
import useCases.userLogin.UserLoginPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUserScreen extends JPanel implements ActionListener, LoginUserScreenInterface {
    private final JTextField email = new JTextField(25);
    private final JPasswordField password = new JPasswordField(15);

    private final UserLoginController controller;

    public LoginUserScreen() {
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

        UserLoginPresenter presenter = new LoginUserResponseFormatter(this);
        controller = new UserLoginController(presenter);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.callUserLoginInteractor(email.getText(), String.valueOf(password.getPassword()));
    }

    @Override
    public void showLoggedInMessage(String loginMessage) {
        JOptionPane.showMessageDialog(this, loginMessage);
    }

    @Override
    public void showFailureLoginMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);

    }
}
