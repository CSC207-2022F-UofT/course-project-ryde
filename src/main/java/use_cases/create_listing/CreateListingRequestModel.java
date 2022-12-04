package use_cases.create_listing;

/**
 * the listing request model for the user
 */
public class CreateListingRequestModel {
    private final String brand;

    private final String name;
    private final String color;
    private final String year;
    private final int numSeats;
    private final String price;

    private final String phoneNumber;
    private final String description;
    private final String type;


    /**
     * @param brand brand of the listing
     * @param name name of the listing
     * @param color color of the listing
     * @param year year of the listing
     * @param numSeats number of seats of the listing
     * @param price price of the listing
     * @param phoneNumber phone number
     * @param description description of the listing
     * @param type type of listing
     */
    public CreateListingRequestModel(String brand, String name, String color, String year, int numSeats, String price, String phoneNumber, String description, String type) {
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

    /**
     * @return the brand of the listing
     */

    public String getBrand() {
        return brand;
    }

    /**
     * @return the name of the listing
     */
    public String getName() {
        return name;
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
    public String getYear() {
        return year;
    }

    /**
     * @return the number of seats in the listing
     */
    public int getNumSeats() {
        return numSeats;
    }

    /**
     * @return the price of the listing
     */
    public String getPrice() {
        return price;
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

}
