package intefaceAdapters.userLogin;

public interface UserLoginScreenInterface {
    /**
     * @param loginMessage the message we want to display to the user when they have logged in.
     */
     void showLoggedInMessage(String loginMessage);

    /**
     * @param errorMessage the message we want to display to the user after failed log in.
     */
     void showFailureLoginMessage(String errorMessage);
}
