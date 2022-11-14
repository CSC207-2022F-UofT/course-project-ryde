package useCases.deleteListing;

import useCases.displayListing.DisplayListingDsRequestModel;

import java.util.List;
import java.util.Map;

public interface DeleteListingDsGateway {
    void deleteListing(String uuid);
    Map<String, DeleteListingDsRequestModel> getListings();
}
