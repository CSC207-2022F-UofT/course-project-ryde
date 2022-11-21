package useCases.deleteListing;

import java.util.Map;

public interface DeleteListingDsGateway {
    String deleteListing(String uuid);
    Map<String, DeleteListingDsRequestModel> getListings();
}
