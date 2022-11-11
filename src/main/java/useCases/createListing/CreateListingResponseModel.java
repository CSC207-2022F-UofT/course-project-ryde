package useCases.createListing;

public class CreateListingResponseModel {
    private final String responseMessage;

    public CreateListingResponseModel(String responseMessage) {
        this.responseMessage = responseMessage;
    }


    public String getResponseMessage() {
        return responseMessage;
    }
}
