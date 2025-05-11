package ASimulatorSystem.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MLNoteVerifier {
    private static final String ML_API_URL = "http://localhost:5000/api/verify_note";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static VerificationResult verifyNote(Map<String, Object> noteFeatures) throws Exception {
        URL url = new URL(ML_API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonInput = objectMapper.writeValueAsString(noteFeatures);
        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonInput.getBytes());
            os.flush();
        }

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        VerificationResult result = objectMapper.readValue(conn.getInputStream(), VerificationResult.class);
        conn.disconnect();
        return result;
    }

    public static class VerificationResult {
        public boolean isGenuine;
        public double confidence;
        public String message;
    }
} 