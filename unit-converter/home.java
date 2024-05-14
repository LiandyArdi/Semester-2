package com.pemrogramanlanjut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    public JFrame mainframe;
    public JButton length, mass, volume, time, morse, tap, temp, debihex;

    public static void main(String[] args) {
        new Home();
    }

    public Home() {
        mainframe = new JFrame("Unit Converter Pro");
        mainframe.setLayout(new GridLayout(4,2));	
        mainframe.setSize(500,500);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);

        length = new JButton("Length Converter");
        mass = new JButton("Mass Converter");
        volume = new JButton("Volume Converter");
        time = new JButton("Time Converter");
        morse = new JButton("Morse Code Converter");
        tap = new JButton("Tap Code Converter");
        temp = new JButton("Temperature Converter");
        debihex = new JButton("Decimal Binary Hexa Converter");

        mainframe.add(length);
        mainframe.add(mass);
        mainframe.add(volume);
        mainframe.add(time);
        mainframe.add(morse);
        mainframe.add(tap);
        mainframe.add(temp);
        mainframe.add(debihex);

        length.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Length length = new Length();
                length.setSize(500, 200);
                length.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                length.setVisible(true);
                length.setTitle("Length Converter");
            }
        });

        mass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mass mass = new Mass();
                mass.setSize(500, 200);
                mass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mass.setVisible(true);
                mass.setTitle("Mass Converter");
            }
        });

        volume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Volume volume = new Volume();
                volume.setSize(500, 200);
                volume.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                volume.setVisible(true);
                volume.setTitle("Volume Converter");
            }
        });

        time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Time time = new Time();
                time.setSize(500, 200);
                time.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                time.setVisible(true);
                time.setTitle("Time Converter");
            }
        });
        
        morse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Morse morse = new Morse();
                morse.setSize(500, 200);
                morse.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                morse.setVisible(true);
                morse.setTitle("Morse Code Converter");
            }
        });
        
        tap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tap tap = new Tap();
                tap.setSize(500, 200);
                tap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                tap.setVisible(true);
                tap.setTitle("Tap Code Converter");
            }
        });
        
        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Temp temp = new Temp();
                temp.setSize(500, 200);
                temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                temp.setVisible(true);
                temp.setTitle("Temperature Converter");
            }
        });
        
        debihex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Debihex debihex = new Debihex();
            	debihex.setSize(500, 200);
            	debihex.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	debihex.setVisible(true);
            	debihex.setTitle("Decimal Binary Hexa Converter");
            }
        });

        mainframe.pack();
    }
}
