package ASimulatorSystem.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WithdrawUI extends JFrame implements ActionListener {
    private JTextField tfAmount;
    private JButton btnWithdraw, btnBack;
    private String pin;
    public WithdrawUI(String pin) {
        this.pin = pin;
        setTitle("CashSentinel - Withdraw");
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Enter Amount to Withdraw:"), gbc);
        gbc.gridx = 1;
        tfAmount = new JTextField(15);
        panel.add(tfAmount, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.addActionListener(this);
        panel.add(btnWithdraw, gbc);
        gbc.gridx = 1;
        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        panel.add(btnBack, gbc);
        add(panel, BorderLayout.CENTER);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnWithdraw) {
            // Withdraw logic
        } else if (e.getSource() == btnBack) {
            setVisible(false);
            new TransactionsUI(pin).setVisible(true);
        }
    }
} 