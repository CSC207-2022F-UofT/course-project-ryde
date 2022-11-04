package entities;

import java.util.List;

public class IndividualUserFactory{

    public User create(String email, String password, String name) {
        return new IndividualUser(email, password, name);
    }
}
