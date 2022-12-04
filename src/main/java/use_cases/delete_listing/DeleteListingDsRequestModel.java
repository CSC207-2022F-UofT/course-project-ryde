package use_cases.delete_listing;

import java.time.LocalDateTime;

/**
 * the request model that stores a listing belonging to the user
 */
public class DeleteListingDsRequestModel {

    private final String uuid;
    private final String userEmail;
    private final String brand;
    private final String name;
    private final String color;
    private final String year;
    private final String numSeats;
    private final String price;
    private final String phoneNumber;
    private final String description;
    private final String type;
    private final LocalDateTime ldt;

    /**
     * constructor for the DeleteListingDsRequestModel
     */
    public DeleteListingDsRequestModel(String uuid, String userEmail, String brand, String name, String color, String year, String numSeats, String price, String phoneNumber, String description, String type, LocalDateTime ldt) {
        this.uuid = uuid;
        this.userEmail = userEmail;
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.year = year;
        this.numSeats = numSeats;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.type = type;
        this.ldt = ldt;
    }
    /**
     * @return Brand of the vehicle in the listing
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return Name of the vehicle in the listing
     */
    public String getName() {
        return name;
    }

    /**
     * @return Color of the vehicle in the listing
     */
    public String getColor() {
        return color;
    }

    /**
     * @return Year that the vehicle was manufactured in
     */
    public String getYear() {
        return year;
    }

    /**
     * @return Number of seats of the vehicle in the listing
     */
    public String getNumSeats() {
        return numSeats;
    }

    /**
     * @return Price of the vehicle in the listing
     */
    public String getPrice() {
        return price;
    }

    /**
     * @return Phone number of the user whose listing it is
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return Description of the vehicle in the listing
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Type of the listing
     */
    public String getType() {
        return type;
    }

    /**
     * @return Unique ID of the listing
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @return The email of the user whose listing it is
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @return Local date time when the listing was created
     */
    public LocalDateTime getLdt() {
        return ldt;
    }
}
