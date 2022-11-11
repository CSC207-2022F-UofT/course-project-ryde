package screens.userRegisterScreen;

import useCases.userRegister.UserRegisterPresenter;
import useCases.userRegister.UserRegisterResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class UserRegisterResponseFormatter implements UserRegisterPresenter {

    /**
     * @return success view that is rendered when a new user is successfully created
     */
    @Override
    public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    /**
     * @return Fail view that is rendered when a user is not created due to error
     */
    @Override
    public UserRegisterResponseModel prepareFailView(String error) {
        throw new UserCreationFailed(error);
    }
}