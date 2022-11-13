package intefaceAdapters.displayListing;

import useCases.displayListing.DisplayListingInputBoundary;
import useCases.displayListing.DisplayListingInteractor;
import useCases.displayListing.DisplayListingPresenter;
import useCases.displayListing.DisplayListingRequestModel;

public class DisplayListingController {
    private final DisplayListingInputBoundary displayListingInteractor;

    public DisplayListingController(DisplayListingPresenter displayListingPresenter) {
        this.displayListingInteractor = new DisplayListingInteractor(displayListingPresenter);
    }

    public void callDisplayListingInteractor(String brand, String name, String color, String maxYear, String minYear, String numSeats, String maxPrice, String minPrice, String description, String type) {
        DisplayListingRequestModel displayListingRequestModel = new DisplayListingRequestModel(brand, name, color, maxYear, minYear, numSeats, maxPrice, minPrice, description, type);
        displayListingInteractor.displayListings(displayListingRequestModel);
    }
}
