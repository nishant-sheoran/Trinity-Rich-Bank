package ASimulatorSystem.ui;

import ASimulatorSystem.service.SignupService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup3UI extends JFrame implements ActionListener {
    // Define fields for account details
    private JButton btnSubmit;
    public Signup3UI(String formNo) {
        setTitle("CashSentinel - Signup Step 3");
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        // Add fields for account type, card number, etc.
        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);
        panel.add(btnSubmit);
        add(panel, BorderLayout.CENTER);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            // Collect data and call SignupService
            // Show success or error
        }
    }
} 