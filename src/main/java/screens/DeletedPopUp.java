package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletedPopUp extends JDialog implements ActionListener {
    private final JButton contButton;

    public DeletedPopUp(String message) {
        setBounds(100, 100, 200, 100);
        System.out.println("you are here");
        JLabel label = new JLabel(message);
        contButton = new JButton("Continue to Home");
        contButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(contButton);
        panel.setVisible(true);
        this.add(panel);
    }

    public JButton getContButton() {
        return contButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
