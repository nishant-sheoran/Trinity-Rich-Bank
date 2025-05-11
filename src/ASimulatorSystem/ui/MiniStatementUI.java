package ASimulatorSystem.ui;

import javax.swing.*;
import java.awt.*;

public class MiniStatementUI extends JFrame {
    private String pin;
    public MiniStatementUI(String pin) {
        this.pin = pin;
        setTitle("CashSentinel - Mini Statement");
        setLayout(new BorderLayout());
        JTextArea ta = new JTextArea(10, 40);
        ta.setEditable(false);
        JScrollPane scroll = new JScrollPane(ta);
        add(scroll, BorderLayout.CENTER);
        // Call service to fetch and display mini statement
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
} 