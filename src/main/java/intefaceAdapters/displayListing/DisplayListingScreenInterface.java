package intefaceAdapters.displayListing;

import useCases.displayListing.DisplayListingDsRequestModel;
import useCases.displayListing.DisplayListingResponseModel;

public interface DisplayListingScreenInterface {
    void displayListing(DisplayListingDsRequestModel filteredListings);

    void displayMessage(String message);
}
