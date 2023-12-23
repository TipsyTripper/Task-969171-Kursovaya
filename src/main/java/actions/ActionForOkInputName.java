package actions;

import helping_thing.GameCondition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionForOkInputName implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        GameCondition gameCondition = GameCondition.mainCondition();
        gameCondition.exitNameMenu();
    }
}