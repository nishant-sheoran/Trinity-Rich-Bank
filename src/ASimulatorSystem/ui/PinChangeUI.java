package ASimulatorSystem.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChangeUI extends JFrame implements ActionListener {
    private JPasswordField pfOldPin, pfNewPin, pfConfirmPin;
    private JButton btnChange, btnBack;
    private String pin;
    public PinChangeUI(String pin) {
        this.pin = pin;
        setTitle("CashSentinel - PIN Change");
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Old PIN:"), gbc);
        gbc.gridx = 1;
        pfOldPin = new JPasswordField(15);
        panel.add(pfOldPin, gbc);
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("New PIN:"), gbc);
        gbc.gridx = 1;
        pfNewPin = new JPasswordField(15);
        panel.add(pfNewPin, gbc);
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Confirm PIN:"), gbc);
        gbc.gridx = 1;
        pfConfirmPin = new JPasswordField(15);
        panel.add(pfConfirmPin, gbc);
        gbc.gridx = 0; gbc.gridy++;
        btnChange = new JButton("Change PIN");
        btnChange.addActionListener(this);
        panel.add(btnChange, gbc);
        gbc.gridx = 1;
        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        panel.add(btnBack, gbc);
        add(panel, BorderLayout.CENTER);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChange) {
            // Change PIN logic
        } else if (e.getSource() == btnBack) {
            setVisible(false);
            new TransactionsUI(pin).setVisible(true);
        }
    }
} 