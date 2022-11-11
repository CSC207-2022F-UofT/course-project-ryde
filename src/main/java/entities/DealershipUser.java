package entities;

/**
 * Represents a car dealership with a location
 */
public class DealershipUser extends User{
    private final String location;

    public DealershipUser(String email, String password, String name, String location) {
        super(email, password, name);
        this.location = location;
    }

    /**
     * @return if location is a valid Toronto Postal Code
     */
    public boolean isValidLocation() {
        if (location.length() != 6) {
            return false;
        }
        boolean first = location.startsWith("M");
        boolean second = Character.isDigit(location.charAt(1));
        boolean third = Character.isUpperCase(location.charAt(2));
        boolean fourth = Character.isDigit(location.charAt(3));
        boolean fifth = Character.isUpperCase(location.charAt(4));
        boolean sixth = Character.isDigit(location.charAt(5));
        return first && second && third && fourth && fifth && sixth;
    }

    /**
     * @return location of the dealership
     */
    public String getLocation() {
        return location;
    }
}
