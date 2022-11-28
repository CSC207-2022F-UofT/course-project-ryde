package useCases.deleteListing;

public interface DeleteListingPresenter {
    /**
     * @param responseModel Displays the users listings
     */
    void displayUserListings(DeleteListingResponseModel responseModel);

    /**
     * @param message Shows the message after the user has deleted a listing
     */
    void deletedListingMessage(String message);
}
