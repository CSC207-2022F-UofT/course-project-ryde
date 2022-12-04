package entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static boolean isValidLocation(String location) {
        Pattern zipCode = Pattern.compile("^M\\d[A-Z]\\d[A-Z]\\d$");
        Matcher matcher = zipCode.matcher(location);
        return matcher.find();
    }

    /**
     * @return location of the dealership
     */
    public String getLocation() {
        return location;
    }
}
