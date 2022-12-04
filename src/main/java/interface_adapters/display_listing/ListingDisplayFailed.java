package interface_adapters.display_listing;

public class ListingDisplayFailed extends RuntimeException{
    public ListingDisplayFailed(String error) { super(error); }
}
