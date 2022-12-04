package interface_adapters.delete_listing;

import use_cases.delete_listing.DeleteListingDsGateway;
import use_cases.delete_listing.DeleteListingDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class that implements the DeleteListingDsGateway and talks to the listings.csv file when listings need to be deleted
 */
public class DeleteListingRepo implements DeleteListingDsGateway {
    private final Map<String, DeleteListingDsRequestModel> listings = new HashMap<>();
    private final File csvFile;
    private final Map<String, Integer> headers;

    /**
     * @param csvPath It is the file where the details about each listing is stored
     * @throws IOException Error if something goes wrong
     */
    public DeleteListingRepo(String csvPath) throws IOException {
        csvFile = new File(csvPath);
        String[] headerList = {"uniqueId", "brand", "name", "color", "year", "numSeats", "price", "userEmail",
                "phoneNumber", "description", "type", "creationTime"};
        headers = new LinkedHashMap<>();
        for (int i = 0; i < headerList.length; i++) {
            headers.put(headerList[i], i);
        }
        if (csvFile.length() > 0) {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String email = String.valueOf(col[headers.get("userEmail")]);
                String uuid = String.valueOf(col[headers.get("uniqueId")]);
                String brand = String.valueOf(col[headers.get("brand")]);
                String name = String.valueOf(col[headers.get("name")]);
                String color = String.valueOf(col[headers.get("color")]);
                String year = String.valueOf(col[headers.get("year")]);
                String numSeats = String.valueOf(col[headers.get("numSeats")]);
                String price = String.valueOf(col[headers.get("price")]);
                String phoneNumber = String.valueOf(col[headers.get("phoneNumber")]);
                String description = String.valueOf(col[headers.get("description")]);
                String type = String.valueOf(col[headers.get("type")]);
                String creationTimeText = String.valueOf(col[headers.get("creationTime")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                DeleteListingDsRequestModel listing = new DeleteListingDsRequestModel(uuid, email, brand, name, color, year, numSeats, price, phoneNumber, description, type, ldt);
                listings.put(uuid, listing);
            }

            reader.close();
        }
    }

    /**
     * @param uuid Unique ID of the listing that is to be deleted
     * @return the brand and model name of the listing
     */
    @Override
    public String deleteListing(String uuid){
        DeleteListingDsRequestModel listing = listings.get(uuid);
        String brand = listing.getBrand();
        String name = listing.getName();
        listings.remove(uuid);
        this.save();
        return String.format("%s %s", brand, name);
    }

    private void save(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (DeleteListingDsRequestModel listing : listings.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", listing.getUuid(), listing.getBrand(), listing.getName(), listing.getColor(), listing.getYear(), listing.getNumSeats(), listing.getPrice(), listing.getUserEmail(), listing.getPhoneNumber(), listing.getDescription(), listing.getType(), listing.getLdt());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new ListingDeletionFailed(e.getMessage());
        }
    }

    /**
     * @return Hashmap of the ID of the listing to the DsRequestModel
     */
    @Override
    public Map<String, DeleteListingDsRequestModel> getListings() {
        return listings;
    }
}
