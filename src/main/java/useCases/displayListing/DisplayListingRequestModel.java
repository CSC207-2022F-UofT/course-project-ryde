package useCases.displayListing;

public class DisplayListingRequestModel {
    private final String brand;

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getMaxYear() {
        return maxYear;
    }

    public String getMinYear() {
        return minYear;
    }

    public String getNumSeats() {
        return numSeats;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    private final String name;
    private final String color;

    private final String maxYear;

    private final String minYear;
    private final String numSeats;
    private final String maxPrice;

    private final String minPrice;
    private final String description;
    private final String type;


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
