package useCases.createListing;

import entities.ListingFactory;
import entities.LoggedInUserSingleton;
import intefaceAdapters.createListing.CreateListingController;
import intefaceAdapters.createListing.CreateListingResponseFormatter;
import intefaceAdapters.createListing.CreateListingScreenInterface;
import intefaceAdapters.createListing.MockListingRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests the create listing use case
 */
class CreateListingInteractorTest {
    MockListingRepo gateway;
    CreateListingPresenter presenter;
    CreateListingController controller;
    ListingFactory factory;
    String status;

    private final CreateListingScreenInterface view = new CreateListingScreenInterface() {
        @Override
        public void showCreatedListingMessage(String message) {
            status = message;
        }

        @Override
        public void showCreatedListingMessageFailure(String error) {
            status = error;
        }
    };

    @BeforeEach
    void setUp() {
        LoggedInUserSingleton.init("manav@gmail.com", false);
        gateway = new MockListingRepo();
        presenter = new CreateListingResponseFormatter(view);
        factory = new ListingFactory();
        controller = new CreateListingController(presenter, factory, gateway);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * tests whether a listing with the right inputs can successfully be created
     */
    @Test
    void testCreateSuccess() {
        String brand = "Ford";
        String model = "F150";
        String color = "Blue";
        String year = "2019";
        int numSeats = 4;
        String price = "50000";
        String number = "1234567890";
        String description = "This car is very cool. Buy it. You will love it.";
        String type = "Used";

        controller.executeInteractor(brand, model, color, year, numSeats, price, number, description, type);
        assertEquals(status, "F150 listing created!");
    }

    /**
     * tests whether a failure message is displayed when a field is empty
     */
    @Test
    void testBlankFieldFail() {
        String brand = "";
        String model = "F150";
        String color = "Blue";
        String year = "2019";
        int numSeats = 4;
        String price = "50000";
        String number = "1234567890";
        String description = "This car is very cool. Buy it. You will love it.";
        String type = "Used";

        controller.executeInteractor(brand, model, color, year, numSeats, price, number, description, type);
        assertEquals(status, "Please fill in all the fields for the listing.");
        assertFalse(gateway.exists(model));
    }

    /**
     * tests whether a failure message is displayed when the inpur in the year field is invalid
     */
    @Test
    void testInvalidYearFail() {
        String brand = "Ford";
        String model = "F150";
        String color = "Blue";
        String year = "Twenty Nineteen";
        int numSeats = 4;
        String price = "50000";
        String number = "1234567890";
        String description = "This car is very cool. Buy it. You will love it.";
        String type = "Used";

        controller.executeInteractor(brand, model, color, year, numSeats, price, number, description, type);
        assertEquals(status, "Please enter a valid year");
        assertFalse(gateway.exists(model));
    }

    /**
     * tests whether a failure message is displayed when the input in the price field is invalid
     */
    @Test
    void testInvalidPriceFail() {
        String brand = "Ford";
        String model = "F150";
        String color = "Blue";
        String year = "2019";
        int numSeats = 4;
        String price = "Fifty Thousand";
        String number = "1234567890";
        String description = "This car is very cool. Buy it. You will love it.";
        String type = "Used";

        controller.executeInteractor(brand, model, color, year, numSeats, price, number, description, type);
        assertEquals(status, "Please enter a valid price");
        assertFalse(gateway.exists(model));
    }

    /**
     * tests whether a failure message is displayed when the input in the number field is invalid
     */
    @Test
    void testInvalidNumberFail() {
        String brand = "Ford";
        String model = "F150";
        String color = "Blue";
        String year = "2019";
        int numSeats = 4;
        String price = "50000";
        String number = "onetwothree";
        String description = "This car is very cool. Buy it. You will love it.";
        String type = "Used";

        controller.executeInteractor(brand, model, color, year, numSeats, price, number, description, type);
        assertEquals(status, "Please enter a valid number");
        assertFalse(gateway.exists(model));
    }

    /**
     * tests whether a failure message is displayed when the input in the type field is invalid
     */
    @Test
    void testInvalidTypeFail() {
        String brand = "Ford";
        String model = "F150";
        String color = "Blue";
        String year = "2019";
        int numSeats = 4;
        String price = "50000";
        String number = "1234567890";
        String description = "This car is very cool. Buy it. You will love it.";
        String type = "Old";

        controller.executeInteractor(brand, model, color, year, numSeats, price, number, description, type);
        assertEquals(status, "Incorrect type of car. (This should not be occurring)");
        assertFalse(gateway.exists(model));
    }


}