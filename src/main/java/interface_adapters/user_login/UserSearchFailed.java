package interface_adapters.user_login;

public class UserSearchFailed extends RuntimeException{
    public UserSearchFailed(String error) { super(error); }
}