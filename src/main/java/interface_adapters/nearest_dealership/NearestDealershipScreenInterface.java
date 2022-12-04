package interface_adapters.nearest_dealership;

/**
 * An interface for the NearestDealershipScreen
 */
public interface NearestDealershipScreenInterface {
    /**
     * @param message details about the dealership, its location, how far it is, and how long it takes to get there.
     * Shows message to the user
     */
    void showDealership(String message);

    /**
     * @param message details about why there was no nearest dealership returned
     * shows message to the user
     */
    void showFailure(String message);
}
