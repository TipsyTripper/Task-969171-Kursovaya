package helping_thing;

import constants.ConstsForOpti;
import database.persistence.OptionsPersistence;
import gamblers.RealGamer;
import gamblers.TheGamblers;
import game.GameMake;
import game.Win;
import menu.Menu;
import menu.NameMenu;
import opti.Options;
import opti.TheBolt;

public class GameCondition {
    private static GameCondition gameCondition;
    private static Menu menu;
    private static NameMenu nameMenu;
    private static Options opt;
    private static int id;

    private static TheGamblers theGamblers;
    private static TheBolt theBolt;
    private static OptionsPersistence optionsPersistence;

    public GameCondition() {
    }

    public static GameCondition mainCondition() {
        if (gameCondition == null) {
            gameCondition = new GameCondition();
        }

        return gameCondition;
    }
    public void createNameMenu() {
        nameMenu = new NameMenu();
        nameMenu.setVisible(true);
        nameMenu.setResizable(false);
    }

    public void exitNameMenu() {
        optionsPersistence = new OptionsPersistence();
        String name = nameMenu.getName();
        nameMenu.setVisible(false);
        int idCheck = optionsPersistence.selectIdByName(name);
        if (idCheck == 0) {
            optionsPersistence.createGambler(name, ConstsForOpti.MIN_GAMBLERS, ConstsForOpti.HALF);
            optionsPersistence = new OptionsPersistence();
        } else {
            id = idCheck;
            theGamblers = new TheGamblers(optionsPersistence.selectGamblersById(id));
            theBolt = new TheBolt(optionsPersistence.selectBoltById(id));
        }
        createMenu();
    }

    public void createMenu() {
        menu = new Menu();
        menu.setVisible(true);
        menu.setResizable(false);
    }

    public void exitMenu() {
        menu.dispose();
        System.exit(0);
    }

    public void disposeMenu(){
        menu.dispose();
    }

    public void createOpt() {
        opt = new Options(id);
        opt.setVisible(true);
        opt.setResizable(false);
    }

    public void exitOpt() {
        opt.dispose();
    }

    public void newSets() {
        optionsPersistence.updateInf(id, "gamblers", Integer.toString(theGamblers.getGamblers()));
        optionsPersistence.updateInf(id, "bolt", Integer.toString(theBolt.getBolt()));

        GameMake.createGamblers(new RealGamer(optionsPersistence.selectNameById(id)), optionsPersistence.selectGamblersById(id));
        exitOpt();
    }

    public void theWin(String winner) {
        Win win = new Win(winner);
        GameMake.gameDispose();
        win.setVisible(true);
        win.setResizable(false);
    }

    public int getBolt() {
        return optionsPersistence.selectBoltById(id);
    }

    public TheBolt getTheBolt() {
        return theBolt;
    }

    public TheGamblers getTheGamblers() {
        return theGamblers;
    }

    public int getId() {
        return id;
    }

    public void boltHalf(boolean what) {
        if (what) {
            theBolt.boltHalf();
        } else {
            theBolt.boltHundred();
        }
    }

    public void plusOrMinus(boolean what) {
        if (what) {
            theGamblers.gamblersPlus();
        } else {
            theGamblers.gamblersMinus();
        }
    }
}
