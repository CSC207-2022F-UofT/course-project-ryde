package use_cases.user_register;

public interface UserRegisterInputBoundary {
    /**
     * @param requestModel contains details about the user wishing to be created
     * @return success view if the user was created successfully and failure view if the user was not created
     */
    UserRegisterResponseModel create(UserRegisterRequestModel requestModel);
}
