package use_cases.display_listing;

/**
 * This is the interface for the use case interactor.
 */
public interface DisplayListingInputBoundary {
    /**
     * @param displayListingRequestModel stores the filter input by the user.
     */
    void displayListings(DisplayListingRequestModel displayListingRequestModel);
}
