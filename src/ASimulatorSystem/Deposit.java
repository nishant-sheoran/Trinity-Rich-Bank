package ASimulatorSystem;

import ASimulatorSystem.service.DepositService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Deposit extends JFrame implements ActionListener{
    JTextField t1;
    JButton b1, b2;
    JLabel l1;
    String pin;
    public Deposit(String pin){
        this.pin = pin;
        setTitle("Deposit - CashSentinel");
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0;
        l1 = new JLabel("Enter Amount to Deposit:");
        l1.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(l1, gbc);
        gbc.gridx = 1;
        t1 = new JTextField(15);
        t1.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(t1, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        b1 = new JButton("Deposit");
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(b1, gbc);
        gbc.gridx = 1;
        b2 = new JButton("Back");
        b2.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(b2, gbc);
        add(panel, BorderLayout.CENTER);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String amount = t1.getText();
            if(amount.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter the amount to deposit.");
                return;
            }
            // Simulate note features (in real app, collect from hardware or image)
            Map<String, Object> noteFeatures = new HashMap<>();
            noteFeatures.put("amount", amount);
            noteFeatures.put("currency", "INR");
            // Add more features as needed
            try {
                boolean success = DepositService.deposit(pin, amount, new Date(), noteFeatures);
                if(success){
                    JOptionPane.showMessageDialog(this, "Rs. " + amount + " deposited successfully and verified as genuine.");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Deposit failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if(ae.getSource() == b2){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String[] args){
        new Deposit("");
    }
}