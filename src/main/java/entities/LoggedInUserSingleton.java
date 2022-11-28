package entities;
/**
 * Represents a user that has been logged in. Only one user can ever be logged in, hence it follows the
 * singleton design pattern
 */
public class LoggedInUserSingleton {
    private static LoggedInUserSingleton loggedInUser;
    private final String email;
    private LoggedInUserSingleton(String email) {
        this.email = email;
    }

    /**
     * @return the loggedInUser if  the class has been initialized, otherwise throw an AssertionError.
     */
    public static LoggedInUserSingleton getInstance()
    {
        if (loggedInUser == null) {
            throw new AssertionError("init has not been called first.");
        }
        return loggedInUser;
    }

    /**
     * initialize the loggedInUser instance variable by calling the private constructor.
     * @param email the email of the user.
     */
    public static void init (String email) {
       if (loggedInUser != null)  {
           return;
       }
       loggedInUser = new LoggedInUserSingleton(email);
    }

    /**
     * reset the instance variables for testing purposes.
     */

    public static void reset() {
        new LoggedInUserSingleton("");
        loggedInUser = null;
    }

    /**
     *
     * @return email instance variable
     */
    public String getEmail() {
       return email;
    }
}
