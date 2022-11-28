package intefaceAdapters.createListing;

import entities.ListingFactory;
import useCases.createListing.*;

/**
 * This is the controller for the CreateListing use case
 */
public class CreateListingController {
    private final CreateListingInputBoundary input;

    public CreateListingController(CreateListingPresenter presenter, ListingFactory listingFactory, CreateListingDsGateway gateway) {
        input = new CreateListingInteractor(presenter, listingFactory, gateway);
    }

    /**
     * @param brand brand of the listing
     * @param name name of the listing
     * @param color color of the listing
     * @param year year of the listing
     * @param numSeats number of seats of the listing
     * @param price price of the listing
     * @param phoneNumber phone number
     * @param description description of the listing
     * @param type type of listing
     */
    public void executeInteractor(String brand, String name, String color, String year, int numSeats, String price, String phoneNumber, String description, String type) {
        CreateListingRequestModel requestModel = new CreateListingRequestModel(brand, name, color, year, numSeats, price, phoneNumber, description, type);
        input.create(requestModel);
    }
}
