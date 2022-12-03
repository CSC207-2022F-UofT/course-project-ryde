package intefaceAdapters.nearestDealership;

import useCases.displayListing.DisplayListingDsRequestModel;
import useCases.nearestDealership.DealershipDsRequestModel;
import useCases.nearestDealership.NearestDealershipDsGateway;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible to interact with the users database and access the dealerships
 */
public class DealershipRepo implements NearestDealershipDsGateway {

    private final List<DealershipDsRequestModel> dealerships = new ArrayList<>();

    /**
     * @param csvPath file containing the user data
     */
    public DealershipRepo(String csvPath) throws IOException{
        File csvFile = new File(csvPath);
        if (csvFile.length() > 0) {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String name = String.valueOf(col[2]);
                String location = String.valueOf(col[5]);
                DealershipDsRequestModel dealership = new DealershipDsRequestModel(name, location);
                if (!location.equals("null")){
                    dealerships.add(dealership);
                }
            }

            reader.close();
        }
    }

    /**
     * @return all the dealerships in the database
     */
    @Override
    public List<DealershipDsRequestModel> getDealerships() {
        return dealerships;
    }
}
