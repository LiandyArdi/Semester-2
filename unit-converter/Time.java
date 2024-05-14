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
                value = Float.parseFloat(String.valueOf(timefromtext.getText()));
                if (timefromunit.getSelectedIndex() == 0) { //if the fromunitcombo 1st entry is selected by the user, then
                	if (timetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value));
                    }
                	
                	if (timetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value * 7));
                    }

                    if (timetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value * 7 * 24)); //* is used for multiplication.
                    }

                    if (timetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value * 7 * 24 * 60)); //* is used for multiplication.
                    }
                    
                    if (timetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value * 7 * 24 * 60 * 60)); //* is used for multiplication.
                    }

                }
                if (timefromunit.getSelectedIndex() == 1) { //if the fromunitcombo 1st entry is selected by the user, then
                	if (timetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value / 7));
                    }
                	
                	if (timetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value));
                    }

                    if (timetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value * 24)); //* is used for multiplication.
                    }

                    if (timetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value * 24 * 60)); //* is used for multiplication.
                    }
                    
                    if (timetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value * 24 * 60 * 60)); //* is used for multiplication.
                    }

                }
                if (timefromunit.getSelectedIndex() == 2) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (timetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value /24 /7));
                    }

                    if (timetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value /24)); //* is used for multiplication.
                    }

                    if (timetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    if (timetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value * 60)); //* is used for multiplication.
                    }
                    if (timetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value * 60 * 60)); //* is used for multiplication.
                    }

                }

                if (timefromunit.getSelectedIndex() == 3) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (timetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value /60 /24 /7));
                    }

                    if (timetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value /60 /24)); //* is used for multiplication.
                    }

                    if (timetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value /60)); //* is used for multiplication.
                    }
                    
                    if (timetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (timetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value * 60)); //* is used for multiplication.
                    }

                }
                
                if (timefromunit.getSelectedIndex() == 4) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (timetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value /60 /60 /24 /7));
                    }

                    if (timetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value /60 /60 /24)); //* is used for multiplication.
                    }

                    if (timetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value /60 /60)); //* is used for multiplication.
                    }
                    
                    if (timetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value /60)); //* is used for multiplication.
                    }
                    
                    if (timetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        timetotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }

                }
            }
        }); // This closing brace was missing. It closes the ActionListener.
    } // This closing brace was missing. It closes the Time constructor.
} // This closing brace was missing. It closes the Time class.
