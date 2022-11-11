package intefaceAdapters.userLogin;

import screens.UserLoginScreen;
import useCases.userLogin.UserLoginPresenter;
import useCases.userLogin.UserLoginResponseModel;

public class UserLoginResponseFormatter implements UserLoginPresenter {
    private final UserLoginScreenInterface userLoginView;

    /**
     * @param userLoginView the gui that allows the user into interact with the program
     */
    public UserLoginResponseFormatter(UserLoginScreenInterface userLoginView) {
        this.userLoginView = userLoginView;
    }

    /**
     * This function should tell the view what to call when a login attempt is successful.
     * @param userInfo The Data Structure that represents the response we want to send to the user
     */
    @Override
    public void loginSuccess(UserLoginResponseModel userInfo) {
        userLoginView.showLoggedInMessage(userInfo.getLoginMessage());
    }

    /**
     * @param error A string which represents the error message we want to send to the user when
     * there log in attempt has failed.
     */
    @Override
    public void failLogin(String error) {
        userLoginView.showFailureLoginMessage(error);
    }
}
