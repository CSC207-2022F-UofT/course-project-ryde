package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListingCRUDScreen extends JPanel implements ActionListener {

    public ListingCRUDScreen() {
        JPanel buttons = new JPanel();
        JButton createListing = new JButton("Create Listing");
        JButton browseListings = new JButton("Browse Listings");
        JButton removeListings = new JButton("Remove Listings");

        buttons.add(createListing);
        buttons.add(browseListings);
        buttons.add(removeListings);
        this.add(buttons);
        createListing.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateListingScreen createListingScreen = new CreateListingScreen();
        this.add(createListingScreen);
    }
}
