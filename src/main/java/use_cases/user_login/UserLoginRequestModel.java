package use_cases.user_login;

public class UserLoginRequestModel {
    private final String email;
    private final String password;

    /**
     * Sets instance variables to the parameters
     * @param email Email that the user has inputted
     * @param password password that the user has inputted
     */
    public UserLoginRequestModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * @return the email instance variable
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password instance variable
     */
    public String getPassword() {
        return password;
    }
}
