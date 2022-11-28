package useCases.displayListing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DisplayListingInteractor implements DisplayListingInputBoundary{
    private final DisplayListingDsGateway gateway;
    private final DisplayListingPresenter presenter;

    public DisplayListingInteractor(DisplayListingPresenter presenter, DisplayListingDsGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void displayListings(DisplayListingRequestModel displayListingRequestModel) {
        List<DisplayListingDsRequestModel> listings = gateway.getListings();
        List<DisplayListingDsRequestModel> outputListings = getFilteredListings(displayListingRequestModel, listings);

        if (outputListings.size() == 0 ) {
            presenter.sendFailureMessage("No Listings found!");
        } else {
            DisplayListingResponseModel responseModel =
                    new DisplayListingResponseModel(outputListings);
            presenter.displayFilteredListings(responseModel);
        }

    }

    private static List<DisplayListingDsRequestModel> getFilteredListings(DisplayListingRequestModel displayListingRequestModel, List<DisplayListingDsRequestModel> listings) {
        String brand = displayListingRequestModel.getBrand();
        String name = displayListingRequestModel.getName();
        String color  = displayListingRequestModel.getColor();
        String maxYear = displayListingRequestModel.getMaxYear();
        String minYear = displayListingRequestModel.getMinYear();
        String numSeats = displayListingRequestModel.getNumSeats();
        String maxPrice = displayListingRequestModel.getMaxPrice();
        String minPrice = displayListingRequestModel.getMinPrice();
        String description = displayListingRequestModel.getDescription();
        String type = displayListingRequestModel.getType();

        List<DisplayListingDsRequestModel> outputListings = new ArrayList<>();

        int intMaxYear;

        if (maxYear.equals("") ) {
            intMaxYear = Integer.MAX_VALUE;
        } else {
            intMaxYear = Integer.parseInt(maxYear);
        }


        int intMinYear;

        if (minYear.equals("")) {
            intMinYear = Integer.MIN_VALUE;
        } else {
            intMinYear = Integer.parseInt(minYear);
        }

        float floatMaxPrice;

        if (maxPrice.equals("") ) {
            floatMaxPrice = Float.MAX_VALUE;
        } else {
            floatMaxPrice = Float.parseFloat(maxPrice);
        }
        float floatMinPrice;

        if (minPrice.equals("")) {
            floatMinPrice = Float.MIN_VALUE;
        } else {
            floatMinPrice = Float.parseFloat(minPrice);
        }


        for (DisplayListingDsRequestModel listing : listings) {
             if (listing.getBrand().contains(brand) &&
                listing.getName().contains(name) &&
                listing.getColor().contains(color) &&
                intMinYear <= Integer.parseInt(listing.getYear()) &&
                intMaxYear >= Integer.parseInt(listing.getYear()) &&
                Objects.equals(listing.getNumSeats(), numSeats) &&
                floatMinPrice <= Float.parseFloat(listing.getPrice())&&
                floatMaxPrice >= Float.parseFloat(listing.getPrice()) &&
                listing.getDescription().contains(description) &&
                listing.getType().equals(type))  {
                 outputListings.add(listing);
             }
        }
        return outputListings;
    }

}
