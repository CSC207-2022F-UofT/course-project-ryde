package useCases.userRegister;

public interface UserRegisterDsGateway {
    boolean existsByEmail(String identifier);

    void save(UserRegisterDsRequestModel requestModel);
}
