package screens;

import useCases.displayListing.DisplayListingDsRequestModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListingsPopUp extends JDialog{

    public ListingsPopUp(List<DisplayListingDsRequestModel> filteredListings) {
        setBounds(100, 100, 450, 300);

        JScrollPane scrollPane = new JScrollPane();
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel contentPanel = new JPanel();
        for (DisplayListingDsRequestModel listing :
                filteredListings) {
            JPanel box = new ListingBox(listing);
            contentPanel.add(box);
        }
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollPane.setViewportView(contentPanel);
    }
}
