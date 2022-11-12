package useCases.createListing;

import useCases.createListing.CreateListingResponseModel;

public interface CreateListingPresenter {
    void prepareSuccessView(CreateListingResponseModel listing);
    void prepareFailView(String error);
}
