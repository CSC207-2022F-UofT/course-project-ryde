package screens;

import intefaceAdapters.createListing.CreateListingController;
import intefaceAdapters.createListing.CreateListingResponseFormatter;
import intefaceAdapters.createListing.CreateListingScreenInterface;
import useCases.createListing.CreateListingPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateListingScreen extends JPanel implements ActionListener, CreateListingScreenInterface {
    private final JTextField brand = new JTextField(25);
    private final JTextField name = new JTextField(25);
    private final JTextField color = new JTextField(25);
    private final JTextField year = new JTextField(25);
    private final String[] seats = {"2", "3", "4", "5", "6", "7",  "8"};
    private final JComboBox<String> seatList = new JComboBox<>(seats);
    private final JTextField price = new JTextField(25);
    private final JTextField phoneNumber = new JTextField(25);
    private final JTextArea description = new JTextArea(5, 20);
    private final String[] types = {"Used", "New", "Rent"};
    private final JComboBox<String> typeList = new JComboBox<>(types);

    private final CreateListingController controller;

    public CreateListingScreen() {
        JLabel title = new JLabel("Add New Listing Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel brandInfo = new LabelTextPanel(
                new JLabel("Car Brand"), brand);
        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Car Model"), name);
        LabelTextPanel colorInfo = new LabelTextPanel(
                new JLabel("Car Color"), color);
        LabelTextPanel yearInfo = new LabelTextPanel(
                new JLabel("Car year"), year);
        LabelTextPanel numSeatsInfo = new LabelTextPanel(
                new JLabel("Number of Seats"), seatList);
        LabelTextPanel priceInfo = new LabelTextPanel(
                new JLabel("Price"), price);
        LabelTextPanel phoneNumberInfo = new LabelTextPanel(
                new JLabel("Enter Phone Number"), phoneNumber);
        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel("Description"), description);
        LabelTextPanel typeInfo = new LabelTextPanel(
                new JLabel("Type"), typeList);
        JButton createListing = new JButton("Create Listing");
        JPanel buttons = new JPanel();
        buttons.add(createListing);
        createListing.addActionListener(this);
        this.add(title);
        this.add(brandInfo);
        this.add(nameInfo);
        this.add(colorInfo);
        this.add(yearInfo);
        this.add(priceInfo);
        this.add(phoneNumberInfo);
        this.add(descriptionInfo);
        this.add(buttons);

        CreateListingPresenter presenter = new CreateListingResponseFormatter(this);
        controller = new CreateListingController(presenter);
    }

    @Override
    public void showCreatedListingMessage(String message) {
        JOptionPane.showMessageDialog(this, message);

    }

    @Override
    public void showCreatedListingMessageFailure(String error) {
        JOptionPane.showMessageDialog(this, error);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.executeInteractor(brand.getText(), name.getText(), color.getText(), Integer.parseInt(year.getText()),
                Integer.parseInt(seats[seatList.getSelectedIndex()]), Float.parseFloat(price.getText()),
                phoneNumber.getText(), description.getText(), types[typeList.getSelectedIndex()]);
    }
}
