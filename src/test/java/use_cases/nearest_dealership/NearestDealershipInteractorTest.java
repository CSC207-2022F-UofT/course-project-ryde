package use_cases.nearest_dealership;

import entities.LoggedInUserSingleton;
import interface_adapters.nearest_dealership.DealershipRepo;
import interface_adapters.nearest_dealership.NearestDealershipController;
import interface_adapters.nearest_dealership.NearestDealershipResponseFormatter;
import interface_adapters.nearest_dealership.NearestDealershipScreenInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Nearest Dealership Use Case
 */
class NearestDealershipInteractorTest {
    NearestDealershipController controller;
    NearestDealershipDsGateway gateway;
    NearestDealershipPresenter presenter;
    NearestDealershipApiGateway mockApiGateway;
    String status;

    @BeforeEach
    void setUp() {
        try {
            gateway = new DealershipRepo("./test_dealerships.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file.");
        }
        NearestDealershipScreenInterface view = new NearestDealershipScreenInterface() {
            @Override
            public void showDealership(String message) {
                status = message;
            }

            @Override
            public void showFailure(String message) {
                status = message;
            }
        };
        presenter = new NearestDealershipResponseFormatter(view);

//        this is just a mock api to avoid making calls to the real Google api.
//        This api ALWAYS returns the first dealership in the list of dealerships given
        mockApiGateway = new NearestDealershipApiGateway() {
            @Override
            public NearestDealershipResponseModel getClosestDealership(List<DealershipDsRequestModel> dealerships, String userLocation) {
                DealershipDsRequestModel dealership = dealerships.get(0);
                return new NearestDealershipResponseModel(dealership.getName(), dealership.getLocation(), "x mins", "x m");
            }
        };
        controller = new NearestDealershipController(presenter, gateway, mockApiGateway);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Tests if there is a dealership returned when every input is correct
     */
    @Test
    void testGetNearestDealershipSuccess() {
        LoggedInUserSingleton.init("manav@gmail.com", false);
        controller.findNearestDealership("M5S1W4");
        assertEquals("The nearest dealership is Aneja Cars located at M5S1G4. " +
                "It is x m away from you and should only take you x mins to get there!", status);
    }

    /**
     * Tests whether a failure message is returned when the postal code input by the user is incorrect
     */
    @Test
    void testInvalidPostalCode() {
        LoggedInUserSingleton.init("manav@gmail.com", false);
        controller.findNearestDealership("M5S1WK");
        assertEquals("Please enter a valid toronto postal code!", status);
    }

    /**
     * Tests whether a failure message is returned when there are no dealerships in the database
     */
    @Test
    void testZeroDealerships() {
        try {
            gateway = new DealershipRepo("./test_users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file.");
        }
        controller = new NearestDealershipController(presenter, gateway, mockApiGateway);
        LoggedInUserSingleton.init("manav@gmail.com", false);
        controller.findNearestDealership("M5S1W4");
        assertEquals("No Dealerships around!", status);
    }
}