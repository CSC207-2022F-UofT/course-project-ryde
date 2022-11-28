package useCases.createListing;

/**
 * the interface that the interactor implements for the dependency inversion principle
 */
public interface CreateListingInputBoundary {
    /**
     * @param createListingRequestModel listing input that the user wants to create
     */
    void create(CreateListingRequestModel createListingRequestModel);
}
