package Lottery;

import java.awt.*;
import javax.swing.*;

public class LottoMadness extends JFrame {
    LottoEvent lotto = new LottoEvent(this);
    
    //set up row 1
    JPanel row1 = new JPanel();
    ButtonGroup option = new ButtonGroup();
    JCheckBox quickpick = new JCheckBox("Quick Pick", false);
    JCheckBox personal = new JCheckBox("Personal", true);
    //set up row 2
    JPanel row2 = new JPanel();
    JLabel numbersLabel = new JLabel("Your Picks: ", JLabel.RIGHT);
    JTextField[] numbers = new JTextField[5];
    JLabel place = new JLabel("Power Pick: ", JLabel.RIGHT);
    JLabel winnersLabel = new JLabel("Drawn Numbers: ", JLabel.RIGHT);
    JTextField[] winner = new JTextField[5];
    JLabel place2 = new JLabel("Power Number", JLabel.RIGHT);
    JTextField powernum = new JTextField(null);
    JTextField powerchoice = new JTextField(null);
    
    //set up row 3
    JPanel row3 = new JPanel();
    JButton stop = new JButton("Stop");
    JButton play = new JButton("Play");
    JButton reset = new JButton("Reset");
    //set up row 4
    JPanel row4 = new JPanel();
    JLabel got3Label = new JLabel("3 of 5: ", JLabel.RIGHT);
    JTextField got3 = new JTextField("0");
    JLabel got4Label = new JLabel("4 of 5: ", JLabel.RIGHT);
    JTextField got5 = new JTextField("0");
    JLabel got5Label = new JLabel("5 of 5: ", JLabel.RIGHT);
    JTextField got4 = new JTextField("0");
    JLabel got3PLabel = new JLabel("3 of 5 + PB: ", JLabel.RIGHT);
    JTextField got3P = new JTextField("0");
    JLabel got4PLabel = new JLabel("4 of 5 + PB: ", JLabel.RIGHT);
    JTextField got5P = new JTextField("0");
    JLabel got5PLabel = new JLabel("5 of 5 + PB: ", JLabel.RIGHT);
    JTextField got4P = new JTextField("0");
    
    
    //set up row 5 / power
    JPanel row5 = new JPanel();
    JLabel powerLabel = new JLabel("Power: ", JLabel.RIGHT);
    JTextField power = new JTextField("0");
    JLabel jackpotLabel = new JLabel("Jackpot: ", JLabel.RIGHT);
    JTextField jackpot = new JTextField("0");
    
    //set up draw/year
    JPanel draws = new JPanel();
    JLabel drawingLabel = new JLabel("Drawings: ", JLabel.RIGHT);
    JTextField drawings = new JTextField("0");
    JLabel yearsLabel = new JLabel("Years: ", JLabel.RIGHT);
    JLabel place3 = new JLabel("        ", JLabel.RIGHT);
    JTextField years = new JTextField();      
    
    public LottoMadness() {
        super("LottoMadness");
        
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(5, 1, 10, 10);
        setLayout(layout);
        
        //AddListeners
        quickpick.addItemListener(lotto);
        personal.addItemListener(lotto);
        stop.addActionListener(lotto);
        play.addActionListener(lotto);
        reset.addActionListener(lotto);
        
        FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER,
                10, 10
        );
        option.add(quickpick);
        option.add(personal);
        row1.setLayout(layout1);
        row1.add(quickpick);
        row1.add(personal);
        add(row1);
        
        FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER);
        row3.setLayout(layout3);
        stop.setEnabled(false);
        row3.add(stop);
        row3.add(play);
        row3.add(reset);
        row3.add(drawingLabel);
        drawings.setEditable(false);
        row3.add(drawings);
        row3.add(yearsLabel);
        years.setEditable(false);
        row3.add(years);
        add(row3);
        
        
        
        GridLayout layout2 = new GridLayout(2, 8, 10, 10);
        row2.setLayout(layout2);
        row2.add(numbersLabel);
        for(int i = 0; i < 5; i++) {
            numbers[i] = new JTextField();
            row2.add(numbers[i]);
        }
        row2.add(place);
        row2.add(powerchoice);
        row2.add(winnersLabel);
        for(int i = 0; i < 5; i++) {
            winner[i] = new JTextField();
            winner[i].setEditable(false);
            row2.add(winner[i]);
        }
        row2.add(place2);
        powernum.setEditable(false);
        row2.add(powernum);
        
        add(row2);
        
        GridLayout layout4 = new GridLayout(2, 3, 20, 10);
        row4.setLayout(layout4);
        row4.add(got3Label);
        got3.setEditable(false);
        row4.add(got3);
        row4.add(got4Label);
        got4.setEditable(false);
        row4.add(got4);
        row4.add(got5Label);
        got5.setEditable(false);
        row4.add(got5);
        row4.add(got3PLabel);
        got3P.setEditable(false);
        row4.add(got3P);
        row4.add(got4PLabel);
        got4P.setEditable(false);
        row4.add(got4P);
        row4.add(got5PLabel);
        got5P.setEditable(false);
        row4.add(got5P);
        add(row4);
        
        
        setVisible(true);
    }
    
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            //ignore error
        }
    }
    public static void main(String[] arguments) {
        LottoMadness.setLookAndFeel();
        LottoMadness frame = new LottoMadness();
    }
}