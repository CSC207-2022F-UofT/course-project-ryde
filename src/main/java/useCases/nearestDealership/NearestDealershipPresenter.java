package useCases.nearestDealership;

public interface NearestDealershipPresenter {
    void displayNearestDealership(NearestDealershipResponseModel response);
    void sendFailureMessage(String failure);
}
