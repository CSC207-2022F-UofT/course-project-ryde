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

    public static LoggedInUserSingleton getInstance()
    {
        if (loggedInUser == null) {
            throw new AssertionError("init has not been called first.");
        }
        return loggedInUser;
    }

    public static void init (String email) {
       if (loggedInUser != null)  {
           return;
       }
       loggedInUser = new LoggedInUserSingleton(email);
    }

    public String getEmail() {
       return email;
    }
}
