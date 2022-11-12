package entities;

import java.time.LocalDateTime;

public class ListingFactory {

    public Listing create(String uniqueId, String brand, String name, String color, int year, int numSeats, float price, LocalDateTime dateCreated, String userEmail, String phoneNumber, String description, String type){
        return new Listing(uniqueId, brand,name, color, year, numSeats, price, dateCreated, userEmail, phoneNumber, description, type);
    }
}
