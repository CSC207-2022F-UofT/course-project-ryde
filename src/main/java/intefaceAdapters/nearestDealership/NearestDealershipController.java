package intefaceAdapters.nearestDealership;

import useCases.nearestDealership.*;

public class NearestDealershipController {
    private final NearestDealershipInputBoundary interactor;

    public NearestDealershipController(NearestDealershipPresenter presenter, NearestDealershipDsGateway gateway, NearestDealershipApiGateway apiGateway) {
        this.interactor = new NearestDealershipInteractor(presenter, gateway, apiGateway);
    }

    /**
     * @param userLocation location of the user(postal code)
     * tells the interactor to find the nearest dealership to userLocation
     */
    public void findNearestDealership(String userLocation) {
        NearestDealershipRequestModel requestModel = new NearestDealershipRequestModel(userLocation);
        interactor.getNearestDealership(requestModel);
    }
}
