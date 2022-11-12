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

    public CreateListingInteractor(CreateListingPresenter presenter, ListingFactory listingFactory) {
        this.presenter = presenter;
        try {
            gateway = new ListingRepo("./listings.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file");
        }
        this.listingFactory = listingFactory;
    }

    @Override
    public void create(CreateListingRequestModel requestModel) {
        String uniqueId = UUID.randomUUID().toString();
        String brand = requestModel.getBrand();
        String name = requestModel.getName();
        String color = requestModel.getColor();
        String year = requestModel.getYear();
        int yearNum = 2022;
        if (isNumericInt(year)) {
            yearNum = Integer.parseInt(year);
        } else {
            presenter.prepareFailView("Please enter a valid year");
        }
        int numSeats = requestModel.getNumSeats();
        String price = requestModel.getPrice();
        float priceNum = 0.0F;
        if (isNumericFloat(price)) {
            priceNum = Float.parseFloat(price);
        } else {
            presenter.prepareFailView("Please enter a valid number");
        }
        String userEmail = LoggedInUserSingleton.getInstance().getEmail();
        String phoneNumber = requestModel.getPhoneNumber();
        String description = requestModel.getDescription();
        LocalDateTime now = LocalDateTime.now();


        String type = requestModel.getType();
        Listing listing  = listingFactory.create(uniqueId,brand,name, color,yearNum, numSeats, priceNum,now, userEmail, phoneNumber, description, type);

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

    private boolean isNumericInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private boolean isNumericFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
