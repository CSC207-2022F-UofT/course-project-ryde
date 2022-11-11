package intefaceAdapters.createListing;

import useCases.createListing.CreateListingDsGateway;
import useCases.createListing.CreateListingDsRequestModel;
import useCases.createListing.CreateListingRequestModel;
import useCases.userRegister.UserRegisterDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ListingRepo implements CreateListingDsGateway {
    private File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, CreateListingDsRequestModel> listingsMap = new HashMap<>();

    public ListingRepo (String csvPath) throws IOException {
        csvFile = new File(csvPath);
        headers.put("uniqueId", 0);
        headers.put("brand", 1);
        headers.put("name", 2);
        headers.put("color", 3);
        headers.put("year", 4);
        headers.put("numSeats", 5);
        headers.put("price", 6);
        headers.put("userEmail", 7);
        headers.put("phoneNumber", 8);
        headers.put("description", 9);
        headers.put("type", 10);
        headers.put("creationTime", 11);


        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String uniqueId = String.valueOf(col[headers.get("uniqueId")]);
                String brand = String.valueOf(col[headers.get("brand")]);
                String name = String.valueOf(col[headers.get("name")]);
                String color = String.valueOf(col[headers.get("color")]);
                String year = String.valueOf(col[headers.get("year")]);
                String numSeats = String.valueOf(col[headers.get("numSeats")]);
                String price = String.valueOf(col[headers.get("price")]);
                String phoneNumber = String.valueOf(col[headers.get("phoneNumber")]);
                String userEmail = String.valueOf(col[headers.get("userEmail")]);
                String description = String.valueOf(col[headers.get("description")]);
                String type = String.valueOf(col[headers.get("type")]);
                String creationTime = String.valueOf(col[headers.get("creationTime")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTime);
                CreateListingDsRequestModel listing = new CreateListingDsRequestModel(uniqueId, brand, name, color, year, numSeats, price, userEmail, phoneNumber, description, type, ldt);
                listingsMap.put(uniqueId, listing);
            }

            reader.close();
        }
    }

    @Override
    public void save(CreateListingDsRequestModel createListingDsRequestModel) {
        listingsMap.put(createListingDsRequestModel.getUniqueId(), createListingDsRequestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (CreateListingDsRequestModel listing : listingsMap.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", listing.getUniqueId(),
                        listing.getBrand(), listing.getName(), listing.getColor(), listing.getYear(), listing.getNumSeats(),
                        listing.getPrice(),
                        listing.getUserEmail(), listing.getPhoneNumber(), listing.getDescription(), listing.getType(),
                        listing.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
