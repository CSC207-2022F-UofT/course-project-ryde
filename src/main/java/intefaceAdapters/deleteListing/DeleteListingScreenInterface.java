package intefaceAdapters.deleteListing;

import useCases.deleteListing.DeleteListingDsRequestModel;

import java.util.List;

public interface DeleteListingScreenInterface {
    void displayUserListings(List<DeleteListingDsRequestModel> listings);
    void showDeletedMessage(String message);
    void showFailerMessage(String message);
}
