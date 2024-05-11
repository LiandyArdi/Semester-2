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
        tocontainer.setLayout(new GridLayout(1,2)); //1 value column, 1 unit column = 2 columns

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
                value = Float.parseFloat(String.valueOf(lengthfromtext.getText()));
                if (lengthfromunit.getSelectedIndex() == 0) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (lengthtounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value));
                    }

                    if (lengthtounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }

                    if (lengthtounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 10000)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 100000)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 1000000)); //* is used for multiplication.
                    }

                }
                
                if (lengthfromunit.getSelectedIndex() == 1) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (lengthtounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /10));
                    }

                    if (lengthtounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }

                    if (lengthtounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 10000)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 100000)); //* is used for multiplication.
                    }

                }
                
                if (lengthfromunit.getSelectedIndex() == 2) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (lengthtounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /100));
                    }

                    if (lengthtounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }

                    if (lengthtounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 10000)); //* is used for multiplication.
                    }

                }
                
                if (lengthfromunit.getSelectedIndex() == 3) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (lengthtounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /1000));
                    }

                    if (lengthtounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }

                    if (lengthtounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }

                }
                
                if (lengthfromunit.getSelectedIndex() == 4) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (lengthtounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /10000));
                    }

                    if (lengthtounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /1000)); //* is used for multiplication.
                    }

                    if (lengthtounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }

                }
                
                if (lengthfromunit.getSelectedIndex() == 5) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (lengthtounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /100000));
                    }

                    if (lengthtounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /10000)); //* is used for multiplication.
                    }

                    if (lengthtounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /1000)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }

                }
                
                if (lengthfromunit.getSelectedIndex() == 6) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (lengthtounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /1000000));
                    }

                    if (lengthtounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /100000)); //* is used for multiplication.
                    }

                    if (lengthtounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /10000)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /1000)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (lengthtounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        lengthtotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }

                }


            }
        });

    }

}
