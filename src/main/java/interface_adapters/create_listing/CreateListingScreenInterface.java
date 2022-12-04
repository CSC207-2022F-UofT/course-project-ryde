package interface_adapters.create_listing;

/**
 * interface that the CreateListingScreen implements for the dependency inversion rule.
 */
public interface CreateListingScreenInterface {
     /**
      * @param message success message when listing is created
      * tells the view to display the success message when a listing is created
      */
     void showCreatedListingMessage(String message);

     /**
      * @param error error message when listing is not created
      * tells the view to display an error message when listing cannot be created
      */
     void showCreatedListingMessageFailure(String error);

}
