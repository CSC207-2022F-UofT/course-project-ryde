package intefaceAdapters.userLogin;

import useCases.userLogin.UserLoginInputBoundary;
import useCases.userLogin.UserLoginInteractor;
import useCases.userLogin.UserLoginPresenter;
import useCases.userLogin.UserLoginRequestModel;

public class UserLoginController {
    private final UserLoginInputBoundary userInput;
    public UserLoginController(UserLoginPresenter presenter) {
        this.userInput = new UserLoginInteractor(presenter);
    }

    public void callUserLoginInteractor(String email, String password) {
        UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel(email, password);
        userInput.logInUser(userLoginRequestModel);
    }

}
