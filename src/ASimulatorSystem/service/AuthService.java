package ASimulatorSystem.service;

import ASimulatorSystem.dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthService {
    public static boolean authenticate(String cardNo, String pin) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM login WHERE cardnumber = ? AND pin = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cardNo);
                ps.setString(2, pin);
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
} 