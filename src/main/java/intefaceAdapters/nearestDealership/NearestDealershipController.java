package intefaceAdapters.nearestDealership;

import useCases.nearestDealership.*;

public class NearestDealershipController {
    private final NearestDealershipInputBoundary interactor;

    public NearestDealershipController(NearestDealershipPresenter presenter, NearestDealershipDsGateway gateway) {
        this.interactor = new NearestDealershipInteractor(presenter, gateway);
    }

    public void findNearestDealership(String userLocation) {
        NearestDealershipRequestModel requestModel = new NearestDealershipRequestModel(userLocation);
        interactor.getNearestDealership(requestModel);
    }
}
