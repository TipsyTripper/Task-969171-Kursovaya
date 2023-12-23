package menu;

import actions.ActionForOkInputName;
import constants.ConstsBordersAndColours;
import constants.ConstsForOpti;
import helping_thing.GameCondition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameMenu extends JFrame {

    private static final JTextField inputName = new JTextField("", 5);

    public NameMenu() {
        super("Ho is it");
        this.setBounds(ConstsBordersAndColours.SIX_HUNDRED, ConstsBordersAndColours.HUNDRED, ConstsBordersAndColours.THREE_HUNDRED + ConstsForOpti.HALF, ConstsBordersAndColours.HUNDRED);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelName = new JLabel("Input name:");
        JButton ok = new JButton("OK");

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 2, 2));

        container.add(labelName);
        container.add(inputName);

        container.add(ok);

        ok.addActionListener(new ActionForOkInputName());
    }

    public String getName() {
        return inputName.getText();
    }

}
