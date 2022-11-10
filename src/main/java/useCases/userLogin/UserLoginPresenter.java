package useCases.userLogin;

public interface UserLoginPresenter {
   void loginSuccess(UserLoginResponseModel userInfo);

   void failLogin(String error);
}
