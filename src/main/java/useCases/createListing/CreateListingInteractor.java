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
        int numSeats = requestModel.getNumSeats();
        String price = requestModel.getPrice();
        String userEmail = LoggedInUserSingleton.getInstance().getEmail();
        String phoneNumber = requestModel.getPhoneNumber();
        String description = requestModel.getDescription();
        LocalDateTime now = LocalDateTime.now();
        String type = requestModel.getType();
        int yearNum = 2022;
        float priceNum = 0.0F;

        if (brand.equals("") || name.equals("") || color.equals("") || description.equals("")) {
            presenter.prepareFailView("Please fill in all the fields for the listing.");
        } else if (isNotNumericInt(year)) {
            presenter.prepareFailView("Please enter a valid year");
        } else if (!isNumericFloat(price)){
            presenter.prepareFailView("Please enter a valid price");
        } else if (!isNumericLong(phoneNumber) || phoneNumber.length() != 10) {
            presenter.prepareFailView("Please enter a valid number");
        } else {
            yearNum = Integer.parseInt(year);
            priceNum = Float.parseFloat(price);
            Listing listing  = listingFactory.create(uniqueId,brand,name, color,yearNum, numSeats,
                    priceNum,now, userEmail, phoneNumber, description, type);

            if(listing.validType()) {
                CreateListingResponseModel responseModel =
                        new CreateListingResponseModel(String.format("%s listing created!", requestModel.getName()));
                CreateListingDsRequestModel dsRequestModel = new CreateListingDsRequestModel(uniqueId, brand, name,
                        color, year, String.valueOf(numSeats),
                        price, userEmail, phoneNumber, description, type, now);
                gateway.save(dsRequestModel);
                presenter.prepareSuccessView(responseModel);
            } else {
                presenter.prepareFailView("Incorrect type of car. (This should not be occurring)");
            }
        }
    }

    private boolean isNotNumericInt(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch(NumberFormatException e){
            return true;
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

    private boolean isNumericLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
