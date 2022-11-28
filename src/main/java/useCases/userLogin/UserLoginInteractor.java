package useCases.userLogin;

import entities.LoggedInUserSingleton;

public class UserLoginInteractor implements UserLoginInputBoundary {
    private final UserLoginDsGateway userLoginDsGateway;
    private final UserLoginPresenter userLoginPresenter;

    /**
     * @param userLoginPresenter The output port that tells the view what to present
     */
    public UserLoginInteractor(UserLoginPresenter userLoginPresenter, UserLoginDsGateway gateway) {
        userLoginDsGateway = gateway;
        this.userLoginPresenter = userLoginPresenter;
    }


    /**
     * This function should implement the business logic of logging in a user.
     * Creates an instance of the LoggedInUserSingleton if the email and password
     * combination is found in the database. Calls different methods in the presenter based on whether
     * the user can be logged in.
     * @param requestModel The inputted email and password
     */
    @Override

    public void logInUser(UserLoginRequestModel requestModel) {
        String userEmail = requestModel.getEmail();
        String userPassword = requestModel.getPassword();
        if (userLoginDsGateway.validLogin(userEmail, userPassword)) {
            UserLoginResponseModel userLoginResponseModel = new UserLoginResponseModel("Welcome back to Ryde!");
            LoggedInUserSingleton.init(userEmail);
            userLoginPresenter.loginSuccess(userLoginResponseModel);
        } else {
            userLoginPresenter.failLogin("Incorrect email or password");
        }
    }
}
