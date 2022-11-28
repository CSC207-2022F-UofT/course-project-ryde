package intefaceAdapters.createListing;

import useCases.createListing.CreateListingDsGateway;
import useCases.createListing.CreateListingDsRequestModel;

import java.util.HashMap;
import java.util.Map;

/**
 * the class implements the DsGateway for testing purposes.
 */
public class MockListingRepo implements CreateListingDsGateway {
    private final Map<String, CreateListingDsRequestModel> listingsMap = new HashMap<>();
    @Override
    public void save(CreateListingDsRequestModel createListingDsRequestModel) {
        listingsMap.put(createListingDsRequestModel.getName(), createListingDsRequestModel);
    }

    public boolean exists(String name) {
        return listingsMap.containsKey(name);
    }
}
