package intefaceAdapters.nearestDealership;

import useCases.nearestDealership.NearestDealershipPresenter;
import useCases.nearestDealership.NearestDealershipResponseModel;

public class NearestDealershipResponseFormatter implements NearestDealershipPresenter {
    private final NearestDealershipScreenInterface view;

    public NearestDealershipResponseFormatter(NearestDealershipScreenInterface view) {
        this.view = view;
    }

    /**
     * @param response contains details about the nearest dealership
     */
    @Override
    public void displayNearestDealership(NearestDealershipResponseModel response) {
        String res = String.format("The nearest dealership is %s located at %s. " +
                "It is %s away from you and should only take you %s to get there!", response.getName(),
                response.getLocation(), response.getDistance(), response.getDuration());
        view.showDealership(res);
    }

    /**
     * @param failure this is message with the reason why a nearest dealership was not returned
     */
    @Override
    public void sendFailureMessage(String failure) {
        view.showFailure(failure);
    }
}
