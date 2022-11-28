package useCases.displayListing;

import java.util.List;

public class DisplayListingResponseModel {
    private final List<DisplayListingDsRequestModel> filteredListings;

    public DisplayListingResponseModel(List<DisplayListingDsRequestModel> filteredListings) {
        this.filteredListings = filteredListings;
    }

    public List<DisplayListingDsRequestModel> getFilteredListings() {
        return filteredListings;
    }
}
