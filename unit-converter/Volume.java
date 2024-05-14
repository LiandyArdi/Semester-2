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
                value = Float.parseFloat(String.valueOf(volumefromtext.getText()));
                if (volumefromunit.getSelectedIndex() == 0) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (volumetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value));
                    }

                    if (volumetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }

                    if (volumetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 10000)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 100000)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 1000000)); //* is used for multiplication.
                    }

                }
                
                if (volumefromunit.getSelectedIndex() == 1) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (volumetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /10));
                    }

                    if (volumetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }

                    if (volumetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 10000)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 100000)); //* is used for multiplication.
                    }

                }
                
                if (volumefromunit.getSelectedIndex() == 2) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (volumetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /100));
                    }

                    if (volumetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }

                    if (volumetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 10000)); //* is used for multiplication.
                    }

                }
                
                if (volumefromunit.getSelectedIndex() == 3) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (volumetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /1000));
                    }

                    if (volumetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }

                    if (volumetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }

                }
                
                if (volumefromunit.getSelectedIndex() == 4) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (volumetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /10000));
                    }

                    if (volumetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /1000)); //* is used for multiplication.
                    }

                    if (volumetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }

                }
                
                if (volumefromunit.getSelectedIndex() == 5) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (volumetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /100000));
                    }

                    if (volumetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /10000)); //* is used for multiplication.
                    }

                    if (volumetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /1000)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }

                }
                
                if (volumefromunit.getSelectedIndex() == 6) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (volumetounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /1000000));
                    }

                    if (volumetounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /100000)); //* is used for multiplication.
                    }

                    if (volumetounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /10000)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /1000)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (volumetounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        volumetotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }

                }


            }
        });

    }
    
}




















