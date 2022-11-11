package intefaceAdapters.createListing;

import useCases.createListing.CreateListingInputBoundary;
import useCases.createListing.CreateListingInteractor;
import useCases.createListing.CreateListingPresenter;
import useCases.createListing.CreateListingRequestModel;

public class CreateListingController {
    private CreateListingInputBoundary input;

    public CreateListingController(CreateListingPresenter presenter) {
        input = new CreateListingInteractor(presenter);
    }

    public void executeInteractor(String brand, String name, String color, int year, int numSeats, float price, String phoneNumber, String description, String type) {
        CreateListingRequestModel requestModel = new CreateListingRequestModel(brand, name, color, year, numSeats, price, phoneNumber, description, type);
        input.create(requestModel);
    }
}
