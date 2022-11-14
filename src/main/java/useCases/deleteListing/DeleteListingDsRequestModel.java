package useCases.deleteListing;

import java.time.LocalDateTime;

public class DeleteListingDsRequestModel {
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

    public String getUuid() {
        return uuid;
    }

    public String getUserEmail() {
        return userEmail;
    }

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

    public LocalDateTime getLdt() {
        return ldt;
    }

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
}
