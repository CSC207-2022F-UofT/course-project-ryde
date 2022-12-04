package interface_adapters.create_listing;

import use_cases.create_listing.CreateListingPresenter;
import use_cases.create_listing.CreateListingResponseModel;

public class CreateListingResponseFormatter implements CreateListingPresenter {
    private final CreateListingScreenInterface view;

    public CreateListingResponseFormatter(CreateListingScreenInterface view) {
        this.view = view;
    }

    /**
     * @param listing shows the success view for the listing which is successfully created by the user
     */
    @Override
    public void prepareSuccessView(CreateListingResponseModel listing) {
        view.showCreatedListingMessage(listing.getResponseMessage());
    }

    /**
     * @param error shows the fail view error message to the user when the creation of the listing is unsuccessful
     */
    @Override
    public void prepareFailView(String error) {
        view.showCreatedListingMessageFailure(error);
    }
}
