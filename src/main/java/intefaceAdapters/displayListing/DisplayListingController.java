package intefaceAdapters.displayListing;

import useCases.displayListing.*;

public class DisplayListingController {
    private final DisplayListingInputBoundary displayListingInteractor;

    public DisplayListingController(DisplayListingPresenter displayListingPresenter, DisplayListingDsGateway gateway) {
        this.displayListingInteractor = new DisplayListingInteractor(displayListingPresenter, gateway);
    }

    public void callDisplayListingInteractor(String brand, String name, String color, String maxYear, String minYear, String numSeats, String maxPrice, String minPrice, String description, String type) {
        DisplayListingRequestModel displayListingRequestModel = new DisplayListingRequestModel(brand, name, color, maxYear, minYear, numSeats, maxPrice, minPrice, description, type);
        displayListingInteractor.displayListings(displayListingRequestModel);
    }
}
