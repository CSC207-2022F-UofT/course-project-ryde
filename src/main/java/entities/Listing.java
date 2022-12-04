package entities;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a listing which is an ad for a car that a user may upload to sell on the application
 */
public class Listing {

    private final String uniqueId;

    private final String brand;

    private final String name;
    private final String color;
    private final int year;
    private final int numSeats;
    private final float price;

    private final String phoneNumber;
    private final String description;
    private final String type;

    private final String userEmail;
    private final LocalDateTime dateCreated;

    public Listing(String uniqueId, String brand, String name, String color, int year, int numSeats, float price, LocalDateTime dateCreated, String userEmail, String phoneNumber, String description, String type) {
        this.uniqueId = uniqueId;
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.year = year;
        this.numSeats = numSeats;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.type = type;
        this.userEmail = userEmail;
        this.dateCreated = dateCreated;
    }

    public boolean validType() {
        return Objects.equals(type, "Used") || Objects.equals(type, "Rent") || Objects.equals(type, "New");
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public float getPrice() {
        return price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}
