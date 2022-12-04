package use_cases.delete_listing;

import entities.LoggedInUserSingleton;
import java.util.ArrayList;
import java.util.List;

public class DeleteListingInteractor implements DeleteListingInputBoundary{
    private final DeleteListingDsGateway gateway;
    private final DeleteListingPresenter presenter;

    /**
     * @param presenter response formatter that talks to the
     * @param gateway It is the DeleteListingRepo
     */
    public DeleteListingInteractor(DeleteListingPresenter presenter, DeleteListingDsGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    /**
     * tells the presenter to display the user's listings if they have any
     */
    @Override
    public void displayListings() {
        List<DeleteListingDsRequestModel> userListings = new ArrayList<>();
        for (DeleteListingDsRequestModel listing :
                gateway.getListings().values()) {
            if(listing.getUserEmail().equals(LoggedInUserSingleton.getInstance().getEmail())){
                userListings.add(listing);
            }
        }
        DeleteListingResponseModel responseModel = new DeleteListingResponseModel("Listings found", userListings);
        presenter.displayUserListings(responseModel);
    }

    /**
     * @param deleteListingRequestModel contains details about the listing that should be deleted
     * Deletes the listing that user wanted to delete and tells the presenter to send a success message
     */
    @Override
    public void deleteListing(DeleteListingRequestModel deleteListingRequestModel) {
        String output = gateway.deleteListing(deleteListingRequestModel.getUuid());
        presenter.deletedListingMessage(String.format("Successfully deleted %s listing!", output));
    }
}
