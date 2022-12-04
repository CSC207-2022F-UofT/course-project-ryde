package use_cases.user_register;

/**
 * A response model that stores the user's name and the creation time
 */
public class UserRegisterResponseModel {
    private final String login;
    String creationTime;

    public UserRegisterResponseModel(String login, String creationTime) {
        this.login = login;
        this.creationTime = creationTime;
    }

    /**
     * @return name of the user
     */
    public String getLogin() {
        return login;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
