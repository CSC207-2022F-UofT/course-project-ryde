package useCases.nearestDealership;

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

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDuration() {
        return duration;
    }

    public String getDistance() {
        return distance;
    }
}
