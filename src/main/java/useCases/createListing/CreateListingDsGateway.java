package useCases.createListing;

/** this is the interface for the ListingRepo which saves the listings in the database */
public interface CreateListingDsGateway {
    /**
     * @param createListingDsRequestModel model that stores the listing to be created
     * saves the listing to the database
     */
    void save (CreateListingDsRequestModel createListingDsRequestModel);
}
