package use_cases.user_login;

public interface UserLoginDsGateway {
     /**
      * @param email Email that the user has entered
      * @param password Password that the user has entered
      * @return Whether the password and email was found in the database of users
      */
     boolean validLogin(String email, String password);
     /**
      * @param email    Email that the user has entered
      * @return Whether the user is a dealership type of user or not.
      */
     boolean isDealership(String email);
}
