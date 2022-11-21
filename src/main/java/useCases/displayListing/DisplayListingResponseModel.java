package useCases.displayListing;

import java.util.List;

public class DisplayListingResponseModel {
    private final String message;
    private final List<DisplayListingDsRequestModel> filteredListings;

    public DisplayListingResponseModel(String message, List<DisplayListingDsRequestModel> filteredListings) {
        this.message = message;
        this.filteredListings = filteredListings;
    }

    public String getMessage() {
        return message;
    }

    public List<DisplayListingDsRequestModel> getFilteredListings() {
        return filteredListings;
    }
}
