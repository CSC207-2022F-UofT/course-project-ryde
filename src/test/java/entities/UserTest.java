package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    /**
     * Tests if short passwords are invalid(<=7 characters)
     */
    @Test
    void testShortPasswordIsInvalid() {
        User user = new IndividualUser("manav@gmail.com", "pass", "manav");

        assertFalse(user.isValidPassword());
    }

    /**
     * Tests if long passwords are valid(>7 characters)
     */
    @Test
    void testLongPasswordIsValid() {
        User user = new IndividualUser("manav@gmail.com", "password", "manav");

        assertTrue(user.isValidPassword());
    }

    /**
     * Tests if wrong emails are invalid
     */
    @Test
    void testCorrectEmailIsValidEmail() {
        User user = new IndividualUser("manav@gmail.com", "password", "manav");

        assertTrue(user.isValidEmail());
    }

    /**
     * Tests if right emails are valid
     */
    @Test
    void testIncorrectEmailIsInvalidEmail() {
        User user = new IndividualUser("manavgmail.com", "password", "manav");

        assertFalse(user.isValidEmail());
    }

//    The following tests check the getter methods in the User class.

    @Test
    void getName() {
        User user = new IndividualUser("manav@gmail.com", "password", "manav");

        assertEquals("manav", user.getName());
    }

    @Test
    void getEmail() {
        User user = new IndividualUser("manav@gmail.com", "password", "manav");

        assertEquals("manav@gmail.com", user.getEmail());
    }

    @Test
    void getPassword() {
        User user = new IndividualUser("manav@gmail.com", "password", "manav");

        assertEquals("password", user.getPassword());
    }
}