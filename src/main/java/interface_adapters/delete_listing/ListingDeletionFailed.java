package interface_adapters.delete_listing;

public class ListingDeletionFailed extends RuntimeException{
    public ListingDeletionFailed(String error) { super(error); }
}
