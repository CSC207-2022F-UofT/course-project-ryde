package intefaceAdapters.createListing;

import entities.ListingFactory;
import useCases.createListing.*;

public class CreateListingController {
    private final CreateListingInputBoundary input;

    public CreateListingController(CreateListingPresenter presenter, ListingFactory listingFactory, CreateListingDsGateway gateway) {
        input = new CreateListingInteractor(presenter, listingFactory, gateway);
    }

    public void executeInteractor(String brand, String name, String color, String year, int numSeats, String price, String phoneNumber, String description, String type) {
        CreateListingRequestModel requestModel = new CreateListingRequestModel(brand, name, color, year, numSeats, price, phoneNumber, description, type);
        input.create(requestModel);
    }
}
