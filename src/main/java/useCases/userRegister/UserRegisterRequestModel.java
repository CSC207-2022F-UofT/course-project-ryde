package useCases.userRegister;

public class UserRegisterRequestModel {
    private String email;
    private String password;
    private String name;

    private String repeatPassword;

    private String location;

    public UserRegisterRequestModel(String email, String password, String repeatPassword, String name) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.name = name;
    }

    public UserRegisterRequestModel(String email, String password, String name, String repeatPassword, String location) {
        this.email = email;
        this.password = password;
        this.repeatPassword = password;
        this.name = name;
        this.location = location;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
