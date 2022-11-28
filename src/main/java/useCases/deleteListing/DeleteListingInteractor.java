package useCases.deleteListing;

import entities.LoggedInUserSingleton;
import intefaceAdapters.deleteListing.DeleteListingRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteListingInteractor implements DeleteListingInputBoundary{
    private final DeleteListingDsGateway gateway;
    private final DeleteListingPresenter presenter;

    public DeleteListingInteractor(DeleteListingPresenter presenter, DeleteListingDsGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

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

    @Override
    public void deleteListing(DeleteListingRequestModel deleteListingRequestModel) {
        String output = gateway.deleteListing(deleteListingRequestModel.getUuid());
        presenter.deletedListingMessage(String.format("Successfully deleted %s listing!", output));
    }
}
