package intefaceAdapters.displayListing;

import useCases.displayListing.DisplayListingDsRequestModel;

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
