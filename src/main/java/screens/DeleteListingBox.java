package screens;

import interface_adapters.delete_listing.DeleteListingController;
import use_cases.delete_listing.DeleteListingDsRequestModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListingBox extends JPanel implements ActionListener {
    private final DeleteListingController controller;
    private final DeleteListingDsRequestModel listing;
    public DeleteListingBox(DeleteListingDsRequestModel ds, DeleteListingController controller) {
        this.controller = controller;
        this.listing = ds;
        Border blackline = BorderFactory.createLineBorder(Color.black);
        String carNameYear = String.format("<h2>%s %s - %s</h2>", listing.getBrand(), listing.getName(), listing.getYear());
        String color = String.format("<p><b>Color:</b> %s</p>", listing.getColor());
        String numSeats = String.format("<p><b>Number of Seats:</b> %s</p>", listing.getNumSeats());
        String price = String.format("<p><b>Price:</b> $%s</p>", listing.getPrice());
        String description = String.format("<p><b>Description:</b> %s</p>", listing.getDescription());
        String type = String.format("<p><b>Type:</b> %s</p>", listing.getType());
        String content = String.format("<html>%s%s%s%s%s%s</html>",
                carNameYear, color, numSeats, price, type, description);
        JLabel show = new JLabel(content);
        JButton delete = new JButton("Delete Listing");
        delete.addActionListener(this);
        this.add(show);
        this.add(delete);
        this.setBorder(blackline);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.deleteUserListing(listing.getUuid());
    }
}
