package useCases.userLogin;

import entities.LoggedInUserSingleton;
import intefaceAdapters.userLogin.FindUser;

import java.io.IOException;

public class UserLoginInteractor implements UserLoginInputBoundary {
    private final UserLoginDsGateway userLoginDsGateway;
    private final UserLoginPresenter userLoginPresenter;

    public UserLoginInteractor(UserLoginPresenter userLoginPresenter) {
        try {
            userLoginDsGateway = new FindUser("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not find file");
        }
        this.userLoginPresenter = userLoginPresenter;
    }


    @Override
    public void logInUser(UserLoginRequestModel requestModel) {
        if (userLoginDsGateway.validLogin(requestModel.getEmail(), requestModel.getPassword())) {
            UserLoginResponseModel userLoginResponseModel = new UserLoginResponseModel("Welcome back to Ryde!", requestModel.getEmail());
            LoggedInUserSingleton.init(requestModel.getEmail());
            userLoginPresenter.loginSuccess(userLoginResponseModel);
        } else {
            userLoginPresenter.failLogin("Incorrect email or password");
        }
    }
}
