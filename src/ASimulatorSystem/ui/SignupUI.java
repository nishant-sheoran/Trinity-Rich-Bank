package ASimulatorSystem.ui;

import ASimulatorSystem.service.SignupService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupUI extends JFrame implements ActionListener {
    private JTextField tfName, tfFather, tfEmail, tfAddress, tfCity, tfPin, tfState;
    private JButton btnNext;
    // Add other fields as needed

    public SignupUI() {
        setTitle("CashSentinel - Signup");
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        tfName = new JTextField(15);
        panel.add(tfName, gbc);
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Father's Name:"), gbc);
        gbc.gridx = 1;
        tfFather = new JTextField(15);
        panel.add(tfFather, gbc);
        // ... Add other fields similarly
        gbc.gridx = 0; gbc.gridy++;
        btnNext = new JButton("Next");
        btnNext.addActionListener(this);
        panel.add(btnNext, gbc);
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
    public static void main(String[] args) {
        new SignupUI();
    }
} 