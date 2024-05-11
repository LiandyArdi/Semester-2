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
                value = Float.parseFloat(String.valueOf(massfromtext.getText()));
                if (massfromunit.getSelectedIndex() == 0) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (masstounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value));
                    }

                    if (masstounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }

                    if (masstounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 10000)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 100000)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 1000000)); //* is used for multiplication.
                    }

                }
                
                if (massfromunit.getSelectedIndex() == 1) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (masstounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /10));
                    }

                    if (masstounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }

                    if (masstounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 10000)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 100000)); //* is used for multiplication.
                    }

                }
                
                if (massfromunit.getSelectedIndex() == 2) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (masstounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /100));
                    }

                    if (masstounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }

                    if (masstounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 10000)); //* is used for multiplication.
                    }

                }
                
                if (massfromunit.getSelectedIndex() == 3) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (masstounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /1000));
                    }

                    if (masstounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }

                    if (masstounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 1000)); //* is used for multiplication.
                    }

                }
                
                if (massfromunit.getSelectedIndex() == 4) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (masstounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /10000));
                    }

                    if (masstounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /1000)); //* is used for multiplication.
                    }

                    if (masstounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 100)); //* is used for multiplication.
                    }

                }
                
                if (massfromunit.getSelectedIndex() == 5) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (masstounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /100000));
                    }

                    if (masstounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /10000)); //* is used for multiplication.
                    }

                    if (masstounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /1000)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value * 10)); //* is used for multiplication.
                    }

                }
                
                if (massfromunit.getSelectedIndex() == 6) { //if the fromunitcombo 1st entry is selected by the user, then
                    if (masstounit.getSelectedIndex() == 0) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /1000000));
                    }

                    if (masstounit.getSelectedIndex() == 1) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /100000)); //* is used for multiplication.
                    }

                    if (masstounit.getSelectedIndex() == 2) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /10000)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 3) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /1000)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 4) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /100)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 5) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value /10)); //* is used for multiplication.
                    }
                    
                    if (masstounit.getSelectedIndex() == 6) { //since there are two combo boxes in which the user will chose units, inside the 1st if, we are going to add 3 more if's whose conditions would be the selected entries of the second combobox. So the condition is if along with the from combobox 1st entry is chosen and in to combo box 1st entry is chosen then.
                        masstotext.setText(String.valueOf(value)); //* is used for multiplication.
                    }

                }


            }
        });
        
    }
}























