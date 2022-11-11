package intefaceAdapters.userLogin;

import screens.UserLoginScreen;
import useCases.userLogin.UserLoginPresenter;
import useCases.userLogin.UserLoginResponseModel;

public class UserLoginResponseFormatter implements UserLoginPresenter {
    private final UserLoginScreenInterface userLoginView;

    public UserLoginResponseFormatter(UserLoginScreenInterface userLoginView) {
        this.userLoginView = userLoginView;
    }
    @Override
    public void loginSuccess(UserLoginResponseModel userInfo) {
        userLoginView.showLoggedInMessage(userInfo.getLoginMessage());
    }

    @Override
    public void failLogin(String error) {
        userLoginView.showFailureLoginMessage(error);
    }
}
