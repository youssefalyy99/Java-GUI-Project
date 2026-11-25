package BackEnd;

public class AuthService {
    private final String username = "admin";
    private final String password = "admin123";
    public boolean login(String user, String pass){
        if(user.equals(username) && pass.equals(password)){
            return true;
        }
        return false;
    }
}
