package useCases.createListing;

import entities.Listing;
import entities.ListingFactory;
import entities.LoggedInUserSingleton;
import intefaceAdapters.createListing.ListingRepo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class CreateListingInteractor implements CreateListingInputBoundary{
    private CreateListingDsGateway gateway;
    private CreateListingPresenter presenter;
    private ListingFactory listingFactory;

    public CreateListingInteractor(CreateListingPresenter presenter) {
        this.presenter = presenter;
        try {
            gateway = new ListingRepo("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file");
        }
    }

    @Override
    public void create(CreateListingRequestModel requestModel) {
        String uniqueId = UUID.randomUUID().toString();
        String brand = requestModel.getBrand();
        String name = requestModel.getName();
        String color = requestModel.getColor();
        int year = requestModel.getYear();
        int numSeats = requestModel.getNumSeats();
        float price = requestModel.getPrice();
        String userEmail = LoggedInUserSingleton.getInstance().getEmail();
        String phoneNumber = requestModel.getPhoneNumber();
        String description = requestModel.getDescription();
        LocalDateTime now = LocalDateTime.now();

        String type = requestModel.getType();
        Listing listing  = listingFactory.create(uniqueId,brand,name, color,year, numSeats, price,now, userEmail, phoneNumber, description, type);

        if(listing.validType()) {
            CreateListingResponseModel responseModel = new CreateListingResponseModel(String.format("%s listing created!", requestModel.getName()));
            CreateListingDsRequestModel dsRequestModel = new CreateListingDsRequestModel(uniqueId, brand, name, color, String.valueOf(year), String.valueOf(numSeats),
                    String.valueOf(price), userEmail, phoneNumber, description, type, now);
            gateway.save(dsRequestModel);
            presenter.prepareSuccessView(responseModel);
        } else {
            presenter.prepareFailView("Incorrect type of car. (This should not be occurring)");
        }
    }
}
