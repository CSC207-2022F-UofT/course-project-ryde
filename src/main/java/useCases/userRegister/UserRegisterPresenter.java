package useCases.userRegister;

public interface UserRegisterPresenter {
    /**
     * @return success view that is rendered when a new user is successfully created
     */
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user);

    /**
     * @return Fail view that is rendered when a user is not created due to error
     */
    UserRegisterResponseModel prepareFailView(String error);
}
