package screens;

import interface_adapters.display_listing.*;
import use_cases.display_listing.DisplayListingDsGateway;
import use_cases.display_listing.DisplayListingDsRequestModel;
import use_cases.display_listing.DisplayListingPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class DisplayListingScreen extends JPanel implements ActionListener, DisplayListingScreenInterface {

    private final JTextField brand = new JTextField(25);
    private final JTextField name = new JTextField(25);
    private final JTextField color = new JTextField(25);
    private final JTextField maxYear = new JTextField(25);
    private final JTextField minYear = new JTextField(25);
    private final String[] seats = {"2", "3", "4", "5", "6", "7",  "8"};
    private final JComboBox<String> seatList = new JComboBox<>(seats);
    private final JTextField maxPrice = new JTextField(25);
    private final JTextField minPrice = new JTextField(25);

    private final JTextArea description = new JTextArea(5, 20);
    private final String[] types = {"Used", "New", "Rent"};
    private final JComboBox<String> typeList = new JComboBox<>(types);
    public final JButton back;

    private final DisplayListingController displayListingController;

    public DisplayListingScreen(){
        renderContent();
        back = createBackButton();

        DisplayListingPresenter displayListingPresenter = new DisplayListingResponseFormatter(this);
        DisplayListingDsGateway gateway;
        try {
            gateway = new DisplayListingRepo("./listings.csv");
        } catch (IOException e){
            throw new ListingDisplayFailed("Could not find file");
        }
        displayListingController = new DisplayListingController(displayListingPresenter, gateway);
    }

    private void renderContent() {
        JLabel title = new JLabel("Filter for Available Listings");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel brandInfo = new LabelTextPanel(
                new JLabel("Car Brand"), brand);
        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Car Model"), name);
        LabelTextPanel colorInfo = new LabelTextPanel(
                new JLabel("Car Color"), color);
        LabelTextPanel maxYearInfo = new LabelTextPanel(
                new JLabel("Maximum Year of Car"), maxYear);
        LabelTextPanel minYearInfo = new LabelTextPanel(
                new JLabel("Minimum Year of Car"), minYear);
        LabelTextPanel numSeatsInfo = new LabelTextPanel(
                new JLabel("Number of Seats"), seatList);
        LabelTextPanel maxPriceInfo = new LabelTextPanel(
                new JLabel("Maximum Price of Car"), maxPrice);
        LabelTextPanel minPriceInfo = new LabelTextPanel(
                new JLabel("Minimum Price of Car"), minPrice);
        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel("Description"), description);
        LabelTextPanel typeInfo = new LabelTextPanel(
                new JLabel("Type"), typeList);
        JButton searchForListings = new JButton("Search");
        JPanel buttons = new JPanel();
        buttons.add(searchForListings);
        searchForListings.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(brandInfo);
        this.add(nameInfo);
        this.add(colorInfo);
        this.add(maxYearInfo);
        this.add(minYearInfo);
        this.add(maxPriceInfo);
        this.add(minPriceInfo);
        this.add(descriptionInfo);
        this.add(numSeatsInfo);
        this.add(typeInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")) {
            displayListingController.callDisplayListingInteractor(brand.getText(), name.getText(), color.getText(),
                    maxYear.getText(), minYear.getText(),  seats[seatList.getSelectedIndex()],
                    maxPrice.getText(), minPrice.getText(), description.getText(),  types[typeList.getSelectedIndex()]);
        }
    }

    // fill out this function to complete use case.
    @Override
    public void displayListing(List<DisplayListingDsRequestModel> filteredListings) {
        JDialog dialog = new ListingsPopUp(filteredListings);
        dialog.setVisible(true);
    }

    @Override
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private JButton createBackButton() {
        final JButton goBack;
        goBack = new JButton("Exit");
        goBack.addActionListener(this);
        JPanel backButton = new JPanel();
        backButton.add(goBack);
        this.add(backButton);
        return goBack;
    }

    public JButton exitDisplayButton() {
        return back;
    }
}
