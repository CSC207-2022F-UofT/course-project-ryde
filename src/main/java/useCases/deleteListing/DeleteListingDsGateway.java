package useCases.deleteListing;

import java.util.Map;

public interface DeleteListingDsGateway {
    /**
     * @param uuid Unique ID of the listing that is to be deleted
     * @return displays that the listing has been deleted
     */
    String deleteListing(String uuid);
    Map<String, DeleteListingDsRequestModel> getListings();
}
