package screens.userRegisterScreen;


import useCases.userRegister.UserRegisterInputBoundary;
import useCases.userRegister.UserRegisterRequestModel;
import useCases.userRegister.UserRegisterResponseModel;

public class UserRegisterController {
    final UserRegisterInputBoundary userInput;

    public UserRegisterController(UserRegisterInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    UserRegisterResponseModel create(String email, String password1, String password2, String name) {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                email, password1, password2, name);

        return userInput.create(requestModel);
    }

    UserRegisterResponseModel create(String email, String password1, String password2, String name, String location) {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                email, password1, password2, name, location);

        return userInput.create(requestModel);
    }
}
