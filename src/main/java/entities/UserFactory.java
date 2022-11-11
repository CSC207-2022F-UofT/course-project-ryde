package entities;

/**
 * Creates a new DealershipUser or IndividualUser based on which create method is called.
 */
public class UserFactory {
    /**
     * @param email email of user
     * @param password password of user
     * @param name name of dealership
     * @param location location of dealership
     * @return DealershipUser object
     */
    public User create(String email, String password, String name, String location) {
        return new DealershipUser(email, password, name, location);
    }

    /**
     * @param email email of user
     * @param password password of user
     * @param name name of dealership
     * @return IndividualUser object
     */
    public User create(String email, String password, String name) {
        return new IndividualUser(email, password, name);
    }
}
