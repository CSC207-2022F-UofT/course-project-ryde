package interface_adapters.create_listing;

public class ListingCreationFailed extends RuntimeException{
    public ListingCreationFailed(String error) { super(error); }
}
