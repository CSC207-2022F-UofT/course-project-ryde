package useCases.displayListing;

public interface DisplayListingPresenter {
    void displayFilteredListings(DisplayListingResponseModel responseModel);
    void sendFailureMessage(String message);
}
