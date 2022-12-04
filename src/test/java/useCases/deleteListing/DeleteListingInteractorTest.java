package useCases.deleteListing;

import entities.LoggedInUserSingleton;
import intefaceAdapters.deleteListing.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import useCases.createListing.CreateListingDsRequestModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the entire delete listing use case
 */
class DeleteListingInteractorTest {
    DeleteListingDsGateway gateway;
    DeleteListingPresenter presenter;
    DeleteListingController controller;
    String status;
    List<DeleteListingDsRequestModel> listingStatus;
    CreateListingDsRequestModel model1;
    CreateListingDsRequestModel model2;
    CreateListingDsRequestModel model3;
    private final DeleteListingScreenInterface view = new DeleteListingScreenInterface() {
        @Override
        public void displayUserListings(List<DeleteListingDsRequestModel> listings) {
            listingStatus = listings;
        }

        @Override
        public void showDeletedMessage(String message) {
            status = message;
        }
    };

    @BeforeEach
    void setUp() {
        LoggedInUserSingleton.init("manav@gmail.com", false);
//        setting up the csv file.
        createCsv();

        try {
            gateway = new DeleteListingRepo("./test_listings_deletion.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        presenter = new DeleteListingResponseFormatter(view);
        controller = new DeleteListingController(presenter, gateway);

    }

    @AfterEach
    void tearDown() {

    }

    /**
     * Tests whether the user's listings are displayed successfully
     */
    @Test
    void displayListingsSuccess() {
        controller.displayUserListings();
        assertEquals(3, listingStatus.size());
        assertEquals(model1.getBrand(), listingStatus.get(0).getBrand());
        assertEquals(model1.getName(), listingStatus.get(0).getName());
        assertEquals(model2.getBrand(), listingStatus.get(1).getBrand());
        assertEquals(model2.getName(), listingStatus.get(1).getName());
        assertEquals(model3.getBrand(), listingStatus.get(2).getBrand());
        assertEquals(model3.getName(), listingStatus.get(2).getName());
        assertEquals(model1.getUserEmail(), "manav@gmail.com");
        assertEquals(model2.getUserEmail(), "manav@gmail.com");
        assertEquals(model3.getUserEmail(), "manav@gmail.com");
    }

    /**
     * Tests whether a listing can successfully be deleted.
     */
    @Test
    void testDeleteListingSuccess() {
        controller.deleteUserListing("3");
        assertFalse(gateway.getListings().containsKey("3"));
        assertEquals(status, "Successfully deleted Toyota Corolla listing!");

    }

    private void createCsv() {
        File csvFile = new File("./test_listings_deletion.csv");
        String[] headerList = {"uniqueId", "brand", "name", "color", "year", "numSeats", "price", "userEmail",
                "phoneNumber", "description", "type", "creationTime"};
        Map<String, Integer> headers = new LinkedHashMap<>();
        for (int i = 0; i < headerList.length; i++) {
            headers.put(headerList[i], i);
        }

        List<CreateListingDsRequestModel> make_listings = new ArrayList<>();

        model1 = new CreateListingDsRequestModel("1",
                "Ford", "F150", "Blue", "2003", "4", "12000", "manav@gmail.com",
                "1234567890", "Nice", "Used",
                LocalDateTime.of(2003, 9, 3, 3, 30) );
        model2 = new CreateListingDsRequestModel("2",
                "Honda", "Accord", "Blue", "2003", "5", "15000", "manav@gmail.com",
                "1234567890", "Nice.", "New",
                LocalDateTime.of(2003, 9, 3, 3, 30) );
        model3 = new CreateListingDsRequestModel("3",
                "Toyota", "Corolla", "Green", "2003", "5", "20000", "manav@gmail.com",
                "1234567890", "Nice and Great", "Used",
                LocalDateTime.of(2003, 9, 3, 3, 30) );
        make_listings.add(model1);
        make_listings.add(model2);
        make_listings.add(model3);

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (CreateListingDsRequestModel listing : make_listings) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", listing.getUniqueId(),
                        listing.getBrand(), listing.getName(), listing.getColor(), listing.getYear(), listing.getNumSeats(),
                        listing.getPrice(),
                        listing.getUserEmail(), listing.getPhoneNumber(), listing.getDescription(), listing.getType(),
                        listing.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}