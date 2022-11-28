package useCases.deleteListing;

public class DeleteListingRequestModel {
    private final String uuid;

    /**
     * @return uuid of the listing to be deleted
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid It is the unique ID assigned to each listing
     */
    public DeleteListingRequestModel(String uuid) {
        this.uuid = uuid;
    }
}
