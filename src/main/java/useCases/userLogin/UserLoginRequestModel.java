package useCases.userLogin;

public class UserLoginRequestModel {
    private final String email;
    private final String password;

    public UserLoginRequestModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
