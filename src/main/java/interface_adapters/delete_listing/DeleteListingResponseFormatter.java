package interface_adapters.delete_listing;

import use_cases.delete_listing.DeleteListingDsRequestModel;
import use_cases.delete_listing.DeleteListingPresenter;
import use_cases.delete_listing.DeleteListingResponseModel;

import java.util.List;

public class DeleteListingResponseFormatter implements DeleteListingPresenter {
    private final DeleteListingScreenInterface view;

    /**
     * @param view The delete listing screen
     */
    public DeleteListingResponseFormatter(DeleteListingScreenInterface view) {
        this.view = view;
    }

    /**
     * @param responseModel stores the message and request model
     */
    @Override
    public void displayUserListings(DeleteListingResponseModel responseModel) {
        List<DeleteListingDsRequestModel> listings = responseModel.getRequestModel();
        view.displayUserListings(listings);
    }

    /**
     * @param message this is the message to show after the user has deleted a listing
     */
    @Override
    public void deletedListingMessage(String message) {
        view.showDeletedMessage(message);
    }
}
