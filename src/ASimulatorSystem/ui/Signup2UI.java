package ASimulatorSystem.ui;

import ASimulatorSystem.service.SignupService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2UI extends JFrame implements ActionListener {
    // Define fields for additional details
    private JButton btnNext;
    public Signup2UI(String formNo) {
        setTitle("CashSentinel - Signup Step 2");
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        // Add fields for religion, category, income, etc.
        btnNext = new JButton("Next");
        btnNext.addActionListener(this);
        panel.add(btnNext);
        add(panel, BorderLayout.CENTER);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            // Collect data and call SignupService
            // Show next signup screen or error
        }
    }
} 