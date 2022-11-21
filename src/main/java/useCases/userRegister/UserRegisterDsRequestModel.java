package useCases.userRegister;

import java.time.LocalDateTime;

/**
 * A model that stores the name, email, password, creationTime, listings and location of the user.
 * This is to store the data of a line in the users.csv file.
 */
public class UserRegisterDsRequestModel {

    private final String name;
    private final String email;
    private final String password;
    private final LocalDateTime creationTime;
    private final String listings;

    private final String location;

    public UserRegisterDsRequestModel(String email, String name, String password, LocalDateTime creationTime, String listings, String location) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
        this.listings = listings;
        this.location = location;
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

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getLocation() {
        return location;
    }

    public String getListings() {
        return listings;
    }
}
