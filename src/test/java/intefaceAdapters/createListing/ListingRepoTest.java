package intefaceAdapters.createListing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import useCases.createListing.CreateListingDsRequestModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests the gateway for the create listing use case
 */
class ListingRepoTest {
    ListingRepo gateway;

    private void resetCsv() throws IOException {
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("./test_listing_creation.csv"));
        String[] headerList = {"uniqueId", "brand", "name", "color", "year", "numSeats", "price", "userEmail",
                "phoneNumber", "description", "type", "creationTime"};
        writer.write(String.join(",", headerList));
        writer.newLine();
        writer.write("2,Honda,CRV,cream,2014,5,8000.00,manav@gmail.com,4377723574,\"good  car bro buy it fast\",Rent,2022-11-11T20:32:20.317608");
        writer.newLine();
        writer.close();
    }

    @BeforeEach
    void setUp() throws IOException {
        resetCsv();
        try {
            gateway = new ListingRepo("./test_listing_creation.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        resetCsv();
    }

    /**
     * tests whether a listing is successfully saved to the database
     */
    @Test
    void save() {
        CreateListingDsRequestModel model = new CreateListingDsRequestModel("1", "Ford", "F150",
                "Black", "2020", "5", "12000", "manav@gmail.com",
                "1234567890", "this is better than the cybertruck lol",
                "Used", LocalDateTime.now());
        gateway.save(model);
        assertTrue(gateway.getListingsMap().containsKey("1"));
        assertTrue(gateway.getListingsMap().containsKey("2"));
    }
}