package use_cases.nearest_dealership;

/**
 * Interface for the use case
 */
public interface NearestDealershipInputBoundary {
    /**
     * @param requestModel holds the user's location
     * tells the presenter to show the user the nearest dealership
     */
    void getNearestDealership(NearestDealershipRequestModel requestModel);
}
