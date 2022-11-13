package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListingCRUDScreen extends JFrame implements ActionListener {
    private final JPanel main;

    public ListingCRUDScreen() {
        JLabel title = new JLabel("CRUD Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        JButton createListing = new JButton("Create Listing");
        JButton browseListings = new JButton("Browse Listings");
        JButton removeListings = new JButton("Remove Listings");

        buttons.add(createListing);
        buttons.add(browseListings);
        buttons.add(removeListings);
        this.add(buttons);

        createListing.addActionListener(this);
        browseListings.addActionListener(this);

        main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create Listing")) {
            setCreateScreen();
        };
        if (e.getActionCommand().equals("Browse Listings")) {
            setDisplayListingScreen();
        }
        if (e.getActionCommand().equals("Go Back")) {
            this.setContentPane(main);
            this.pack();
        };
    }

    private void setCreateScreen() {
        CreateListingScreen createListingScreen = new CreateListingScreen();
        this.setContentPane(createListingScreen);
        createListingScreen.getBackButton().addActionListener(this);
        this.pack();
    }

    private void setDisplayListingScreen() {
        DisplayListingScreen displayListingScreen = new DisplayListingScreen();
        this.setContentPane(displayListingScreen);
        this.pack();
    }
}
