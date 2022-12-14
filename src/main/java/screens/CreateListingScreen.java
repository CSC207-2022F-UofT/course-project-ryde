package screens;

import entities.ListingFactory;
import interface_adapters.create_listing.*;
import use_cases.create_listing.CreateListingDsGateway;
import use_cases.create_listing.CreateListingPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
    public final JButton goBack;

    public CreateListingScreen() {
        renderCreateListingComponents();
        goBack = createBackButton();

        CreateListingPresenter presenter = new CreateListingResponseFormatter(this);
        ListingFactory listingFactory = new ListingFactory();
        CreateListingDsGateway gateway;
        try {
            gateway = new ListingRepo("./listings.csv");
        } catch (IOException e) {
            throw new ListingCreationFailed("Could not find file");
        }
        controller = new CreateListingController(presenter, listingFactory, gateway);
    }

    private JButton createBackButton() {
        final JButton back;
        back = new JButton("Go Back");
        back.addActionListener(this);
        JPanel backButton = new JPanel();
        backButton.add(back);
        this.add(backButton);
        return back;
    }

    private void renderCreateListingComponents() {
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(brandInfo);
        this.add(nameInfo);
        this.add(colorInfo);
        this.add(yearInfo);
        this.add(priceInfo);
        this.add(phoneNumberInfo);
        this.add(descriptionInfo);
        this.add(numSeatsInfo);
        this.add(typeInfo);
        this.add(buttons);
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
        if (e.getActionCommand().equals("Create Listing")) {
            controller.executeInteractor(brand.getText(), name.getText(), color.getText(), year.getText(),
                    Integer.parseInt(seats[seatList.getSelectedIndex()]), price.getText(),
                    phoneNumber.getText(), description.getText(), types[typeList.getSelectedIndex()]);
        }
    }

    public JButton getBackButton() {
        return goBack;
    }
}
