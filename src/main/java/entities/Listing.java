package entities;
import java.time.LocalDate;

/**
 * Represents a listing which is an ad for a car that a user may upload to sell on the application
 */
public class Listing {
    private final int id;
    private String brand;
    private String color;
    private int year;
    private int numSeats;
    private float price;
    private LocalDate dateCreated;
    private User owner;
    private String phoneNumber;
    private String description;
    private enum type {USED, NEW, RENT}

    public Listing(int id, String brand, String color, int year, int numSeats, float price, LocalDate dateCreated, User owner, String phoneNumber, String description) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.year = year;
        this.numSeats = numSeats;
        this.price = price;
        this.dateCreated = dateCreated;
        this.owner = owner;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }


}
