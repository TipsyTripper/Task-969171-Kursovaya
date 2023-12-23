package opti;
import constants.ConstsBordersAndColours;
import constants.ConstsForOpti;
import helping_thing.GameCondition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JFrame{

    public Options(int id) {
        super("Options");
        this.setBounds(ConstsBordersAndColours.SIX_HUNDRED, ConstsBordersAndColours.HUNDRED, ConstsBordersAndColours.THREE_HUNDRED + ConstsForOpti.HALF, ConstsBordersAndColours.THREE_HUNDRED);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton plusGambler = new JButton("+ gambler");
        JButton minusGambler = new JButton("- gambler");
        JButton hundred = new JButton("A hundred");
        JButton half = new JButton("A half");
        JLabel voids1 = new JLabel();
        JButton ok = new JButton();


        Container container = this.getContentPane();
        container.setLayout(new GridLayout(8, 1, 2,2));

        GameCondition gameCondition = new GameCondition();
        container.add(gameCondition.getTheGamblers());
        container.add(plusGambler);
        container.add(minusGambler);
        container.add(voids1);
        container.add(gameCondition.getTheBolt());
        container.add(hundred);
        container.add(half);
        container.add(ok);

        plusGambler.addActionListener(new ActionsForPlus());
        minusGambler.addActionListener(new ActionsForMinus());
        hundred.addActionListener(new ActionsForHundred());
        half.addActionListener(new ActionsForHalf());
        ok.addActionListener(new ActionsForOkInOpt());
    }

    public static class ActionsForPlus implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameCondition gameCondition = new GameCondition();
            gameCondition.plusOrMinus(true);
        }
    }

    public static class ActionsForOkInOpt implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameCondition gameCondition = GameCondition.mainCondition();
            gameCondition.newSets();
        }
    }

    public static class ActionsForMinus implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameCondition gameCondition = new GameCondition();
            gameCondition.plusOrMinus(false);
        }
    }

    public static class ActionsForHundred implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameCondition gameCondition = new GameCondition();
            gameCondition.boltHalf(false);
        }
    }

    public static class ActionsForHalf implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameCondition gameCondition = new GameCondition();
            gameCondition.boltHalf(true);
        }
    }
}
