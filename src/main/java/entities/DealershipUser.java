package entities;

public class DealershipUser extends User{
    private final String location;

    public DealershipUser(String email, String password, String name, String location) {
        super(email, password, name);
        this.location = location;
    }

    public boolean isValidLocation() {
        return location.startsWith("M") && location.length() == 6;
    }

    public String getLocation() {
        return location;
    }
}
