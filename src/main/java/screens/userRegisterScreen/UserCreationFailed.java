package screens.userRegisterScreen;

public class UserCreationFailed extends RuntimeException {
    public UserCreationFailed(String error) {
        super(error);
    }
}