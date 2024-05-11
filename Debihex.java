package com.pemrogramanlanjut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Debihex extends JFrame {

    String[] units = {"Decimal", "Binary", "Hexadecimal"};
    String[] separators = {" ", ".", ":"}; // Additional separators to handle various formats

    Container mainContainer, fromContainer, toContainer, calculateContainer;
    JTextField fromText, toText;
    JComboBox<String> fromUnit, toUnit;
    JButton calculateBtn, clearBtn, exitBtn;

    public Debihex() {

        mainContainer = new Container();
        setContentPane(mainContainer);
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));

        fromContainer = new Container();
        fromContainer.setLayout(new GridLayout(1, 2));

        toContainer = new Container();
        toContainer.setLayout(new GridLayout(1, 2));

        calculateContainer = new Container();
        calculateContainer.setLayout(new GridLayout(3, 1));

        mainContainer.add(fromContainer);
        mainContainer.add(toContainer);
        mainContainer.add(calculateContainer);

        fromText = new JTextField();
        toText = new JTextField();

        // Check if units array is empty before setting up JComboBox
        fromUnit = new JComboBox<String>(units.length > 0 ? units : new String[]{"Decimal"});
        toUnit = new JComboBox<String>(units.length > 0 ? units : new String[]{"Decimal"});

        fromText.setEditable(true);
        toText.setEditable(false);

        toText.setBackground(Color.WHITE);

        calculateBtn = new JButton("Convert");
        clearBtn = new JButton("Clear");
        exitBtn = new JButton("Exit");

        fromContainer.add(fromText);
        fromContainer.add(fromUnit);

        toContainer.add(toText);
        toContainer.add(toUnit);

        calculateContainer.add(calculateBtn);
        calculateContainer.add(clearBtn);
        calculateContainer.add(exitBtn);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fromText.setText("");
                toText.setText("");
                fromUnit.setSelectedIndex(0);
                toUnit.setSelectedIndex(0);
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = fromText.getText().trim();
                String answer = "";

                int fromIndex = fromUnit.getSelectedIndex();
                int toIndex = toUnit.getSelectedIndex();

                // Check if input is binary, decimal, or hexadecimal
                if (fromIndex == 1) {
                    // Binary input
                    String[] binaryOctets = value.split("\\.");
                    StringBuilder decimalIP = new StringBuilder();
                    for (String octet : binaryOctets) {
                        try {
                            int decimal = Integer.parseInt(octet, 2);
                            decimalIP.append(decimal).append(".");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid input format for binary IP.");
                            return;
                        }
                    }
                    // Remove the last dot
                    value = decimalIP.substring(0, decimalIP.length() - 1);
                } else if (fromIndex == 2) {
                    // Hexadecimal input
                    try {
                        long decimal = Long.parseLong(value, 16);
                        value = String.valueOf(decimal);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input format for hexadecimal.");
                        return;
                    }
                }

                // Convert to decimal, binary, or hexadecimal
                switch (toIndex) {
                    case 0: // Decimal
                        answer = value;
                        break;
                    case 1: // Binary
                        // Convert each octet separately
                        String[] octets = value.split("\\.");
                        StringBuilder binaryIP = new StringBuilder();
                        for (String octet : octets) {
                            try {
                                int decimal = Integer.parseInt(octet);
                                String binary = Integer.toBinaryString(decimal);
                                // Append leading zeros if necessary
                                while (binary.length() < 8) {
                                    binary = "0" + binary;
                                }
                                binaryIP.append(binary).append(".");
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Invalid input format for decimal IP.");
                                return;
                            }
                        }
                        // Remove the last dot
                        answer = binaryIP.substring(0, binaryIP.length() - 1);
                        break;
                    case 2: // Hexadecimal
                        // Convert each octet separately
                        String[] hexOctets = value.split("\\.");
                        StringBuilder hexIP = new StringBuilder();
                        for (String octet : hexOctets) {
                            try {
                                int decimal = Integer.parseInt(octet);
                                String hex = Integer.toHexString(decimal).toUpperCase();
                                hexIP.append(hex).append(".");
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Invalid input format for decimal IP.");
                                return;
                            }
                        }
                        // Remove the last dot
                        answer = hexIP.substring(0, hexIP.length() - 1);
                        break;
                }

                toText.setText(answer);
            }
        });

    }
}