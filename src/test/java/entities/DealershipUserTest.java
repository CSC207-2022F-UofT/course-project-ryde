package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipUserTest {

    /**
     * Checks if short pincodes are invalid locations
     */
    @Test
    void testInvalidLocationLength() {
        DealershipUser user = new DealershipUser("manav@gmail.com", "password", "manav", "M5S");
        assertFalse(DealershipUser.isValidLocation(user.getLocation()));
    }

    /**
     * Checks non-Toronto postal codes are invalid locations
     */
    @Test
    void testNonTorontoLocationButCorrectLength() {
        DealershipUser user = new DealershipUser("manav@gmail.com", "password", "manav", "K5S1J4");
        assertFalse(DealershipUser.isValidLocation(user.getLocation()));
    }

    /**
     * Checks if Toronto postal codes are valid locations
     */
    @Test
    void testValidTorontoLocation() {
        DealershipUser user = new DealershipUser("manav@gmail.com", "password", "manav", "M5S1J4");
        assertTrue(DealershipUser.isValidLocation(user.getLocation()));
    }
}