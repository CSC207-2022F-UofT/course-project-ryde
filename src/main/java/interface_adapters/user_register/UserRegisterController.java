package interface_adapters.user_register;


import use_cases.user_register.UserRegisterInputBoundary;
import use_cases.user_register.UserRegisterRequestModel;
import use_cases.user_register.UserRegisterResponseModel;

/**
 * This is the controller for the UserRegister use case
 */
public class UserRegisterController {
    final UserRegisterInputBoundary userInput;

    public UserRegisterController(UserRegisterInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    /**
     * @param email email of user
     * @param password1 password of user
     * @param password2 repeated password of user
     * @param name name of user
     * @return a response model with name of the individual user and creation time
     */
    public UserRegisterResponseModel create(String email, String password1, String password2, String name) {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                email, password1, password2, name);

        return userInput.create(requestModel);
    }

    /**
     * @param email email of user
     * @param password1 password of user
     * @param password2 repeated password of user
     * @param name name of user
     * @param location location of the dealership
     * @return a response model with name of the dealership user and creation time
     */
   public UserRegisterResponseModel create(String email, String password1, String password2, String name, String location) {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                email, password1, password2, name, location);

        return userInput.create(requestModel);
    }
}
