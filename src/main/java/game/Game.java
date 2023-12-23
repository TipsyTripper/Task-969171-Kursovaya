package game;

import actions.ActionsForNotRoll;
import actions.ActionsForRoll;
import actions.ActionsForSecondRoll;
import constants.ConstsBordersAndColours;
import constants.ConstsForPoints;
import gamblers.Gambler;
import helping_thing.HelpingMethogs;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Game extends JFrame {
    private static ArrayList<String> cubes;
    private Painter paint;
    private static int numberOfGambler;
    private final int countOfGamblers;
    private final JButton mainButton = new JButton("Roll dice");

    private final Container con = new Container();
    public Game(int numberOfGambler1) {
        super("The Game Of Dice");
        numberOfGambler = numberOfGambler1;
        Gambler[] gamblers = GameMake.getGamblers();
        countOfGamblers = gamblers.length;
        this.setBounds(ConstsBordersAndColours.NINETY, ConstsBordersAndColours.NINETY,ConstsBordersAndColours.SIX_HUNDRED, ConstsBordersAndColours.SIX_HUNDRED);

        paint = new Painter(false, true, countOfGamblers);
        JButton secondRoll = new JButton("Second roll");
        JButton notRoll = new JButton("not roll");
        con.add(secondRoll);
        con.add(notRoll);
        this.add(paint);

        add(mainButton, BorderLayout.SOUTH);
        mainButton.addActionListener(new ActionsForRoll(numberOfGambler));
        secondRoll.addActionListener(new ActionsForSecondRoll());
        notRoll.addActionListener(new ActionsForNotRoll());
    }

    protected void rewrite() {
        paint = new Painter(false, true, countOfGamblers);
        this.add(paint);
        mainButton();
    }

    protected void addCubes(ArrayList<String> cubesForWin, int number, boolean check) {
        numberOfGambler = number;
        cubes = cubesForWin;
        paint = new Painter(true, check, countOfGamblers);
        this.add(paint);
        getContentPane().setVisible(false);
        getContentPane().setVisible(true);
    }

    protected void mainButton() {
        this.add(mainButton, BorderLayout.SOUTH);
        getContentPane().setVisible(false);
        getContentPane().setVisible(true);
    }

    protected void secondButton() {
        this.add(con, BorderLayout.SOUTH);
        getContentPane().setVisible(false);
        getContentPane().setVisible(true);
    }

    protected void deleteButton() {
        this.removeAll();
        getContentPane().setVisible(false);
        getContentPane().setVisible(true);
    }

    static class Painter extends JComponent {
        private final boolean check;
        private final boolean checkForNewCone;
        private final int countOfGamblers;

        public Painter(boolean check, boolean checkForNewCone, int countOfGamblers) {
            this.check = check;
            this.checkForNewCone = checkForNewCone;
            this.countOfGamblers = countOfGamblers;
        }

        protected void paintComponent(Graphics g) {
            Gambler[] gamblers = GameMake.getGamblers();
            Graphics2D g2 = (Graphics2D) g;

            Image image = HelpingMethogs.imageGenerator("back1.png");
            g2.drawImage(image, ConstsBordersAndColours.IDENTATION, ConstsBordersAndColours.IDENTATION, ConstsBordersAndColours.RECTANGLE_X, ConstsBordersAndColours.RECTANGLE_Y, null);

            int x = ConstsBordersAndColours.RECTANGLE_Y / (countOfGamblers * countOfGamblers);
            int colourR = ConstsBordersAndColours.HUNDRED;
            int colourG = ConstsBordersAndColours.HUNDRED;
            int colourB = ConstsBordersAndColours.COLOR_B2;
            int partOfColor = ConstsBordersAndColours.MAX_COLOR / countOfGamblers / 2;
            Font font = new Font("Comic Sans MS", Font.BOLD, ConstsBordersAndColours.FONT_SIZE_FIFTH);
            g2.setFont(font);

            for (Gambler gambler : gamblers) {
                Ellipse2D elley = new Ellipse2D.Float(x, ConstsBordersAndColours.NINETY, ConstsBordersAndColours.NINETY, ConstsBordersAndColours.NINETY);
                g2.setPaint(new Color(colourR, colourG, colourB));
                g2.fill(elley);

                Image im = HelpingMethogs.imageGenerator("cat-gambler.png");
                g2.drawImage(im, x, ConstsBordersAndColours.NINETY, ConstsBordersAndColours.NINETY, ConstsBordersAndColours.NINETY, null);

                g2.setPaint(Color.BLACK);
                g2.drawString(gambler.getName(), x, ConstsBordersAndColours.HUNDRED * 2);
                g2.drawString("Points : " + gambler.getPoints(), x, ConstsBordersAndColours.HUNDRED * 2 + ConstsBordersAndColours.TWENTY);
                g2.drawString(gambler.getPCOrGambler(), x, ConstsBordersAndColours.HUNDRED * 2 + ConstsBordersAndColours.TWENTY * 2);

                x += ConstsBordersAndColours.RECTANGLE_Y / countOfGamblers;
                colourR += partOfColor;
                colourG += partOfColor;
                colourB -= partOfColor;

            }

            if (checkForNewCone) {
                g2.setColor(Color.YELLOW);
                g2.drawString("Промежуточный плюс" + GameMake.getTheNowestResult(), ConstsBordersAndColours.THREE_HUNDRED, ConstsBordersAndColours.FOUR_HUNDRED);
                g2.setColor(Color.BLACK);
                if (numberOfGambler != countOfGamblers - 1) {
                    g2.drawString(gamblers[numberOfGambler + 1].getName() + " получит: " + GameMake.getTheNowestResult(), ConstsBordersAndColours.HUNDRED, ConstsBordersAndColours.FOUR_HUNDRED + ConstsForPoints.HALF / 2);
                    g2.drawString("у " + gamblers[numberOfGambler + 1].getName() + " количество болтов: " + gamblers[numberOfGambler].getCountOfBolt(), ConstsBordersAndColours.HUNDRED, ConstsBordersAndColours.FOUR_HUNDRED + ConstsForPoints.HALF);
                    font = new Font("Comic Sans MS", Font.BOLD, ConstsBordersAndColours.TWENTY);
                    g2.setFont(font);
                    g2.drawString("Сейчас ходит " + gamblers[numberOfGambler + 1].getName(), ConstsBordersAndColours.THREE_HUNDRED, ConstsBordersAndColours.COLOR_G * 2);
                } else {
                    g2.drawString(gamblers[0].getName() + " получит: " + GameMake.getTheNowestResult(), ConstsBordersAndColours.HUNDRED, ConstsBordersAndColours.FOUR_HUNDRED + ConstsForPoints.HALF / 2);
                    g2.drawString("у " + gamblers[0].getName() + " количество болтов: " + gamblers[0].getCountOfBolt(), ConstsBordersAndColours.HUNDRED, ConstsBordersAndColours.FOUR_HUNDRED + ConstsForPoints.HALF);
                    font = new Font("Comic Sans MS", Font.BOLD, ConstsBordersAndColours.TWENTY);
                    g2.setFont(font);
                    g2.drawString("Сейчас ходит " + gamblers[0].getName(), ConstsBordersAndColours.THREE_HUNDRED, ConstsBordersAndColours.COLOR_G * 2);
                }
            } else {
                g2.drawString(gamblers[numberOfGambler].getName() + " получит: " + GameMake.getTheNowestResult(), ConstsBordersAndColours.HUNDRED, ConstsBordersAndColours.FOUR_HUNDRED + ConstsForPoints.HALF / 2);
                g2.drawString("у " + gamblers[numberOfGambler].getName() + " столько болтов: " + gamblers[numberOfGambler].getCountOfBolt(), ConstsBordersAndColours.HUNDRED, ConstsBordersAndColours.FOUR_HUNDRED + ConstsForPoints.HALF);
                font = new Font("Comic Sans MS", Font.BOLD, ConstsBordersAndColours.TWENTY);
                g2.setFont(font);
                g2.drawString("Сейчас ходит " + gamblers[numberOfGambler].getName(), ConstsBordersAndColours.THREE_HUNDRED, ConstsBordersAndColours.COLOR_G * 2);
            }

            if (check) {
                x = ConstsForPoints.HALF;
                for (String cube : cubes) {
                    Image im = HelpingMethogs.imageOfDice(cube);

                    g2.drawImage(im, x, ConstsBordersAndColours.MAX_COLOR, ConstsBordersAndColours.NINETY, ConstsBordersAndColours.NINETY, null);
                    x += ConstsForPoints.HUNDRED;
                }
            }

        }
    }
}

