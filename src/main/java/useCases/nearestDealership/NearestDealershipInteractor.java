package useCases.nearestDealership;

import entities.LoggedInUserSingleton;
import intefaceAdapters.nearestDealership.NearestDealershipApi;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern zipCode = Pattern.compile("^M\\d[A-Z]\\d[A-Z]\\d$");
        Matcher matcher = zipCode.matcher(code);
        return matcher.find();
    }

}
