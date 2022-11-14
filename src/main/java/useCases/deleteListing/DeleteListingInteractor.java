package useCases.deleteListing;

import entities.LoggedInUserSingleton;
import intefaceAdapters.deleteListing.DeleteListingRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteListingInteractor implements DeleteListingInputBoundary{
    private DeleteListingDsGateway gateway;
    private final DeleteListingPresenter presenter;

    public DeleteListingInteractor(DeleteListingPresenter presenter) {
        this.presenter = presenter;
        try {
            gateway = new DeleteListingRepo("./listings.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file");
        }
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
        gateway.deleteListing(deleteListingRequestModel.getUuid());
        presenter.deletedListingMessage("Successfully deleted listing!");
    }
}
