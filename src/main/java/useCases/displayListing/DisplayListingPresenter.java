package useCases.displayListing;

public interface DisplayListingPresenter {
    /**
     * @param responseModel responseModel for the filtered listings.
     * Tells the view to display the filtered listings.
     */
    void displayFilteredListings(DisplayListingResponseModel responseModel);

    /**
     * @param message failure message
     * Tells the view to display the failure message when there are no listings to be diplayed.
     */
    void sendFailureMessage(String message);
}
