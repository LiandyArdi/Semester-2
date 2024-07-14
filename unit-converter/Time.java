package com.pemrogramanlanjut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Time extends JFrame {
    String[] units = {"Week (w.)", "Days (d.)", "Hours (hr.)", "Minutes (min.)", "Seconds (sec.)"};

    Container timemaincontainer, fromcontainer, tocontainer, calculatecontainer;
    JTextField timefromtext, timetotext;
    JComboBox timefromunit, timetounit;
    JButton timecalculate, timeexit, timeclear;

    float value;

    public Time() {

        timemaincontainer = new Container();
        setContentPane(timemaincontainer);
        timemaincontainer.setLayout(new BoxLayout(timemaincontainer, BoxLayout.Y_AXIS));

        fromcontainer = new Container();
        fromcontainer.setLayout(new GridLayout(1,2)); //1 value column, 1 unit column = 2 columns

        tocontainer = new Container();
        tocontainer.setLayout(new GridLayout(1,2)); //1 value column, 1 unit column = 2 columns

        calculatecontainer = new Container();
        calculatecontainer.setLayout(new GridLayout(3,1)); //1 row calculate btn, 1 row clear btn, 1 row exit btn = 3 rows

        timemaincontainer.add(fromcontainer);
        timemaincontainer.add(tocontainer);
        timemaincontainer.add(calculatecontainer);

        timefromtext = new JTextField();
        timetotext   = new JTextField();

        timefromunit = new JComboBox(units); //Initializing fromcombo and adding the array units.
        timetounit = new JComboBox(units); //Initializing tocombo and adding the array units.

        timefromtext.setEditable(true);
        timetotext.setEditable(false);

        timetotext.setBackground(Color.WHITE);

        timecalculate = new JButton("Calculate Result");
        timeclear     = new JButton("Clear");
        timeexit      = new JButton("Exit");

        fromcontainer.add(timefromtext);
        fromcontainer.add(timefromunit);

        tocontainer.add(timetotext);
        tocontainer.add(timetounit);

        calculatecontainer.add(timecalculate);
        calculatecontainer.add(timeclear);
        calculatecontainer.add(timeexit);

        timeclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timefromtext.setText(null);
                timetotext.setText(null);
                timefromunit.setSelectedIndex(0); //set the combobox to the 1st entry i.e. kilometres
                timetounit.setSelectedIndex(0); //set the combobox to the 1st entry i.e. kilometres
            }
        });

        timeexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        timecalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    value = Float.parseFloat(timefromtext.getText());
                    int fromIndex = timefromunit.getSelectedIndex();
                    int toIndex = timetounit.getSelectedIndex();

                    // Faktor konversi (mengikuti urutan units yang ada)
                    float[] conversionFactors = {1, 1/7f, 1/168f, 1/10080f, 1/604800f};
                    
                    // Kalkulasi
                    float result = value * conversionFactors[fromIndex] / conversionFactors[toIndex];
                    timetotext.setText(String.valueOf(result));      
            }
        });
    } 
} 
