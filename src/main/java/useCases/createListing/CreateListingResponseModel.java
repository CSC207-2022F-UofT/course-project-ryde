package useCases.createListing;

/**
 * class that sends the response to the user after they create the listing
 */
public class CreateListingResponseModel {
    private final String responseMessage;

    /**
     * @param responseMessage the response message the user sees
     */
    public CreateListingResponseModel(String responseMessage) {
        this.responseMessage = responseMessage;
    }


    /**
     * @return the response message to the user
     */
    public String getResponseMessage() {
        return responseMessage;
    }
}
