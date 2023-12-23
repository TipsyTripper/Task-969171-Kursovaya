package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.ConstsBordersAndColours;
import constants.ConstsForPoints;
import database.persistence.OptionsPersistence;
import gamblers.RealGamer;
import game.GameMake;
import helping_thing.GameCondition;
import helping_thing.HelpingMethogs;


public class Menu extends JFrame{

    public Menu() {
        super("Playful Dices");
        this.setBounds(ConstsBordersAndColours.NINETY, ConstsBordersAndColours.NINETY,ConstsBordersAndColours.SIX_HUNDRED * 2, ConstsBordersAndColours.THREE_HUNDRED);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton start = new JButton(HelpingMethogs.imageIconGenerator("start.png"));

        JButton options = new JButton(HelpingMethogs.imageIconGenerator("coffee.png"));

        JButton exit = new JButton(HelpingMethogs.imageIconGenerator("exit.png"));

        JButton changeName = new JButton(HelpingMethogs.imageIconGenerator("change.png"));

        JLabel flash = new JLabel(HelpingMethogs.imageIconGenerator("flash.png"));

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, ConstsForPoints.THREE, 2, 2));

        container.add(start);
        container.add(options);
        container.add(exit);
        container.add(flash);
        container.add(changeName);

        start.addActionListener(new ActionsForStart());
        options.addActionListener(new ActionsToOptions());
        exit.addActionListener(new ActionsForExit());
        changeName.addActionListener(new ActionsForChangingName());
    }

    public static class ActionsForChangingName implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameCondition gameCondition = GameCondition.mainCondition();
            gameCondition.createNameMenu();
            gameCondition.disposeMenu();
        }
    }

    public static class ActionsToOptions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameCondition gameCondition = GameCondition.mainCondition();
            gameCondition.createOpt();
        }

    }

    public static class ActionsForStart implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameCondition gameCondition = new GameCondition();
            OptionsPersistence optionsPersistence = new OptionsPersistence();
            int id = gameCondition.getId();

            GameMake.createGamblers(new RealGamer(optionsPersistence.selectNameById(id)), optionsPersistence.selectGamblersById(id));
            GameMake.createGameFrame();
        }
    }

    public static class ActionsForExit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameCondition gameCondition = new GameCondition();
            gameCondition.exitMenu();
        }
    }


}
