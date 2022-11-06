package screens.userRegisterScreen;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterScreen extends JPanel implements ActionListener{
    JTextField email = new JTextField(25);
    JTextField name = new JTextField(25);
    JPasswordField password = new JPasswordField(15);
    JPasswordField repeatPassword = new JPasswordField(15);
    String location;
    JRadioButton rb1,rb2;

    UserRegisterController userRegisterController;

    public RegisterScreen(UserRegisterController controller) {

        this.userRegisterController = controller;

        JLabel title = new JLabel("Register Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel("Email"), email);
        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Full Name"), name);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Choose password"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel("Enter password again"), repeatPassword);
        rb1=new JRadioButton("Individual");
        rb1.setBounds(100,50,100,30);
        rb2=new JRadioButton("Dealership");
        rb2.setBounds(100,100,100,30);
        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);bg.add(rb2);

        JButton signUp = new JButton("Sign up");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(cancel);

        signUp.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(emailInfo);
        this.add(nameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(rb1);
        this.add(rb2);
        this.add(buttons);

    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        if (rb2.isSelected()) {
            location = JOptionPane.showInputDialog(this,"Enter your postal code:");
            try {
                userRegisterController.create(email.getText(),
                        String.valueOf(password.getPassword()),
                        String.valueOf(repeatPassword.getPassword()),
                        String.valueOf(name.getText()),
                        location);
                String output = String.format("%s Dealership created.", name.getText());
                JOptionPane.showMessageDialog(this, output);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            try {
                userRegisterController.create(email.getText(),
                        String.valueOf(password.getPassword()),
                        String.valueOf(repeatPassword.getPassword()),
                        String.valueOf(name.getText()));
                String output = String.format("%s Individual created.", name.getText());
                JOptionPane.showMessageDialog(this, output);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

}
