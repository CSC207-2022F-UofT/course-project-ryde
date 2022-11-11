package intefaceAdapters.userLogin;

import useCases.userLogin.UserLoginInputBoundary;
import useCases.userLogin.UserLoginInteractor;
import useCases.userLogin.UserLoginPresenter;
import useCases.userLogin.UserLoginRequestModel;

public class UserLoginController {
    private final UserLoginInputBoundary userInput;

    /**
     * @param presenter the presenter tha communicates the view to tell it what to dispaly.
     */
    public UserLoginController(UserLoginPresenter presenter) {
        this.userInput = new UserLoginInteractor(presenter);
    }

    /**
     * @param email email that the user has entered
     * @param password password that the user has entered
     */
    public void callUserLoginInteractor(String email, String password) {
        UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel(email, password);
        userInput.logInUser(userLoginRequestModel);
    }

}
