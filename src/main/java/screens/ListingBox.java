package screens;

import use_cases.display_listing.DisplayListingDsRequestModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ListingBox extends JPanel {

    public ListingBox(DisplayListingDsRequestModel listing) {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        String carNameYear = String.format("<h2>%s %s - %s</h2>", listing.getBrand(), listing.getName(), listing.getYear());
        String color = String.format("<p><b>Color:</b> %s</p>", listing.getColor());
        String numSeats = String.format("<p><b>Number of Seats:</b> %s</p>", listing.getNumSeats());
        String price = String.format("<p><b>Price:</b> $%s</p>", listing.getPrice());
        String description = String.format("<p><b>Description:</b> %s</p>", listing.getDescription());
        String type = String.format("<p><b>Type:</b> %s</p>", listing.getType());
        String phoneNumber = String.format("<p><b>Contact:</b> %s</p>", listing.getPhoneNumber());
        String content = String.format("<html>%s%s%s%s%s%s%s</html>",
                carNameYear, color, numSeats, price, type, phoneNumber, description);
        JLabel show = new JLabel(content);
        this.add(show);
        this.setBorder(blackline);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
