package useCases.nearestDealership;

import intefaceAdapters.nearestDealership.NearestDealershipApiGateway;

import java.util.List;

public class NearestDealershipInteractor implements NearestDealershipInputBoundary {
    private final NearestDealershipPresenter presenter;
    private final NearestDealershipDsGateway dealershipDsGateway;

    private final NearestDealershipApiGateway apiGateway;

    public NearestDealershipInteractor(NearestDealershipPresenter presenter, NearestDealershipDsGateway dealershipDsGateway) {
        this.presenter = presenter;
        this.dealershipDsGateway = dealershipDsGateway;
        this.apiGateway = new NearestDealershipApi();
    }

    @Override
    public void getNearestDealership(NearestDealershipRequestModel requestModel) {
        if (!isValidLocation(requestModel.getUserLocation())){
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

    private boolean isValidLocation(String code) {
        if (code.length() != 6) {
            return false;
        }
        boolean first = code.startsWith("M");
        boolean second = Character.isDigit(code.charAt(1));
        boolean third = Character.isUpperCase(code.charAt(2));
        boolean fourth = Character.isDigit(code.charAt(3));
        boolean fifth = Character.isUpperCase(code.charAt(4));
        boolean sixth = Character.isDigit(code.charAt(5));
        return first && second && third && fourth && fifth && sixth;
    }
}
