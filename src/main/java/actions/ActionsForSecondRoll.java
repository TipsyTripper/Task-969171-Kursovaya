package actions;

import game.GameMake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionsForSecondRoll implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        GameMake.throwDices();
    }
}