package useCases.displayListing;

import java.util.List;

/**
 * This is the interface for the DisplayListingRepo that talks to the listings database
 */

public interface DisplayListingDsGateway {
    /**
     * @return Return all the listings in the database.
     */
    List<DisplayListingDsRequestModel> getListings();
}
