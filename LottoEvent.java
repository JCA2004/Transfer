package Lottery;

import javax.swing.*;
import java.awt.event.*;

public class LottoEvent implements ItemListener, ActionListener, Runnable {
    
    LottoMadness gui;
    Thread playing;
    
    public LottoEvent(LottoMadness in) {
        gui = in;
    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Play")) {
            startPlaying();
        }
        if (command.equals("Stop")) {
            stopPlaying();
        }
        if (command.equals("Reset")) {
            clearAllFields();
        }
    }
    void startPlaying() {
        playing = new Thread(this);
        playing.start();
        gui.play.setEnabled(false);
        gui.stop.setEnabled(true);
        gui.reset.setEnabled(false);
    }
    void stopPlaying() {
        gui.play.setEnabled(true);
        gui.stop.setEnabled(false);
        gui.reset.setEnabled(true);
        gui.personal.setEnabled(true);
        gui.quickpick.setEnabled(true);
        playing = null;
    }
    void clearAllFields() {
        for (int i = 0; i < 5; i++) {
            gui.numbers[i].setText(null);
            gui.winner[i].setText(null);
        }
        gui.powerchoice.setText(null);
        gui.powernum.setText(null);
        gui.jackpot.setText("0");
        gui.power.setText("0");
        gui.got3.setText("0");
        gui.got4.setText("0");
        gui.got5.setText("0");
        gui.drawings.setText("0");
        gui.years.setText("0");
    }
    
    public void itemStateChanged (ItemEvent event) {
        Object item = event.getItem();
        if (item == gui.quickpick) {
            for (int i = 0; i < 5; i++) {
                int pick;
                do {
                    pick = (int) Math.floor(Math.random() * 50 + 1);
                } while (numberGone(pick, gui.numbers, i));
                gui.numbers[i].setText("" + pick);
            }
            int powerpick;
            powerpick = (int) Math.floor(Math.random() * 50 + 1);
            gui.powerchoice.setText("" + powerpick);
        } else {
            for (int i = 0; i < 5; i++) {
                gui.numbers[i].setText(null);
            }
            gui.powerchoice.setText(null);
        }
    }
    
    void addOneToField(JTextField field) {
        int num = Integer.parseInt("0" + field.getText());
        num++;
        field.setText("" + num);
    }
    
    boolean numberGone (int num, JTextField[] pastNums, int count) {
        for (int i = 0; i < count; i++) {
            if (Integer.parseInt(pastNums[i].getText()) == num) {
                return true;
            }
        }
        return false;
    }
    
    boolean matchedOne (JTextField win, JTextField[] allPicks) {
        for (int i = 0; i < 5; i++) {
            String winText = win.getText();
            if ( winText.equals( allPicks[i].getText() ) ) {
                return true;
            }
        }
        return false;
    }
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (playing == thisThread) {
            
            addOneToField(gui.drawings);
            int draw = Integer.parseInt(gui.drawings.getText());
            float numYears = (float)draw / 104;
            gui.years.setText("" + numYears);
            if(draw == 1) {
                playing = null;
            }
            
            int matches = 0;
            for (int i = 0; i < 5; i++) {
                int ball;
                do {
                    ball = (int) Math.floor(Math.random() * 70 + 1);
                } while (numberGone (ball, gui.winner, i)); 
                gui.winner[i].setText("" + ball);
                if (matchedOne(gui.winner[i], gui.numbers)) {
                    matches++;
                }
            }
            boolean powermatch;
            int powerball;
            powerball = (int) Math.floor(Math.random() * 25 + 1);
            gui.powernum.setText("" + powerball);
            String power = gui.powernum.getText();
            if ( power.equals( gui.powerchoice.getText() ) ) {
                powermatch = true;
                addOneToField(gui.power);
            } else {
                powermatch = false;
            }
               
            switch (matches) {
                case 3:
                    if (powermatch) {
                        addOneToField(gui.got3P);
                    } else {
                    addOneToField(gui.got3);
                    }
                    break;
                case 4:
                    if (powermatch) {
                        addOneToField(gui.got4P);
                    } else {
                    addOneToField(gui.got4);
                    }
                    break;
                case 5:
                    if(powermatch) {
                        addOneToField(gui.got5P);
                        playing = null;
                        gui.reset.setEnabled(true);
                        gui.play.setEnabled(false);
                        gui.stop.setEnabled(false);
                    } else {
                        addOneToField(gui.got5);
                    }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //do nothing
            }
        }
    }
}