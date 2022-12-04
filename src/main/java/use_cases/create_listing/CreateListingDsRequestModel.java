package use_cases.create_listing;

import java.time.LocalDateTime;

/**
 * this stores the information about a listing for the databse
 */
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


    /**
     * @return the name object
     */
    public String getName() {
        return name;
    }

    /**
     * @param uniqueId unique Id of the listing
     * @param brand brand of the listing
     * @param name name of the listing
     * @param color color of the listing
     * @param year year of the listing
     * @param numSeats number of seats of the listing
     * @param price price of the listing
     * @param userEmail email of the user
     * @param phoneNumber phone number
     * @param description description of the listing
     * @param type type of listing
     * @param creationTime creation time of the listing
     */
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

    /**
     * @return the brand of the listing
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return the color of the listing
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the year of the listing
     */
    public String getYear() { return year; }

    /**
     * @return the number of seats in the listing
     */
    public String getNumSeats() {
        return numSeats;
    }

    /**
     * @return the price of the listing
     */
    public String getPrice() {
        return price;
    }

    /**
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return the description of the listing
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the type of the listing
     */
    public String getType() {
        return type;
    }

    /**
     * @return the creation time of the listing
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * @return the unique id of the listing
     */
    public String getUniqueId() {
        return uniqueId;
    }
}
