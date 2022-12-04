package useCases.nearestDealership;

public class NearestDealershipRequestModel {
    private final String userLocation;

    public NearestDealershipRequestModel(String location) {
        this.userLocation = location;
    }

    /**
     * @return location of the user
     */
    public String getUserLocation() {
        return userLocation;
    }
}
