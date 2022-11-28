package useCases.createListing;

/**
 * interface that the CreateListingResponseFormatter implements for the dependency inversion principle.
 */
public interface CreateListingPresenter {
    /**
     * @param listing listing which is successfully created by the user
     */
    void prepareSuccessView(CreateListingResponseModel listing);

    /**
     * @param error error message shown to the user when the creation of the listing is unsuccessful
     */
    void prepareFailView(String error);
}
