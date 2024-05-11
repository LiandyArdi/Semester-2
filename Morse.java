package com.pemrogramanlanjut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Morse extends JFrame {

    String[] units = {"Text", "Morse"};

    char[] english = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ',', '.', '?'};

    String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.."};

    Container mainContainer, fromContainer, toContainer, calculateContainer;
    JTextField fromText, toText;
    JComboBox<String> fromUnit, toUnit;
    JButton calculateBtn, clearBtn, exitBtn;

    public Morse() {

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

        fromUnit = new JComboBox<String>(units);
        toUnit = new JComboBox<String>(units);

        fromText.setEditable(true);
        toText.setEditable(false);

        toText.setBackground(Color.WHITE);

        calculateBtn = new JButton("Calculate Result");
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
                String value = fromText.getText().toLowerCase();
                String answer = "";
                String answer1 = "";

                if (fromUnit.getSelectedIndex() == 0) {
                    if (toUnit.getSelectedIndex() == 1) {
                        // Convert text to Morse code
                        for (int i = 0; i < value.length(); i++) {
                            char letter = value.charAt(i);
                            if (letter == ' ') {
                                answer += "/";
                            } else {
                                for (int j = 0; j < english.length; j++) {
                                    if (english[j] == letter) {
                                        answer += morse[j] + " ";
                                        break;
                                    }
                                }
                            }
                        }
                        toText.setText(answer.trim());
                    } else {
                        // Handle invalid conversion
                        JOptionPane.showMessageDialog(null, "Invalid conversion");
                    }
                } else if (fromUnit.getSelectedIndex() == 1) {
                    if (toUnit.getSelectedIndex() == 0) {
                        // Convert Morse code to text
                        String[] words = value.split("/");
                        for (String word : words) {
                            String[] letters = word.split(" ");
                            for (String letter : letters) {
                                for (int j = 0; j < morse.length; j++) {
                                    if (morse[j].equals(letter)) {
                                        answer1 += english[j];
                                        break;
                                    }
                                }
                            }
                            answer1 += " ";
                        }
                        toText.setText(answer1);
                    } 
                }
            }
        });
    }
}

