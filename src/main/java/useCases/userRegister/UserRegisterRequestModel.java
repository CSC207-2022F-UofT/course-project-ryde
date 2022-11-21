package useCases.userRegister;

/**
 * This model stores the email, password, name, repeatedPassword of the User.
 * If the User is a Dealership user then it also stores location, which is otherwise null.
 */
public class UserRegisterRequestModel {
    private final String email;
    private final String password;
    private final String name;

    private final String repeatPassword;

    private String location;

    public UserRegisterRequestModel(String email, String password, String repeatPassword, String name) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.name = name;
    }

    public UserRegisterRequestModel(String email, String password, String repeatPassword, String name, String location) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.name = name;
        this.location = location;
    }

    String getName() {
        return name;
    }

    String getPassword() {
        return password;
    }

    String getEmail() {
        return email;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getLocation() {
        return location;
    }
}
