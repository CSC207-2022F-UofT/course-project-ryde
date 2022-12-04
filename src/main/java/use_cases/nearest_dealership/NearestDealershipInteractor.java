package use_cases.nearest_dealership;

import entities.DealershipUser;

import java.util.List;

public class NearestDealershipInteractor implements NearestDealershipInputBoundary {
    private final NearestDealershipPresenter presenter;
    private final NearestDealershipDsGateway dealershipDsGateway;

    private final NearestDealershipApiGateway apiGateway;

    public NearestDealershipInteractor(NearestDealershipPresenter presenter, NearestDealershipDsGateway dealershipDsGateway, NearestDealershipApiGateway apiGateway) {
        this.presenter = presenter;
        this.dealershipDsGateway = dealershipDsGateway;
        this.apiGateway = apiGateway;
    }

    /**
     * @param requestModel holds the user's location
     */
    @Override
    public void getNearestDealership(NearestDealershipRequestModel requestModel){
        if (!DealershipUser.isValidLocation(requestModel.getUserLocation())){
            presenter.sendFailureMessage("Please enter a valid toronto postal code!");
            return;
        }
        List<DealershipDsRequestModel> dealerships = dealershipDsGateway.getDealerships();
        if (dealerships.isEmpty()) {
            presenter.sendFailureMessage("No Dealerships around!");
            return;
        }
        NearestDealershipResponseModel output = apiGateway.getClosestDealership(dealerships, requestModel.getUserLocation());
        presenter.displayNearestDealership(output);
    }

}
