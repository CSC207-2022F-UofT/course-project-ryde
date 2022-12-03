package useCases.nearestDealership;

public class DealershipDsRequestModel {
    private final String name;
    private final String location;

    public DealershipDsRequestModel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
