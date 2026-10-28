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

    public String getUserData(String userId) {
        // SQL injection + no null check + sensitive data logged
        try {
            Connection conn = DriverManager.getConnection(DB_URL, "root", DB_PASSWORD);
            String query = "SELECT * FROM users WHERE id = " + userId;
            System.out.println("Executing query: " + query); // logs sensitive query
            conn.createStatement().execute(query);
            String secret = "secret_" + userId; // hardcoded password pattern
            return secret;
        } catch (Exception e) {
            // silently ignored again
        }
        return null;
    }

    public String resetPassword(String userId, String newPassword) {
        // No input validation
        // Password stored in plain text
        // SQL injection risk
        // Sensitive data logged
        try {
            Connection conn = DriverManager.getConnection(DB_URL, "root", DB_PASSWORD);
            String query = "UPDATE users SET password = '" + newPassword + "' WHERE id = " + userId;
            System.out.println("Resetting password for user: " + userId + " to: " + newPassword);
            conn.createStatement().execute(query);
            return "Password reset for " + userId;
        } catch (Exception e) {
            // silently ignored
        }
        return null;
    }

    public List getUsersByRole(String role) {
        // SQL injection
        // Raw type
        // No null check
        // Sensitive data logged
        try {
            Connection conn = DriverManager.getConnection(DB_URL, "root", DB_PASSWORD);
            String query = "SELECT * FROM users WHERE role = '" + role + "'";
            System.out.println("DB credentials: " + DB_URL + " password: " + DB_PASSWORD);
            conn.createStatement().execute(query);
        } catch (Exception e) {
            // silently ignored
        }
        return new java.util.ArrayList();
    }
}
