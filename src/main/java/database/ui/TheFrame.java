package database.ui;

import javax.swing.*;
import java.awt.*;

public class TheFrame extends JFrame {
    private static Container container;

    public TheFrame() {
        super("the game");
        this.setBounds(100, 100, 500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel labelName = new JLabel("name:");
    }

    public static void containerBoards(int rows) {
        container = new Container();
        container.setLayout(new GridLayout(rows, 1, 2, 2));
    }

    public static void containerAdd(String lable) {
        JLabel lableLable = new JLabel(lable);
        container.add(lableLable);
    }
    
    public void containerResult() {
        if (container != null) {
            this.add(container);
            this.setVisible(true);
        } else {
            System.out.println("nononononono");
        }
    }
}
