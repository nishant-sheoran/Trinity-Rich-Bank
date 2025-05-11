package ASimulatorSystem.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FastCashUI extends JFrame implements ActionListener {
    private JButton[] btnAmounts;
    private JButton btnBack;
    private String pin;
    public FastCashUI(String pin) {
        this.pin = pin;
        setTitle("CashSentinel - Fast Cash");
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(2, 4, 10, 10));
        panel.setBackground(Color.WHITE);
        int[] amounts = {100, 500, 1000, 2000, 5000, 10000};
        btnAmounts = new JButton[amounts.length];
        for (int i = 0; i < amounts.length; i++) {
            btnAmounts[i] = new JButton("Rs. " + amounts[i]);
            btnAmounts[i].addActionListener(this);
            panel.add(btnAmounts[i]);
        }
        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        panel.add(btnBack);
        add(panel, BorderLayout.CENTER);
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton btn : btnAmounts) {
            if (e.getSource() == btn) {
                // Fast cash logic
                return;
            }
        }
        if (e.getSource() == btnBack) {
            setVisible(false);
            new TransactionsUI(pin).setVisible(true);
        }
    }
} 