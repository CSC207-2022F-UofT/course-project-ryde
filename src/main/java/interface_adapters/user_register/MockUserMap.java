package interface_adapters.user_register;

import use_cases.user_register.UserRegisterDsGateway;
import use_cases.user_register.UserRegisterDsRequestModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores a mock user hash map object to mimic the use of FileUser for testing purposes.
 */
public class MockUserMap implements UserRegisterDsGateway {

    private final Map<String, UserRegisterDsRequestModel> users = new HashMap<>();

    /**
     * @param identifier the user's email
     * @return whether the user exists
     */
    @Override
    public boolean existsByEmail(String identifier) {
        return users.containsKey(identifier);
    }

    /**
     * @param requestModel the data to save
     */
    @Override
    public void save(UserRegisterDsRequestModel requestModel) {
        users.put(requestModel.getEmail(), requestModel);
    }
}
