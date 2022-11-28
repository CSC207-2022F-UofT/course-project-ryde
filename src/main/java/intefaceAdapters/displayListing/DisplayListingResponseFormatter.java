package intefaceAdapters.displayListing;

import useCases.displayListing.DisplayListingDsRequestModel;
import useCases.displayListing.DisplayListingPresenter;
import useCases.displayListing.DisplayListingResponseModel;

import java.util.List;

public class DisplayListingResponseFormatter implements DisplayListingPresenter {
    private final DisplayListingScreenInterface displayListingView;

    /**
     * @param displayListingView the GUI that allows the user to interact with the program
     */
    public DisplayListingResponseFormatter(DisplayListingScreenInterface displayListingView) {
        this.displayListingView = displayListingView;
    }

    /**
     * @param responseModel responseModel for the filtered listings.
     * Tells the view to display the filtered listings.
     */
    @Override
    public void displayFilteredListings(DisplayListingResponseModel responseModel) {
        List<DisplayListingDsRequestModel> filteredListings = responseModel.getFilteredListings();
        displayListingView.displayListing(filteredListings);
    }

    /**
     * @param message failure message
     * Tells the view to display the failure message when there are no listings to be displayed.
     */
    @Override
    public void sendFailureMessage(String message) {
        displayListingView.displayMessage(message);
    }
}
