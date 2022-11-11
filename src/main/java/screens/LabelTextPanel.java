package screens;

import javax.swing.*;

// Frameworks/Drivers layer

public class LabelTextPanel extends JPanel {
    public LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }

    public LabelTextPanel(JLabel label, JTextArea textArea) {
        this.add(label);
        this.add(textArea);
    }

    public LabelTextPanel(JLabel label, JComboBox<String> dropdown) {
        this.add(label);
        this.add(dropdown);
    }
}
