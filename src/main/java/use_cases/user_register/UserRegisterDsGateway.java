package use_cases.user_register;

public interface UserRegisterDsGateway {
    /**
     * @param identifier email that the user has input
     * @return whether a user with the same email already exists in the database
     */
    boolean existsByEmail(String identifier);

    /**
     * @param requestModel data about the user to be stored
     * This method saves the user data in users.csv
     */
    void save(UserRegisterDsRequestModel requestModel);
}
