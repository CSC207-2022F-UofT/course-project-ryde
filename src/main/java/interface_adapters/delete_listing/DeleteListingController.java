package interface_adapters.delete_listing;

import use_cases.delete_listing.DeleteListingDsGateway;
import use_cases.delete_listing.DeleteListingInteractor;
import use_cases.delete_listing.DeleteListingPresenter;
import use_cases.delete_listing.DeleteListingRequestModel;

public class DeleteListingController {
    private final DeleteListingInteractor interactor;

    /**
     * @param presenter The presenter that communicates the view to tell it what to display
     * @param gateway the gateway that makes changes to the database of listings
     */
    public DeleteListingController(DeleteListingPresenter presenter, DeleteListingDsGateway gateway) {
        this.interactor = new DeleteListingInteractor(presenter, gateway);
    }

    /**
     * tells the interactor to display the listings of the user that is logged in
     */
    public void displayUserListings(){
        interactor.displayListings();
    }

    /**
     * @param uuid Unique ID assigned to each listing
     * Tells the interactor to delete the listing of the user with the uuid
     */
    public void deleteUserListing(String uuid) {
        DeleteListingRequestModel requestModel = new DeleteListingRequestModel(uuid);
        interactor.deleteListing(requestModel);
    }
}
