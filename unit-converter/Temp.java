package com.pemrogramanlanjut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temp extends JFrame {

    String[] units = {"Celcius (°C)", "Reamur (°R)", "Fahrenheit (°F)", "Kelvin (K)"};

    Container tempermaincontainer, fromcontainer, tocontainer, calculatecontainer;
    JTextField temperfromtext, tempertotext;
    JComboBox temperfromunit, tempertounit;
    JButton tempercalculate, temperexit, temperclear;

    float value;

    public Temp() {
        tempermaincontainer = new Container();
        setContentPane(tempermaincontainer);
        tempermaincontainer.setLayout(new BoxLayout(tempermaincontainer, BoxLayout.Y_AXIS));

        fromcontainer = new Container();
        fromcontainer.setLayout(new GridLayout(1, 2)); // 1 value column, 1 unit column = 2 columns

        tocontainer = new Container();
        tocontainer.setLayout(new GridLayout(1, 2)); // 1 value column, 1 unit column = 2 columns

        calculatecontainer = new Container();
        calculatecontainer.setLayout(new GridLayout(3, 1)); // 1 row calculate btn, 1 row clear btn, 1 row exit btn = 3 rows

        tempermaincontainer.add(fromcontainer);
        tempermaincontainer.add(tocontainer);
        tempermaincontainer.add(calculatecontainer);

        temperfromtext = new JTextField();
        tempertotext = new JTextField();

        temperfromunit = new JComboBox(units); // Initializing fromcombo and adding the array units.
        tempertounit = new JComboBox(units); // Initializing tocombo and adding the array units.

        temperfromtext.setEditable(true);
        tempertotext.setEditable(false);

        tempertotext.setBackground(Color.WHITE);

        tempercalculate = new JButton("Calculate Result");
        temperclear = new JButton("Clear");
        temperexit = new JButton("Exit");

        fromcontainer.add(temperfromtext);
        fromcontainer.add(temperfromunit);

        tocontainer.add(tempertotext);
        tocontainer.add(tempertounit);

        calculatecontainer.add(tempercalculate);
        calculatecontainer.add(temperclear);
        calculatecontainer.add(temperexit);

        temperclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temperfromtext.setText(null);
                tempertotext.setText(null);
                temperfromunit.setSelectedIndex(0); // set the combobox to the 1st entry i.e. Celsius
                tempertounit.setSelectedIndex(0); // set the combobox to the 1st entry i.e. Celsius
            }
        });

        temperexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        tempercalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Float.parseFloat(String.valueOf(temperfromtext.getText()));
                if (temperfromunit.getSelectedIndex() == 0) { // if the fromunitcombo 1st entry is selected by the user, then
                    if (tempertounit.getSelectedIndex() == 0) {
                        tempertotext.setText(String.valueOf(value)); // Celsius to Celsius
                    } else if (tempertounit.getSelectedIndex() == 1) {
                        tempertotext.setText(String.valueOf((4 / 5f) * value)); // Celsius to Reamur
                    } else if (tempertounit.getSelectedIndex() == 2) {
                        tempertotext.setText(String.valueOf((9 / 5f * value) + 32)); // Celsius to Fahrenheit
                    } else if (tempertounit.getSelectedIndex() == 3) {
                        tempertotext.setText(String.valueOf(value + 273.15)); // Celsius to Kelvin
                    }
                } else if (temperfromunit.getSelectedIndex() == 1) { // if the fromunitcombo 2nd entry is selected by the user, then
                    if (tempertounit.getSelectedIndex() == 0) {
                        tempertotext.setText(String.valueOf((5 / 4f) * value)); // Reamur to Celsius
                    } else if (tempertounit.getSelectedIndex() == 1) {
                        tempertotext.setText(String.valueOf(value)); // Reamur to Reamur
                    } else if (tempertounit.getSelectedIndex() == 2) {
                        tempertotext.setText(String.valueOf((9 / 4f * value) + 32)); // Reamur to Fahrenheit
                    } else if (tempertounit.getSelectedIndex() == 3) {
                        tempertotext.setText(String.valueOf(((5 / 4f * value) + 273.15))); // Reamur to Kelvin
                    }
                } else if (temperfromunit.getSelectedIndex() == 2) { // if the fromunitcombo 3rd entry is selected by the user, then
                    if (tempertounit.getSelectedIndex() == 0) {
                        tempertotext.setText(String.valueOf((5 / 9f * (value - 32)))); // Fahrenheit to Celsius
                    } else if (tempertounit.getSelectedIndex() == 1) {
                        tempertotext.setText(String.valueOf((4 / 9f * (value - 32)))); // Fahrenheit to Reamur
                    } else if (tempertounit.getSelectedIndex() == 2) {
                        tempertotext.setText(String.valueOf(value)); // Fahrenheit to Fahrenheit
                    } else if (tempertounit.getSelectedIndex() == 3) {
                        tempertotext.setText(String.valueOf((5 / 9f * (value - 32) + 273.15))); // Fahrenheit to Kelvin
                    }
                } else if (temperfromunit.getSelectedIndex() == 3) { // if the fromunitcombo 4th entry is selected by the user, then
                    if (tempertounit.getSelectedIndex() == 0) {
                        tempertotext.setText(String.valueOf(value - 273.15)); // Kelvin to Celsius
                    } else if (tempertounit.getSelectedIndex() == 1) {
                        tempertotext.setText(String.valueOf(((4 / 5f) * (value - 273.15)))); // Kelvin to Reamur
                    } else if (tempertounit.getSelectedIndex() == 2) {
                        tempertotext.setText(String.valueOf(((9 / 5f) * (value - 273.15) + 32))); // Kelvin to Fahrenheit
                    } else if (tempertounit.getSelectedIndex() == 3) {
                        tempertotext.setText(String.valueOf(value)); // Kelvin to Kelvin
                    }
                }
            }
        });

    }

}
