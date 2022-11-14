package intefaceAdapters.displayListing;

import useCases.displayListing.DisplayListingDsRequestModel;
import useCases.displayListing.DisplayListingResponseModel;

import java.util.List;

public interface DisplayListingScreenInterface {
    void displayListing(List<DisplayListingDsRequestModel> filteredListings);

    void displayMessage(String message);
}
