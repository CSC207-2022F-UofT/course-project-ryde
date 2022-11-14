package useCases.deleteListing;

import useCases.displayListing.DisplayListingRequestModel;

public interface DeleteListingInputBoundary {
    void displayListings();
    void deleteListing(DeleteListingRequestModel deleteListingRequestModel);
}
