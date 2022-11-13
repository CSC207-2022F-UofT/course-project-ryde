package useCases.displayListing;

public class DisplayListingDsRequestModel {
    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getYear() {
        return year;
    }

    public String getNumSeats() {
        return numSeats;
    }

    public String getPrice() {
        return price;
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

    private final String brand;
    private final String name;
    private final String color;
    private final String year;
    private final String numSeats;
    private final String price;
    private final String phoneNumber;
    private final String description;
    private final String type;

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
