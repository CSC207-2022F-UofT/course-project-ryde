package entities;

public class UserFactory {
    public User create(String email, String password, String name, String location) {
        return new DealershipUser(email, password, name, location);
    }
    public User create(String email, String password, String name) {
        return new IndividualUser(email, password, name);
    }
}
