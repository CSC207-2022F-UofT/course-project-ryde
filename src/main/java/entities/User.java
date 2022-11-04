package entities;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User {
    private final String email;
    private final String password;
    private final String name;
    private final List<Listing> listings = new ArrayList<>();

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public boolean isValidPassword() {
        return password != null && password.length() > 7;
    }

    public boolean isValidEmail() {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void addListing(Listing listing) {
        listings.add(listing);
    }
}