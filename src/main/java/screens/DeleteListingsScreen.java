package screens;

import intefaceAdapters.deleteListing.DeleteListingController;
import intefaceAdapters.deleteListing.DeleteListingResponseFormatter;
import intefaceAdapters.deleteListing.DeleteListingScreenInterface;
import useCases.deleteListing.DeleteListingDsRequestModel;
import useCases.deleteListing.DeleteListingPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteListingsScreen extends JPanel implements DeleteListingScreenInterface, ActionListener {
    private final DeleteListingController controller;
    private final JPanel contentPanel;
    private final JButton exit;
    private final ListingCRUDScreen parent;


    public DeleteListingsScreen(ListingCRUDScreen parent) {
        this.parent = parent;
        JLabel title = new JLabel("My Listings");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        setBounds(100, 100, 450, 300);

        JScrollPane scrollPane = new JScrollPane();
        this.add(scrollPane, BorderLayout.CENTER);

        contentPanel = new JPanel();

        DeleteListingPresenter presenter = new DeleteListingResponseFormatter(this);
        this.controller = new DeleteListingController(presenter);
        controller.displayUserListings();
        exit = new JButton("Go Back");
        this.add(exit);
    }

    @Override
    public void displayUserListings(List<DeleteListingDsRequestModel> listings) {
        if (listings.isEmpty()) {
            JLabel msg = new JLabel("<html><h1>You have no listings</h1></html>");
            this.add(msg);
        } else {
            for (DeleteListingDsRequestModel listing :
                    listings) {
                DeleteListingBox box = new DeleteListingBox(listing, controller);
                contentPanel.add(box);
            }
            JScrollPane scrollPane = new JScrollPane();
            this.add(scrollPane, BorderLayout.CENTER);
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            scrollPane.setViewportView(contentPanel);
        }


    }

    @Override
    public void showDeletedMessage(String message) {
        DeletedPopUp deletedPopUp = new DeletedPopUp(message);
        deletedPopUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        deletedPopUp.setVisible(true);
        deletedPopUp.getContButton().addActionListener(this);
    }

    @Override
    public void showFailerMessage(String message) {
        DeletedPopUp back = new DeletedPopUp(message);
        back.setVisible(true);
        back.getContButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.comeBackScreen();
    }

    public JButton getBackButton() {
        return exit;
    }
}
