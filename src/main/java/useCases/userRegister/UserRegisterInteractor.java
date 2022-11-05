package useCases.userRegister;

import entities.DealershipUser;
import entities.UserFactory;
import java.time.LocalDateTime;
import entities.User;

public class UserRegisterInteractor implements UserRegisterInputBoundary{
    final UserRegisterDsGateway userDsGateway;
    final UserRegisterPresenter userPresenter;
    final UserFactory userFactory;

    public UserRegisterInteractor(UserRegisterDsGateway userRegisterDsGateway, UserRegisterPresenter userRegisterPresenter, UserFactory userFactory) {
        this.userDsGateway = userRegisterDsGateway;
        this.userPresenter = userRegisterPresenter;
        this.userFactory = userFactory;
    }

    @Override
    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel) {
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
            if (!((DealershipUser) user).isValidLocation()) {
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
