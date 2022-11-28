package useCases.displayListing;

/**
 * A model that gets the brand, name, color, year, number of seats, price, phone number, description,
 * and type of the car listing.
 *
 */
public class DisplayListingDsRequestModel {
    /**
     * @return Gets the brand of the car of the listing.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return Gets the name of the car of the listing.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Gets the color of the car of the listing.
     */
    public String getColor() {
        return color;
    }

    /**
     * @return Gets the year of the car of the listing.
     */
    public String getYear() {
        return year;
    }

    /**
     * @return Gets the number of seats of the car of the listing.
     */
    public String getNumSeats() {
        return numSeats;
    }

    /**
     * @return Gets the price of the car of the listing.
     */
    public String getPrice() {
        return price;
    }

    /**
     * @return Gets the phone number of the user who posted the listing.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return Gets the description of the car of the listing.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Gets the type of the car of the listing.
     */
    public String getType() {
        return type;
    }

    private final String brand;
    private final String name;
    private final String color;
    private final String year;
    private final String numSeats;
    private final String price;
    private final String phoneNumber;
    private final String description;
    private final String type;

    /**
     * constructor for the dsrequest model.
     */
    public DisplayListingDsRequestModel(String brand, String name, String color, String year, String numSeats, String price, String phoneNumber, String description, String type) {
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
}
