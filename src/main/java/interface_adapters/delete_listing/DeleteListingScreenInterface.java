package interface_adapters.delete_listing;

import use_cases.delete_listing.DeleteListingDsRequestModel;

import java.util.List;

public interface DeleteListingScreenInterface {
    /**
     * @param listings user's listings
     * This function shows the user's listings
     */
    void displayUserListings(List<DeleteListingDsRequestModel> listings);

    /**
     * @param message The message
     * This function shows the message after the user has deleted a listing
     */
    void showDeletedMessage(String message);
}
