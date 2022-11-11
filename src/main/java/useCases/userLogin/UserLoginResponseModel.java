package useCases.userLogin;

public class UserLoginResponseModel {
    private final String loginMessage;
    private final String email;

    /**
     * @param loginMessage The message we want to send to the user after a login attempt
     * @param email The email the user logged in with.
     */
    UserLoginResponseModel(String loginMessage, String email) {
        this.loginMessage = loginMessage;
        this.email = email;
    }

    /**
     * @return the loginMessage instance variable
     */
    public String getLoginMessage() {
        return loginMessage;
    }

    /**
     * @return the email instance variable.
     */
    public String getEmail() {
        return email;
    }
}

