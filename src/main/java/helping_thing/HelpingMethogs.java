package helping_thing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class HelpingMethogs {

    public static ImageIcon imageIconGenerator(String fileName) {
        try {
            URL fileURL = Thread.currentThread().getContextClassLoader().getResource("img/" + fileName);
            ImageIcon img = new ImageIcon(fileURL);
            return img;
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Image imageGenerator(String fileName) {
        try {
            URL fileURL = Thread.currentThread().getContextClassLoader().getResource("img/" + fileName);
            ImageIcon img = new ImageIcon(fileURL);
            return img.getImage();
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Image imageOfDice(String cube) {
        Image im = HelpingMethogs.imageGenerator("cube_one.png");
        switch (cube) {
            case "two" -> im = imageGenerator("cube_two.png");
            case "three" -> im = imageGenerator("cube_three.png");
            case "four" -> im = imageGenerator("cube_four.png");
            case "five" -> im = imageGenerator("cube_five.png");
            case "six" -> im = imageGenerator("cube_six.png");
        }
        return im;
    }
}
