package use_cases.nearest_dealership;

import java.util.List;

/**
 * Interface for the Dealership Repo
 */
public interface NearestDealershipDsGateway {
    /**
     * @return list of dealerships in the database
     */
    List<DealershipDsRequestModel> getDealerships();
}
