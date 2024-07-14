package com.pemrogramanlanjut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Length extends JFrame {

    String[] units = {"Kilometer (km.)", "Hectometer (hm.)", 
    		"Dekameter (dam.)", "Meter (m.)", "Decimeter (dm.)", "Centimeter (cm.)", "Milimeter (mm.)"};

    Container lengthmaincontainer, fromcontainer, tocontainer, calculatecontainer;
    JTextField lengthfromtext, lengthtotext;
    JComboBox lengthfromunit, lengthtounit;
    JButton lengthcalculate, lengthexit, lengthclear;

    float value;

    public Length () {
        lengthmaincontainer = new Container();
        setContentPane(lengthmaincontainer);
        lengthmaincontainer.setLayout(new BoxLayout(lengthmaincontainer, BoxLayout.Y_AXIS));

        fromcontainer = new Container();
        fromcontainer.setLayout(new GridLayout(1,2)); //1 value column, 1 unit column = 2 columns

        tocontainer = new Container();
        tocontainer.setLayout(new GridLayout(1,2)); //1 value/result column, 1 unit column = 2 columns

        calculatecontainer = new Container();
        calculatecontainer.setLayout(new GridLayout(3,1)); //1 row calculate btn, 1 row clear btn, 1 row exit btn = 3 rows

        lengthmaincontainer.add(fromcontainer);
        lengthmaincontainer.add(tocontainer);
        lengthmaincontainer.add(calculatecontainer);

        lengthfromtext = new JTextField();
        lengthtotext   = new JTextField();

        lengthfromunit = new JComboBox(units); //Initializing fromcombo and adding the array units.
        lengthtounit = new JComboBox(units); //Initializing tocombo and adding the array units.

        lengthfromtext.setEditable(true);
        lengthtotext.setEditable(false);

        lengthtotext.setBackground(Color.WHITE);

        lengthcalculate = new JButton("Calculate Result");
        lengthclear     = new JButton("Clear");
        lengthexit      = new JButton("Exit");

        fromcontainer.add(lengthfromtext);
        fromcontainer.add(lengthfromunit);

        tocontainer.add(lengthtotext);
        tocontainer.add(lengthtounit);

        calculatecontainer.add(lengthcalculate);
        calculatecontainer.add(lengthclear);
        calculatecontainer.add(lengthexit);

        lengthclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lengthfromtext.setText(null);
                lengthtotext.setText(null);
                lengthfromunit.setSelectedIndex(0); //set the combobox to the 1st entry i.e. kilometres
                lengthtounit.setSelectedIndex(0); //set the combobox to the 1st entry i.e. kilometres
            }
        });

        lengthexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        lengthcalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Float.parseFloat(lengthfromtext.getText());
                int fromIndex = lengthfromunit.getSelectedIndex();
                int toIndex = lengthtounit.getSelectedIndex();

                // Faktor Konversi
                float[] conversionFactors = {1, 10, 100, 1000, 10_000, 100_000, 1_000_000};

                // Kalkulasi
                float result = value * conversionFactors[toIndex] / conversionFactors[fromIndex];
                lengthtotext.setText(String.valueOf(result));
            } 		
        });
    }
}
