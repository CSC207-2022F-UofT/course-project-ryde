package screens.userRegisterScreen;

import useCases.userRegister.UserRegisterDsGateway;
import useCases.userRegister.UserRegisterDsRequestModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores a mock user hash map object to mimic the use of FileUser for testing purposes.
 */
public class MockUserMap implements UserRegisterDsGateway {

    final private Map<String, UserRegisterDsRequestModel> users = new HashMap<>();

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
        System.out.println("Save " + requestModel.getEmail());
        users.put(requestModel.getEmail(), requestModel);
    }
}
