package screens;

import intefaceAdapters.nearestDealership.DealershipRepo;
import intefaceAdapters.nearestDealership.NearestDealershipController;
import intefaceAdapters.nearestDealership.NearestDealershipResponseFormatter;
import intefaceAdapters.nearestDealership.NearestDealershipScreenInterface;
import useCases.nearestDealership.NearestDealershipDsGateway;
import useCases.nearestDealership.NearestDealershipPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NearestDealershipScreen extends JPanel implements NearestDealershipScreenInterface, ActionListener {
    private final JTextField location = new JTextField(6);
    private final NearestDealershipController controller;
    private final ListingCRUDScreen parent;

    public NearestDealershipScreen(ListingCRUDScreen parent) {
        this.parent = parent;
        JLabel title = new JLabel("Login");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        NearestDealershipDsGateway gateway;
        try {
            gateway = new DealershipRepo("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file.");
        }
        NearestDealershipPresenter presenter = new NearestDealershipResponseFormatter(this);
        controller = new NearestDealershipController(presenter, gateway);

        LabelTextPanel locationInfo = new LabelTextPanel(new JLabel("Your Postal Code"), location);
        JButton find = new JButton("Find");
        JButton back = new JButton("Back");
        JPanel buttons = new JPanel();
        buttons.add(find);
        buttons.add(back);
        this.add(locationInfo);
        this.add(buttons);
        find.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void showDealership(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void showFailure(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Find")) {
            controller.findNearestDealership(location.getText());
        }
        if (e.getActionCommand().equals("Back")) {
            System.out.println("Over here");
            parent.comeBackScreen();
        }
    }
}
