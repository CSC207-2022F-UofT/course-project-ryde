package useCases.nearestDealership;

import java.util.List;

public interface NearestDealershipDsGateway {
    List<DealershipDsRequestModel> getDealerships();
}
