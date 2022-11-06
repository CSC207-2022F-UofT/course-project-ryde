package entities;

public class IndividualUser extends User{
    public static final int maxListings = 5;

    public IndividualUser(String email, String password, String name) {
        super(email, password, name);
    }
}
