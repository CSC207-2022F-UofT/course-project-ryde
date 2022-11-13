package intefaceAdapters.displayListing;

import useCases.displayListing.DisplayListingDsRequestModel;
import useCases.displayListing.DisplayListingPresenter;
import useCases.displayListing.DisplayListingResponseModel;

import java.util.List;

public class DisplayListingResponseFormatter implements DisplayListingPresenter {
    private final DisplayListingScreenInterface displayListingView;

    public DisplayListingResponseFormatter(DisplayListingScreenInterface displayListingView) {
        this.displayListingView = displayListingView;
    }

    @Override
    public void displayFilteredListings(DisplayListingResponseModel responseModel) {
        List<DisplayListingDsRequestModel> filteredListings = responseModel.getFilteredListings();
        String message = responseModel.getMessage();
        displayListingView.displayMessage(message);
        for (DisplayListingDsRequestModel listing :
                filteredListings) {
            displayListingView.displayListing(listing);
        }
    }

    @Override
    public void sendFailureMessage(String message) {
        displayListingView.displayMessage(message);
    }
}
