package intefaceAdapters.createListing;

import entities.ListingFactory;
import useCases.createListing.CreateListingInputBoundary;
import useCases.createListing.CreateListingInteractor;
import useCases.createListing.CreateListingPresenter;
import useCases.createListing.CreateListingRequestModel;

public class CreateListingController {
    private CreateListingInputBoundary input;

    public CreateListingController(CreateListingPresenter presenter, ListingFactory listingFactory) {
        input = new CreateListingInteractor(presenter, listingFactory);
    }

    public void executeInteractor(String brand, String name, String color, String year, int numSeats, String price, String phoneNumber, String description, String type) {
        CreateListingRequestModel requestModel = new CreateListingRequestModel(brand, name, color, year, numSeats, price, phoneNumber, description, type);
        input.create(requestModel);
    }
}
