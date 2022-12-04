package screens;

import interface_adapters.nearest_dealership.*;
import use_cases.nearest_dealership.NearestDealershipApiGateway;
import use_cases.nearest_dealership.NearestDealershipDsGateway;
import use_cases.nearest_dealership.NearestDealershipPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NearestDealershipScreen extends JPanel implements NearestDealershipScreenInterface, ActionListener {
    private final JTextField location = new JTextField(6);
    private final NearestDealershipController controller;
    private final ListingCRUDScreen parentFrame;

    public NearestDealershipScreen(ListingCRUDScreen parent) {
        this.parentFrame = parent;
        JLabel title = new JLabel("Login");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        NearestDealershipDsGateway gateway;
        try {
            gateway = new DealershipRepo("./users.csv");
        } catch (IOException e) {
            throw new FindDealershipFailed("Could not find file.");
        }
        NearestDealershipPresenter presenter = new NearestDealershipResponseFormatter(this);
        NearestDealershipApiGateway apiGateway = new NearestDealershipApi();
        controller = new NearestDealershipController(presenter, gateway, apiGateway);

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
            parentFrame.comeBackScreen();
        }
    }
}
