package ASimulatorSystem.ui;

import ASimulatorSystem.service.AuthService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame implements ActionListener {
    private JTextField tfCardNo;
    private JPasswordField pfPin;
    private JButton btnSignIn, btnClear, btnSignUp;

    public LoginUI() {
        setTitle("CashSentinel - Login");
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblWelcome = new JLabel("Welcome to CashSentinel ATM");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 28));
        panel.add(lblWelcome, gbc);
        gbc.gridy++;
        panel.add(new JLabel("Card No:"), gbc);
        gbc.gridx = 1;
        tfCardNo = new JTextField(15);
        panel.add(tfCardNo, gbc);
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("PIN:"), gbc);
        gbc.gridx = 1;
        pfPin = new JPasswordField(15);
        panel.add(pfPin, gbc);
        gbc.gridx = 0; gbc.gridy++;
        btnSignIn = new JButton("Sign In");
        btnSignIn.addActionListener(this);
        panel.add(btnSignIn, gbc);
        gbc.gridx = 1;
        btnClear = new JButton("Clear");
        btnClear.addActionListener(this);
        panel.add(btnClear, gbc);
        gbc.gridx = 0; gbc.gridy++;
        btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(this);
        panel.add(btnSignUp, gbc);
        add(panel, BorderLayout.CENTER);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignIn) {
            String cardNo = tfCardNo.getText();
            String pin = new String(pfPin.getPassword());
            if (AuthService.authenticate(cardNo, pin)) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect Card Number or PIN");
            }
        } else if (e.getSource() == btnClear) {
            tfCardNo.setText("");
            pfPin.setText("");
        } else if (e.getSource() == btnSignUp) {
            setVisible(false);
            new Signup().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new LoginUI();
    }
} 