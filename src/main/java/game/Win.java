package game;

import constants.ConstsBordersAndColours;
import constants.ConstsForPoints;
import helping_thing.HelpingMethogs;

import javax.swing.*;
import java.awt.*;

public class Win extends JFrame {
    public Win(String winner) {
        super("WIIIN!!!");
        this.setBounds(ConstsBordersAndColours.SIX_HUNDRED + ConstsBordersAndColours.HUNDRED, ConstsBordersAndColours.HUNDRED * 2, ConstsBordersAndColours.SIX_HUNDRED / 2, ConstsBordersAndColours.SIX_HUNDRED / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new PainterForWinner(winner));

        JButton ok = new JButton("Ok, bb");
        this.add(ok, BorderLayout.SOUTH);

        //ok.addActionListener(new OkButton());
    }

    static class PainterForWinner extends JComponent {

        private final String winner;

        public PainterForWinner(String winner) {
            this.winner = winner;
        }

        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            Font font = new Font("Comic Sans MS", Font.BOLD, ConstsBordersAndColours.TWENTY);
            g2.setFont(font);
            g2.setPaint(Color.blue);
            int hun = ConstsBordersAndColours.SIX_HUNDRED / 2 / 2 / 2;

            int ten = ConstsBordersAndColours.IDENTATION;

            Image image = HelpingMethogs.imageGenerator("winner.png");
            g2.drawImage(image, ten, ten, ConstsBordersAndColours.SIX_HUNDRED / 2 - ten, ConstsBordersAndColours.SIX_HUNDRED / 2 - ten, null);

            font = new Font("Comic Sans MS", Font.BOLD, ConstsBordersAndColours.TWENTY * 2);
            g2.setFont(font);
            g2.setPaint(Color.pink);
            g2.drawString(winner, hun, hun * 2 + ConstsForPoints.HALF);
        }
    }
}
