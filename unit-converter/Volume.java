package com.pemrogramanlanjut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Volume extends JFrame {

    String[] units = {"Kiloliter (kl.)", "Hectoliter (hl.)", 
    		"Dekaliter (dal.)", "liter (l.)", "Deciliter (dl.)", "Centiliter (cl.)", "Mililiter (ml.)"};

    Container volumemaincontainer, fromcontainer, tocontainer, calculatecontainer;
    JTextField volumefromtext, volumetotext;
    JComboBox volumefromunit, volumetounit;
    JButton volumecalculate, volumeexit, volumeclear;

    float value;

    public Volume() {

        volumemaincontainer = new Container();
        setContentPane(volumemaincontainer);
        volumemaincontainer.setLayout(new BoxLayout(volumemaincontainer, BoxLayout.Y_AXIS));

        fromcontainer = new Container();
        fromcontainer.setLayout(new GridLayout(1,2)); //1 value column, 1 unit column = 2 columns

        tocontainer = new Container();
        tocontainer.setLayout(new GridLayout(1,2)); //1 value column, 1 unit column = 2 columns

        calculatecontainer = new Container();
        calculatecontainer.setLayout(new GridLayout(3,1)); //1 row calculate btn, 1 row clear btn, 1 row exit btn = 3 rows

        volumemaincontainer.add(fromcontainer);
        volumemaincontainer.add(tocontainer);
        volumemaincontainer.add(calculatecontainer);

        volumefromtext = new JTextField();
        volumetotext   = new JTextField();

        volumefromunit = new JComboBox(units); //Initializing fromcombo and adding the array units.
        volumetounit = new JComboBox(units); //Initializing tocombo and adding the array units.

        volumefromtext.setEditable(true);
        volumetotext.setEditable(false);

        volumetotext.setBackground(Color.WHITE);

        volumecalculate = new JButton("Calculate Result");
        volumeclear     = new JButton("Clear");
        volumeexit      = new JButton("Exit");

        fromcontainer.add(volumefromtext);
        fromcontainer.add(volumefromunit);

        tocontainer.add(volumetotext);
        tocontainer.add(volumetounit);

        calculatecontainer.add(volumecalculate);
        calculatecontainer.add(volumeclear);
        calculatecontainer.add(volumeexit);

        volumeclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volumefromtext.setText(null);
                volumetotext.setText(null);
                volumefromunit.setSelectedIndex(0); //set the combobox to the 1st entry i.e. kilometres
                volumetounit.setSelectedIndex(0); //set the combobox to the 1st entry i.e. kilometres
            }
        });

        volumeexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        volumecalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Float.parseFloat(volumefromtext.getText());
                int fromIndex = volumefromunit.getSelectedIndex();
                int toIndex = volumetounit.getSelectedIndex();

                // Faktor konversi
                float[] conversionFactors = {1, 10, 100, 1000, 10_000, 100_000, 1_000_000};

                // Kalkulasi
                float result = value * conversionFactors[toIndex] / conversionFactors[fromIndex];
                volumetotext.setText(String.valueOf(result));
            }
        });
    }
}
