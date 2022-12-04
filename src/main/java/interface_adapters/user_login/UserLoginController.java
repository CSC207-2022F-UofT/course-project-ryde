package interface_adapters.user_login;

import use_cases.user_login.*;

public class UserLoginController {
    private final UserLoginInputBoundary userInput;

    /**
     * @param presenter the presenter tha communicates the view to tell it what to dispaly.
     */
    public UserLoginController(UserLoginPresenter presenter, UserLoginDsGateway gateway) {
        this.userInput = new UserLoginInteractor(presenter, gateway);
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
