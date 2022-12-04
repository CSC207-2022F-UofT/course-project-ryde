package interface_adapters.display_listing;

import use_cases.display_listing.DisplayListingDsRequestModel;

import java.util.List;

public interface DisplayListingScreenInterface {
    /**
     * @param filteredListings filtered listings
     */
    void displayListing(List<DisplayListingDsRequestModel> filteredListings);

    /**
     * @param message The failure message
     */
    void displayMessage(String message);
}
