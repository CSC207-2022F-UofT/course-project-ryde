package use_cases.nearest_dealership;

import java.util.List;

/**
 * Interface for the distance API
 */
public interface NearestDealershipApiGateway {
    /**
     * @param dealerships list of dealerships in the database
     * @param userLocation postal code that the user has input
     * @return a response model that holds data about the dealership that is closest to the user
     */
    NearestDealershipResponseModel getClosestDealership(List<DealershipDsRequestModel> dealerships, String userLocation) throws InterruptedException;
}
