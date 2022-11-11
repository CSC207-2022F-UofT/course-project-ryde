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
        String userEmail = requestModel.getEmail();
        String userPassword = requestModel.getPassword();
        if (userLoginDsGateway.validLogin(userEmail, userPassword)) {
            UserLoginResponseModel userLoginResponseModel = new UserLoginResponseModel("Welcome back to Ryde!", userEmail);
            LoggedInUserSingleton.init(userEmail);
            userLoginPresenter.loginSuccess(userLoginResponseModel);
        } else {
            userLoginPresenter.failLogin("Incorrect email or password");
        }
    }
}
