package entities;

public class DealershipUserFactory{
    public User create(String email, String password, String name, String location) {
        return new DealershipUser(email, password, name, location);
    }
}
