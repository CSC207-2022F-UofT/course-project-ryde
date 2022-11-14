package intefaceAdapters.deleteListing;

import useCases.deleteListing.DeleteListingDsGateway;
import useCases.deleteListing.DeleteListingDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DeleteListingRepo implements DeleteListingDsGateway {
    private final Map<String, DeleteListingDsRequestModel> listings = new HashMap<>();
    private final File csvFile;
    private final Map<String, Integer> headers;

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

    @Override
    public void deleteListing(String uuid){
        listings.remove(uuid);
        this.save();
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, DeleteListingDsRequestModel> getListings() {
        return listings;
    }
}