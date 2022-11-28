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
    }

    public boolean validType() {
        return Objects.equals(type, "Used") || Objects.equals(type, "Rent") || Objects.equals(type, "New");
    }
}
