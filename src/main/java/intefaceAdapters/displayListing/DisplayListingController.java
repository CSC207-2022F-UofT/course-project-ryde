package intefaceAdapters.displayListing;

import useCases.displayListing.*;

/**
 * This is the controller for the DisplayListing use case.
 */
public class DisplayListingController {
    private final DisplayListingInputBoundary displayListingInteractor;

    /**
     * @param displayListingPresenter presenter for the DisplayListing use case.
     * @param gateway dsgateway for the DisplayListing use case.
     */
    public DisplayListingController(DisplayListingPresenter displayListingPresenter, DisplayListingDsGateway gateway) {
        this.displayListingInteractor = new DisplayListingInteractor(displayListingPresenter, gateway);
    }

    /**
     * Tells the interactor to display the listings based on the filters input by the user.
     */
    public void callDisplayListingInteractor(String brand, String name, String color, String maxYear, String minYear, String numSeats, String maxPrice, String minPrice, String description, String type) {
        DisplayListingRequestModel displayListingRequestModel = new DisplayListingRequestModel(brand, name, color, maxYear, minYear, numSeats, maxPrice, minPrice, description, type);
        displayListingInteractor.displayListings(displayListingRequestModel);
    }
}
