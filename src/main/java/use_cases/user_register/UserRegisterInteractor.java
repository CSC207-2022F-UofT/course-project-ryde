package use_cases.user_register;

import entities.DealershipUser;
import entities.UserFactory;
import java.time.LocalDateTime;
import entities.User;

/**
 * This is UserRegisterUseCase
 */
public class UserRegisterInteractor implements UserRegisterInputBoundary{
    final UserRegisterDsGateway userDsGateway;
    final UserRegisterPresenter userPresenter;
    final UserFactory userFactory;

    public UserRegisterInteractor(UserRegisterDsGateway userRegisterDsGateway, UserRegisterPresenter userRegisterPresenter, UserFactory userFactory) {
        this.userDsGateway = userRegisterDsGateway;
        this.userPresenter = userRegisterPresenter;
        this.userFactory = userFactory;
    }

    /**
     * @param requestModel contains details about the user wishing to be created
     * @return success view if the user was created successfully and failure view if the user was not created
     */
    @Override
    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel) {
        if (requestModel.getName().equals("")){
            return userPresenter.prepareFailView("Please fill out the the form fully");
        }
        if (userDsGateway.existsByEmail(requestModel.getEmail())) {
            return userPresenter.prepareFailView("User already exists.");
        } else if (!requestModel.getPassword().equals(requestModel.getRepeatPassword())) {
            return userPresenter.prepareFailView("Passwords don't match.");
        }

        User user;

        if (requestModel.getLocation() == null) {
            user = userFactory.create(requestModel.getEmail(), requestModel.getPassword(), requestModel.getName());
        } else {
            user = userFactory.create(requestModel.getEmail(), requestModel.getPassword(), requestModel.getName(), requestModel.getLocation());
            if (!DealershipUser.isValidLocation(((DealershipUser) user).getLocation())) {
                return userPresenter.prepareFailView("Please enter a valid location in Toronto");
            }
        }
        if (!user.isValidPassword()) {
            return userPresenter.prepareFailView("User password must have more than 7 characters.");
        }
        if (!user.isValidEmail()) {
            return userPresenter.prepareFailView("Please enter a valid email address");
        }

        LocalDateTime now = LocalDateTime.now();
        UserRegisterDsRequestModel userDsModel = new UserRegisterDsRequestModel(user.getEmail(), user.getName(), user.getPassword(), now,"", requestModel.getLocation());
        userDsGateway.save(userDsModel);

        UserRegisterResponseModel accountResponseModel = new UserRegisterResponseModel(user.getName(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
}
}
