package use_cases.display_listing;

/**
 * This model stores the brand, name, color, maxYear, minYear, Number of seats, MaxPrice, minPrice, description,
 * and type of the filter added by the user.
 */
public class DisplayListingRequestModel {


    /**
     * @return gets the brand of the car from the filter added by the user.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return gets the name of the car from the filter added by the user.
     */
    public String getName() {
        return name;
    }

    /**
     * @return gets the color of the car from the filter added by the user.
     */
    public String getColor() {
        return color;
    }

    /**
     * @return gets the maximum year from the filter added by the user.
     */
    public String getMaxYear() {
        return maxYear;
    }

    /**
     * @return gets the minimum year from the filter added by the user.
     */
    public String getMinYear() {
        return minYear;
    }

    /**
     * @return gets the number of seats of the car from the filter added by the user.
     */
    public String getNumSeats() {
        return numSeats;
    }

    /**
     * @return gets the maximum price of the car from the filter added by the user.
     */
    public String getMaxPrice() {
        return maxPrice;
    }

    /**
     * @return gets the minimum price of the car from the filter added by the user.
     */
    public String getMinPrice() {
        return minPrice;
    }

    /**
     * @return gets the description of the car from the filter added by the user.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return gets the type of the car from the filter added by the user.
     */
    public String getType() {
        return type;
    }

    private final String brand;
    private final String name;
    private final String color;

    private final String maxYear;

    private final String minYear;
    private final String numSeats;
    private final String maxPrice;

    private final String minPrice;
    private final String description;
    private final String type;


    /**
     * Constructor for the DisplayListingRequestModel
     */
    public DisplayListingRequestModel(String brand, String name, String color, String maxYear, String minYear, String numSeats, String maxPrice, String minPrice, String description, String type) {
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.maxYear = maxYear;
        this.minYear = minYear;
        this.numSeats = numSeats;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.description = description;
        this.type = type;
    }
}
