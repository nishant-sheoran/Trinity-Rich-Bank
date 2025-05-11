package ASimulatorSystem.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionsUI extends JFrame implements ActionListener {
    private JButton btnDeposit, btnWithdraw, btnFastCash, btnMiniStatement, btnPinChange, btnBalanceEnquiry, btnExit;
    private String pin;
    public TransactionsUI(String pin) {
        this.pin = pin;
        setTitle("CashSentinel - Transactions");
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBackground(Color.WHITE);
        btnDeposit = new JButton("Deposit");
        btnWithdraw = new JButton("Withdraw");
        btnFastCash = new JButton("Fast Cash");
        btnMiniStatement = new JButton("Mini Statement");
        btnPinChange = new JButton("PIN Change");
        btnBalanceEnquiry = new JButton("Balance Enquiry");
        btnExit = new JButton("Exit");
        for (JButton btn : new JButton[]{btnDeposit, btnWithdraw, btnFastCash, btnMiniStatement, btnPinChange, btnBalanceEnquiry, btnExit}) {
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.addActionListener(this);
            panel.add(btn);
        }
        add(panel, BorderLayout.CENTER);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnDeposit) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (src == btnWithdraw) {
            // Open Withdraw UI
        } else if (src == btnFastCash) {
            // Open Fast Cash UI
        } else if (src == btnMiniStatement) {
            // Open Mini Statement UI
        } else if (src == btnPinChange) {
            // Open PIN Change UI
        } else if (src == btnBalanceEnquiry) {
            // Open Balance Enquiry UI
        } else if (src == btnExit) {
            System.exit(0);
        }
    }
} 