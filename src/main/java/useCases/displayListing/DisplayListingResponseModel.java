package useCases.displayListing;

import java.util.List;

/**
 * A response model that stores the filtered listings as per the filters inputted by the user.
 */
public class DisplayListingResponseModel {
    private final List<DisplayListingDsRequestModel> filteredListings;

    /**
     * @param filteredListings filtered listings
     */
    public DisplayListingResponseModel(List<DisplayListingDsRequestModel> filteredListings) {
        this.filteredListings = filteredListings;
    }

    /**
     * @return filtered listings
     */
    public List<DisplayListingDsRequestModel> getFilteredListings() {
        return filteredListings;
    }
}
