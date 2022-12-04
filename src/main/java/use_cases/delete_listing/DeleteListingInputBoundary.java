package use_cases.delete_listing;

public interface DeleteListingInputBoundary {
    /**
     * Displays the listings of the user that is logged in
     */
    void displayListings();

    /**
     * @param deleteListingRequestModel contains details about the listing that should be deleted
     */
    void deleteListing(DeleteListingRequestModel deleteListingRequestModel);
}
