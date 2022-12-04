package entities;
/**
 * Represents a user that has been logged in. Only one user can ever be logged in, hence it follows the
 * singleton design pattern
 */
public class LoggedInUserSingleton {
    private static LoggedInUserSingleton loggedInUser;
    private final String email;
    private final boolean isDealership;
    private LoggedInUserSingleton(String email, Boolean isDealership) {
        this.email = email;
        this.isDealership = isDealership;
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
    public static void init (String email, boolean isDealership) {
       if (loggedInUser != null)  {
           return;
       }
       loggedInUser = new LoggedInUserSingleton(email, isDealership);
    }

    /**
     * reset the instance variables for testing purposes.
     */

    public static void reset() {
        new LoggedInUserSingleton("", false);
        loggedInUser = null;
    }

    /**
     *
     * @return email instance variable
     */
    public String getEmail() {
       return email;
    }

    public boolean getIsDealership() { return isDealership; }
}
