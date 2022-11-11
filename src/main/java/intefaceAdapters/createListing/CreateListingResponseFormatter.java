package intefaceAdapters.createListing;

import screens.WelcomeScreen;
import useCases.createListing.CreateListingPresenter;
import useCases.createListing.CreateListingResponseModel;

public class CreateListingResponseFormatter implements CreateListingPresenter {
    CreateListingScreenInterface view;

    public CreateListingResponseFormatter(CreateListingScreenInterface view) {
        this.view = view;
    }
    @Override
    public void prepareSuccessView(CreateListingResponseModel listing) {
        view.showCreatedListingMessage(listing.getResponseMessage());
    }

    @Override
    public void prepareFailView(String error) {
        view.showCreatedListingMessageFailure(error);
    }
}
