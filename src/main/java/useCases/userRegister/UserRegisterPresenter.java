package useCases.userRegister;

public interface UserRegisterPresenter {
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user);

    UserRegisterResponseModel prepareFailView(String error);
}
