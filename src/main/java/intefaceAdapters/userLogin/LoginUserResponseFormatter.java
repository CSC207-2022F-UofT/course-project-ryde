package intefaceAdapters.userLogin;

import screens.userLoginScreen.LoggedInUserSingleton;
import useCases.userLogin.UserLoginPresenter;
import useCases.userLogin.UserLoginResponseModel;

public class LoginUserResponseFormatter implements UserLoginPresenter {
    private final LoginUserScreenInterface userLoginView;

    public LoginUserResponseFormatter(LoginUserScreenInterface userLoginView) {
        this.userLoginView = userLoginView;
    }
    @Override
    public void loginSuccess(UserLoginResponseModel userInfo) {
        LoggedInUserSingleton.init(userInfo.getEmail());
        userLoginView.showLoggedInMessage(userInfo.getLoginMessage());
    }

    @Override
    public void failLogin(String error) {
        userLoginView.showFailureLoginMessage(error);
    }
}
