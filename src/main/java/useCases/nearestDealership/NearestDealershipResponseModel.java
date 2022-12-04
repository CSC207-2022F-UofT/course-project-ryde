package useCases.nearestDealership;

/**
 * Stores details about the nearest dealership
 */
public class NearestDealershipResponseModel {
    private final String name;
    private final String location;
    private final String duration;
    private final String distance;

    public NearestDealershipResponseModel(String name, String location, String duration, String distance) {
        this.name = name;
        this.location = location;
        this.duration = duration;
        this.distance = distance;
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

    /**
     * @return how long it takes to get to the dealership by car
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @return how far the dealership is
     */
    public String getDistance() {
        return distance;
    }
}
