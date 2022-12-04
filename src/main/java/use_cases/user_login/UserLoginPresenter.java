package use_cases.user_login;

public interface UserLoginPresenter {
   /**
    * This function should tell the view what to call when a login attempt is successful.
    * @param userInfo The Data Structure that represents the response we want to send to the user
    */
   void loginSuccess(UserLoginResponseModel userInfo);

   /**
    * @param error A string which represents the error message we want to send to the user when
    * there log in attempt has failed.
    */
   void failLogin(String error);
}
