package use_cases.user_login;

public interface UserLoginInputBoundary {
    /**
     * This function should implement the business logic of logging in a user.
     * @param requestModel The inputted email and password
     */
    void logInUser(UserLoginRequestModel requestModel);

}
