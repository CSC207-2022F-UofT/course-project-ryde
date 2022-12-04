package use_cases.display_listing;

import entities.LoggedInUserSingleton;
import interface_adapters.display_listing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the entire Display Listing Use Case
 */
class DisplayListingInteractorTest {
    DisplayListingDsGateway gateway;
    DisplayListingPresenter presenter;
    DisplayListingController controller;
    String status;
    List<DisplayListingDsRequestModel> listingStatus = new ArrayList<>();
    private final DisplayListingScreenInterface view = new DisplayListingScreenInterface() {
        @Override
        public void displayListing(List<DisplayListingDsRequestModel> filteredListings) {
            listingStatus = filteredListings;
        }

        @Override
        public void displayMessage(String message) {
            status = message;
        }
    };


    @BeforeEach
    void setUp() {
        LoggedInUserSingleton.init("manav@gmail.com", false);
        try {
            gateway = new DisplayListingRepo("./test_listings.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file");
        }
        presenter = new DisplayListingResponseFormatter(view);
        controller = new DisplayListingController(presenter, gateway);
    }

    /**
     * tests whether all the listings are displayed when the filter is empty
     */
    @Test
    void emptyFilterSuccess() {
        controller.callDisplayListingInteractor("", "", "", "", "", "4", "", "", "", "Used");
        DisplayListingDsRequestModel model1 = new DisplayListingDsRequestModel("Ford", "F150", "Blue",
                "2003", "4", "12000", "6578388104",
                "Amazing car. very spacious", "Used");
        DisplayListingDsRequestModel model2 = new DisplayListingDsRequestModel("Honda", "Civic", "Black",
                "2014", "4", "16000", "6578388104",
                "This is a very good car.", "Used");
        DisplayListingDsRequestModel model3 = new DisplayListingDsRequestModel("Toyota", "Corolla", "White",
                "2010", "4", "13000", "6578388104",
                "A very spacious and smooth car.", "Used");
        assertEquals(3, listingStatus.size());
        assertEquals(model1.getBrand(), listingStatus.get(0).getBrand());
        assertEquals(model1.getName(), listingStatus.get(0).getName());
        assertEquals(model1.getPhoneNumber(), listingStatus.get(0).getPhoneNumber());
        assertEquals(model2.getBrand(), listingStatus.get(1).getBrand());
        assertEquals(model2.getName(), listingStatus.get(1).getName());
        assertEquals(model3.getBrand(), listingStatus.get(2).getBrand());
        assertEquals(model3.getName(), listingStatus.get(2).getName());
    }

    /**
     * tests whether the brand filter displays all listings of the same brand input by the user.
     */
    @Test
    void brandFilterSuccess() {
        controller.callDisplayListingInteractor("Ford", "", "", "", "", "4", "", "", "", "Used");
        assertEquals(1, listingStatus.size());
        assertEquals("F150", listingStatus.get(0).getName());
    }

    /**
     * tests whether the name filter displays all listings of the same name input by the user.
     */
    @Test
    void nameFilterSuccess() {
        controller.callDisplayListingInteractor("", "Civic", "", "", "", "4", "", "", "", "Used");
        assertEquals(1, listingStatus.size());
        assertEquals("Black", listingStatus.get(0).getColor());
    }

    /**
     * tests whether the color filter displays all listings of the same color input by the user.
     */
    @Test
    void colorFilterSuccess() {
        controller.callDisplayListingInteractor("", "", "Blue", "", "", "4", "", "", "", "Used");
        assertEquals(1, listingStatus.size());
        assertEquals("F150", listingStatus.get(0).getName());
    }

    /**
     * tests whether the year filter displays all listings within the year range input by the user.
     */
    @Test
    void yearFilterSuccess() {
        controller.callDisplayListingInteractor("", "", "", "2010", "2000", "4", "", "", "", "Used");
        assertEquals(2, listingStatus.size());
        assertEquals("F150", listingStatus.get(0).getName());
        assertEquals("Corolla", listingStatus.get(1).getName());
    }

    /**
     * tests whether the price filter displays all listings within the
     * price range input by the user.
     */
    @Test
    void priceFilterSuccess() {
        controller.callDisplayListingInteractor("", "", "", "", "", "4", "20000", "15000", "", "Used");
        assertEquals(1, listingStatus.size());
        assertEquals("Civic", listingStatus.get(0).getName());
    }

    /**
     * tests whether the description filter displays all listings with their
     * descriptions containing the keyword input by the user.
     */
    @Test
    void descriptionFilterSuccess() {
        controller.callDisplayListingInteractor("", "", "", "", "", "4", "", "", "spacious", "Used");
        assertEquals(2, listingStatus.size());
        assertEquals("F150", listingStatus.get(0).getName());
        assertEquals("Corolla", listingStatus.get(1).getName());
    }

    /**
     * tests whether the brand filter displays the error message as there
     * are no listings of the same brand input by the user.
     */
    @Test
    void brandFilterFail() {
        controller.callDisplayListingInteractor("Ferrari", "", "", "", "", "4", "20000", "15000", "", "Used");
        assertEquals(0, listingStatus.size());
        assertEquals("No Listings found!", status);
    }
}