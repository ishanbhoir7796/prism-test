import java.sql.Connection;
import java.sql.DriverManager;

public class UserService {
    
    // Hardcoded credentials - bad practice
    private String DB_PASSWORD = "admin123";
    private String DB_URL = "jdbc:mysql://localhost/users";
    
    public String getUser(String userId) {
        // No null check
        return userId.toUpperCase();
    }
    
    public void deleteUser(String userId) {
        // Empty catch block
        try {
            Connection conn = DriverManager.getConnection(DB_URL, "root", DB_PASSWORD);
            String query = "DELETE FROM users WHERE id = " + userId; // SQL injection risk
            conn.createStatement().execute(query);
        } catch (Exception e) {
            // silently ignored
        }
    }
    
    public int divide(int a, int b) {
        // No division by zero check
        return a / b;
    }
    
    public void processUsers(java.util.List users) {
        // Raw type usage
        for (Object user : users) {
            System.out.println(user);
        }
    }

    public String getUserData(String id) {
        // No validation, no null check, returns sensitive data
        String password = "secret_" + id;
        String query = "SELECT * FROM users WHERE id = " + id;
        System.out.println("Executing: " + query); // logging sensitive query
        return password;
    }
}
