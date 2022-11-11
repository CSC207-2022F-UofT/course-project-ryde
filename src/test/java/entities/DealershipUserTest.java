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
        assertFalse(user.isValidLocation());
    }

    /**
     * Checks non-Toronto postal codes are invalid locations
     */
    @Test
    void testNonTorontoLocationButCorrectLength() {
        DealershipUser user = new DealershipUser("manav@gmail.com", "password", "manav", "K5S1J4");
        assertFalse(user.isValidLocation());
    }

    /**
     * Checks if Toronto postal codes are valid locations
     */
    @Test
    void testValidTorontoLocation() {
        DealershipUser user = new DealershipUser("manav@gmail.com", "password", "manav", "M5S1J4");
        assertTrue(user.isValidLocation());
    }
}