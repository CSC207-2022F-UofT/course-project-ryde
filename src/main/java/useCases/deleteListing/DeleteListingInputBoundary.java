package useCases.deleteListing;

public interface DeleteListingInputBoundary {
    void displayListings();
    void deleteListing(DeleteListingRequestModel deleteListingRequestModel);
}
