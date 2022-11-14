package useCases.deleteListing;

public interface DeleteListingPresenter {
    void displayUserListings(DeleteListingResponseModel responseModel);
    void sendFailureMessage(String message);
    void deletedListingMessage(String message);
}
