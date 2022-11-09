package entities;

/**
 * Represents a non-dealership individual customer
 */
public class IndividualUser extends User{
    public static final int MAX_LISTINGS = 5;

    public IndividualUser(String email, String password, String name) {
        super(email, password, name);
    }
}
