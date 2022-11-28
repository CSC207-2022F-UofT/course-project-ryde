package intefaceAdapters.deleteListing;

import useCases.deleteListing.DeleteListingDsGateway;
import useCases.deleteListing.DeleteListingInteractor;
import useCases.deleteListing.DeleteListingPresenter;
import useCases.deleteListing.DeleteListingRequestModel;

public class DeleteListingController {
    private final DeleteListingInteractor interactor;

    public DeleteListingController(DeleteListingPresenter presenter, DeleteListingDsGateway gateway) {
        this.interactor = new DeleteListingInteractor(presenter, gateway);
    }

    public void displayUserListings(){
        interactor.displayListings();
    }

    public void deleteUserListing(String uuid) {
        DeleteListingRequestModel requestModel = new DeleteListingRequestModel(uuid);
        interactor.deleteListing(requestModel);
    }
}
