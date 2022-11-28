package useCases.deleteListing;

import java.util.List;

public class DeleteListingResponseModel {
    private final String message;
    private final List<DeleteListingDsRequestModel> requestModel;

    public List<DeleteListingDsRequestModel> getRequestModel() {
        return requestModel;
    }

    public DeleteListingResponseModel(String message, List<DeleteListingDsRequestModel> requestModel) {
        this.message = message;
        this.requestModel = requestModel;
    }

}
