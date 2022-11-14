package useCases.deleteListing;

public class DeleteListingRequestModel {
    private final String uuid;

    public String getUuid() {
        return uuid;
    }

    public DeleteListingRequestModel(String uuid) {
        this.uuid = uuid;
    }
}
