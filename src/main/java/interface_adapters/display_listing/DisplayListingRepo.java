package interface_adapters.display_listing;

import use_cases.display_listing.DisplayListingDsGateway;
import use_cases.display_listing.DisplayListingDsRequestModel;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that implements the DisplayListingDsGateway and talks to the database when listings have to be displayed.
 */
public class DisplayListingRepo implements DisplayListingDsGateway {
    private final List<DisplayListingDsRequestModel> listings = new ArrayList<>();

    /**
     * @param csvPath The database
     * @throws IOException error
     * constructor for the gateway implementation
     */
    public DisplayListingRepo(String csvPath) throws IOException {
        File csvFile = new File(csvPath);
        String[] headerList = {"uniqueId", "brand", "name", "color", "year", "numSeats", "price", "userEmail",
                "phoneNumber", "description", "type", "creationTime"};
        Map<String, Integer> headers = new LinkedHashMap<>();
        for (int i = 0; i < headerList.length; i++) {
            headers.put(headerList[i], i);
        }

        if (csvFile.length() > 0) {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String brand = String.valueOf(col[headers.get("brand")]);
                String name = String.valueOf(col[headers.get("name")]);
                String color = String.valueOf(col[headers.get("color")]);
                String year = String.valueOf(col[headers.get("year")]);
                String numSeats = String.valueOf(col[headers.get("numSeats")]);
                String price = String.valueOf(col[headers.get("price")]);
                String phoneNumber = String.valueOf(col[headers.get("phoneNumber")]);
                String description = String.valueOf(col[headers.get("description")]);
                String type = String.valueOf(col[headers.get("type")]);
                DisplayListingDsRequestModel listing = new DisplayListingDsRequestModel(brand, name, color, year, numSeats, price, phoneNumber, description, type);
                listings.add(listing);
            }

            reader.close();
        }
    }

    /**
     * @return list of all the listings in the database
     */
    @Override
    public List<DisplayListingDsRequestModel> getListings() {
        return listings;
    }
}
