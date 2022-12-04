package use_cases.delete_listing;

import java.util.List;

public class DeleteListingResponseModel {
    private final String message;
    private final List<DeleteListingDsRequestModel> requestModel;

    /**
     * @return The request model
     */
    public List<DeleteListingDsRequestModel> getRequestModel() {
        return requestModel;
    }

    /**
     * @param message The message that shows after the listing has been deleted
     * @param requestModel The listing that the user wants to delete
     */
    public DeleteListingResponseModel(String message, List<DeleteListingDsRequestModel> requestModel) {
        this.message = message;
        this.requestModel = requestModel;
    }

}
