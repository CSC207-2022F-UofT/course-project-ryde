package useCases.createListing;

import java.time.LocalDateTime;

public class CreateListingDsRequestModel {
    private final String uniqueId;
    private final String brand;
    private final String name;
    private final String color;
    private final String year;
    private final String numSeats;
    private final String price;

    private final String userEmail;
    private final String phoneNumber;
    private final String description;
    private final String type;
    private final LocalDateTime creationTime;


    public String getName() {
        return name;
    }

    public CreateListingDsRequestModel(String uniqueId, String brand, String name, String color, String year, String numSeats, String price, String userEmail, String phoneNumber, String description, String type, LocalDateTime creationTime) {
        this.uniqueId = uniqueId;
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.year = year;
        this.numSeats = numSeats;
        this.price = price;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.type = type;
        this.creationTime = creationTime;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getYear() { return year; }

    public String getNumSeats() {
        return numSeats;
    }

    public String getPrice() {
        return price;
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

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getUniqueId() {
        return uniqueId;
    }
}
