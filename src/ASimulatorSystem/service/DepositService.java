package ASimulatorSystem.service;

import ASimulatorSystem.dao.DatabaseConnection;
import ASimulatorSystem.integration.MLNoteVerifier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Map;

public class DepositService {
    public static boolean deposit(String pin, String amount, Date date, Map<String, Object> noteFeatures) throws Exception {
        // ML verification
        MLNoteVerifier.VerificationResult result = MLNoteVerifier.verifyNote(noteFeatures);
        if (!result.isGenuine) {
            throw new Exception("Fake note detected: " + result.message);
        }
        // Deposit to DB
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, pin);
                ps.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                ps.setString(3, "Deposit");
                ps.setString(4, amount);
                ps.executeUpdate();
            }
        }
        return true;
    }
} 