package com.pemrogramanlanjut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mass extends JFrame {

    String[] units = {"Kilogram (kg.)", "Hectogram (hg.)", 
    		"Dekagram (dag.)", "Gram (g.)", "Decigram (dg.)", "Centigram (cg.)", "Miligram (mg.)"};

    Container massmaincontainer, fromcontainer, tocontainer, calculatecontainer;
    JTextField massfromtext, masstotext;
    JComboBox massfromunit, masstounit;
    JButton masscalculate, massexit, massclear;

    float value;
    
    public Mass() {

        massmaincontainer = new Container();
        setContentPane(massmaincontainer);
        massmaincontainer.setLayout(new BoxLayout(massmaincontainer, BoxLayout.Y_AXIS));

        fromcontainer = new Container();
        fromcontainer.setLayout(new GridLayout(1,2)); //1 value column, 1 unit column = 2 columns

        tocontainer = new Container();
        tocontainer.setLayout(new GridLayout(1,2)); //1 value column, 1 unit column = 2 columns

        calculatecontainer = new Container();
        calculatecontainer.setLayout(new GridLayout(3,1)); //1 row calculate btn, 1 row clear btn, 1 row exit btn = 3 rows

        massmaincontainer.add(fromcontainer);
        massmaincontainer.add(tocontainer);
        massmaincontainer.add(calculatecontainer);

        massfromtext = new JTextField();
        masstotext   = new JTextField();

        massfromunit = new JComboBox(units); //Initializing fromcombo and adding the array units.
        masstounit = new JComboBox(units); //Initializing tocombo and adding the array units.

        massfromtext.setEditable(true);
        masstotext.setEditable(false);

        masstotext.setBackground(Color.WHITE);

        masscalculate = new JButton("Calculate Result");
        massclear     = new JButton("Clear");
        massexit      = new JButton("Exit");

        fromcontainer.add(massfromtext);
        fromcontainer.add(massfromunit);

        tocontainer.add(masstotext);
        tocontainer.add(masstounit);

        calculatecontainer.add(masscalculate);
        calculatecontainer.add(massclear);
        calculatecontainer.add(massexit);

        massclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                massfromtext.setText(null);
                masstotext.setText(null);
                massfromunit.setSelectedIndex(0); //set the combobox to the 1st entry i.e. kilometres
                masstounit.setSelectedIndex(0); //set the combobox to the 1st entry i.e. kilometres
            }
        });

        massexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        masscalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Float.parseFloat(massfromtext.getText());
                int fromIndex = massfromunit.getSelectedIndex();
                int toIndex = masstounit.getSelectedIndex();

                // Faktor konversi 
                float[] conversionFactors = {1, 10, 100, 1000, 10_000, 100_000, 1_000_000};

                // Kalkulasi
                float result = value * conversionFactors[toIndex] / conversionFactors[fromIndex];
                masstotext.setText(String.valueOf(result));
            }
        });
    }
}
