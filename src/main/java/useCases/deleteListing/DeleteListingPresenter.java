package useCases.deleteListing;

public interface DeleteListingPresenter {
    void displayUserListings(DeleteListingResponseModel responseModel);
    void deletedListingMessage(String message);
}
