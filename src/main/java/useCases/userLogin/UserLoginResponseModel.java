package useCases.userLogin;

public class UserLoginResponseModel {
    private final String loginMessage;

    /**
     * @param loginMessage The message we want to send to the user after a login attempt
     */
    UserLoginResponseModel(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    /**
     * @return the loginMessage instance variable
     */
    public String getLoginMessage() {
        return loginMessage;
    }
}

