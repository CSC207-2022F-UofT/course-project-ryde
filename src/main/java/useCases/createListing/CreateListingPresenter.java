package useCases.createListing;

public interface CreateListingPresenter {
    void prepareSuccessView(CreateListingResponseModel listing);
    void prepareFailView(String error);
}
