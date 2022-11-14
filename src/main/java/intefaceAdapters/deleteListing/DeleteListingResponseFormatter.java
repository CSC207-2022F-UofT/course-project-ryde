package intefaceAdapters.deleteListing;

import useCases.deleteListing.DeleteListingDsRequestModel;
import useCases.deleteListing.DeleteListingPresenter;
import useCases.deleteListing.DeleteListingResponseModel;

import java.util.List;

public class DeleteListingResponseFormatter implements DeleteListingPresenter {
    private final DeleteListingScreenInterface view;

    public DeleteListingResponseFormatter(DeleteListingScreenInterface view) {
        this.view = view;
    }

    @Override
    public void displayUserListings(DeleteListingResponseModel responseModel) {
        List<DeleteListingDsRequestModel> listings = responseModel.getRequestModel();
        view.displayUserListings(listings);
    }

    @Override
    public void sendFailureMessage(String message) {
        view.showFailerMessage(message);
    }

    @Override
    public void deletedListingMessage(String message) {
        view.showDeletedMessage(message);
    }
}
