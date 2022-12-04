package use_cases.nearest_dealership;

/**
 * Stores the name and location of the dealership
 */
public class DealershipDsRequestModel {
    private final String name;
    private final String location;

    public DealershipDsRequestModel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    /**
     * @return name of the dealership
     */
    public String getName() {
        return name;
    }

    /**
     * @return postal code of the dealership
     */
    public String getLocation() {
        return location;
    }
}
