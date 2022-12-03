package useCases.nearestDealership;

import useCases.nearestDealership.DealershipDsRequestModel;
import useCases.nearestDealership.NearestDealershipResponseModel;

import java.util.List;

public interface NearestDealershipApiGateway {
    NearestDealershipResponseModel getClosestDealership(List<DealershipDsRequestModel> dealerships, String user_location);
}
