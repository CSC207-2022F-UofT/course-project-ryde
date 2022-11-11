package entities;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a listing which is an ad for a car that a user may upload to sell on the application
 */
public class Listing {
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public String getUserEmail() {
        return userEmail;
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

    private String uniqueId;
    private String brand;

    private String name;
    private String color;
    private int year;
    private int numSeats;
    private float price;
    private LocalDateTime dateCreated;

    private String userEmail;
    private String phoneNumber;
    private String description;
    private String type;

    public Listing(String uniqueId, String brand, String name, String color, int year, int numSeats, float price, LocalDateTime dateCreated, String userEmail, String phoneNumber, String description, String type) {
        this.uniqueId = uniqueId;
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.year = year;
        this.numSeats = numSeats;
        this.price = price;
        this.dateCreated = dateCreated;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.type = type;
    }

    public boolean validType() {
        return Objects.equals(type, "Used") || Objects.equals(type, "Rent") || Objects.equals(type, "New");
    }
}
