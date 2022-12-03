package screens;

import entities.LoggedInUserSingleton;
import useCases.nearestDealership.NearestDealershipRequestModel;

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
        JButton findNearestDealership = new JButton("Find Nearest Dealership");
        JButton logOut = new JButton("Log Out :(");

        buttons.add(createListing);
        buttons.add(browseListings);
        buttons.add(removeListings);
        if (!LoggedInUserSingleton.getInstance().getIsDealership()) {
            buttons.add(findNearestDealership);
        }
        buttons.add(logOut);
        this.add(buttons);

        createListing.addActionListener(this);
        browseListings.addActionListener(this);
        removeListings.addActionListener(this);
        findNearestDealership.addActionListener(this);
        logOut.addActionListener(this);

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
        if (e.getActionCommand().equals("Remove Listings")){
            setDeleteListingScreen();
        }
        if (e.getActionCommand().equals("Exit")) {
            this.setContentPane(main);
            this.pack();
        }
        if (e.getActionCommand().equals("Log Out :(")) {
            JOptionPane.showMessageDialog(this,
                    "You have been logged out. Thank you for using Ryde!");
            this.dispose();
        }
        if (e.getActionCommand().equals("Find Nearest Dealership")) {
            this.setNearestDealershipScreen();
        }
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
        displayListingScreen.exitDisplayButton().addActionListener(this);
        this.pack();
    }

    private void setDeleteListingScreen() {
        DeleteListingsScreen deleteListingScreen = new DeleteListingsScreen(this);
        this.setContentPane(deleteListingScreen);
        deleteListingScreen.getBackButton().addActionListener(this);
        this.pack();
    }

    public void comeBackScreen() {
        this.setContentPane(main);
        this.pack();
    }

    private void setNearestDealershipScreen() {
        NearestDealershipScreen nearestDealershipScreen = new NearestDealershipScreen(this);
        this.setContentPane(nearestDealershipScreen);
        this.pack();
    }
}
