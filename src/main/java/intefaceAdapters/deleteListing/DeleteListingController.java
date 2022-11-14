package intefaceAdapters.deleteListing;

import useCases.deleteListing.DeleteListingInteractor;
import useCases.deleteListing.DeleteListingPresenter;
import useCases.deleteListing.DeleteListingRequestModel;
import useCases.deleteListing.DeleteListingResponseModel;

public class DeleteListingController {
    private final DeleteListingInteractor interactor;

    public DeleteListingController(DeleteListingPresenter presenter) {
        this.interactor = new DeleteListingInteractor(presenter);
    }

    public void displayUserListings(){
        interactor.displayListings();
    }

    public void deleteUserListing(String uuid) {
        DeleteListingRequestModel requestModel = new DeleteListingRequestModel(uuid);
        interactor.deleteListing(requestModel);
    }
}
