public class AuthService {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    public static final String SUCCESS_MESSAGE = "Login successful.";
    public static final String INVALID_MESSAGE = "Incorrect username or password. Please try again.";


    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return VALID_USERNAME.equals(username.trim())
                && VALID_PASSWORD.equals(password);
    }
}