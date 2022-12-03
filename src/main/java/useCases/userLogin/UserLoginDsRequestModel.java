package useCases.userLogin;

public class UserLoginDsRequestModel {
    public String getPassword() {
        return password;
    }

    public boolean getIsDealership() {
        return isDealership;
    }

    private final String password;
    private final boolean isDealership;

    public UserLoginDsRequestModel(String password, boolean isDealership) {
       this.password = password;
       this.isDealership = isDealership;
    }

}
