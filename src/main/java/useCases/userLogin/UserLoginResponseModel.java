package useCases.userLogin;

public class UserLoginResponseModel {
    private final String loginMessage;
    private final String email;
    UserLoginResponseModel(String loginMessage, String email) {
        this.loginMessage = loginMessage;
        this.email = email;
    }
    public String getLoginMessage() {
        return loginMessage;
    }

    public String getEmail() {
        return email;
    }
}

