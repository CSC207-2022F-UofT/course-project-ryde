package use_cases.nearest_dealership;

/**
 * Interface for the ResponseFormatter
 */
public interface NearestDealershipPresenter {
    /**
     * @param response contains details about the nearest dealership
     * this method tells the view to display details about the nearest dealership to the user
     */
    void displayNearestDealership(NearestDealershipResponseModel response);

    /**
     * @param failure this is message with the reason why a nearest dealership was not returned
     * tells the view to show the user the failure message
     */
    void sendFailureMessage(String failure);
}
