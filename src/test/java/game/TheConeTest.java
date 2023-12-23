package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TheConeTest {

    @Test
    @DisplayName("plus combo if i enter 1, 2, 3, 4, 5 and schet ноль")
    public void plusCombo2() {
        int[] kindsOfNumbers = new int[]{1, 1, 1, 1, 1, 0};
        TheCone theCone = new TheCone(1);
        int answer = theCone.plusCombo(0, kindsOfNumbers);
        Assertions.assertEquals(0, answer);
    }

    @Test
    @DisplayName("plus combo if i enter 1, 3, 3, 4, 5  and schet ноль")
    public void plusCombo1() {
        int[] kindsOfNumbers = new int[]{1, 0, 2, 1, 1, 0};
        TheCone theCone = new TheCone(1);
        int answer = theCone.plusCombo(0, kindsOfNumbers);
        Assertions.assertEquals(0, answer);
    }

    @Test
    @DisplayName("plus combo if i enter three '2' and schet единица")
    public void plusCombo4() {
        int[] kindsOfNumbers = new int[]{0, 1, 1, 1, 1, 1};
        TheCone theCone = new TheCone(1);
        int answer = theCone.plusCombo(1, kindsOfNumbers);
        Assertions.assertEquals(125, answer);
    }

    @Test
    @DisplayName("plus combo if i enter four '2' and schet единица")
    public void plusCombo5() {
        int[] kindsOfNumbers = new int[]{0, 0, 4, 1, 0, 0};
        TheCone theCone = new TheCone(1);
        int answer = theCone.plusCombo(1, kindsOfNumbers);
        Assertions.assertEquals(0, answer);
    }

    @Test
    @DisplayName("plus combo if i enter five '2' and schet единица")
    public void plusCombo6() {
        int[] kindsOfNumbers = new int[]{0, 5, 0, 0, 0, 0};
        TheCone theCone = new TheCone(1);
        int answer = theCone.plusCombo(1, kindsOfNumbers);
        Assertions.assertEquals(0, answer);
    }

    @Test
    @DisplayName("plus combo if i enter 1, 3, 3, 4, 5  and schet 1")
    public void plusCombo7() {
        int[] kindsOfNumbers = new int[]{1, 0, 2, 1, 1, 1};
        TheCone theCone = new TheCone(1);
        int answer = theCone.plusCombo(1, kindsOfNumbers);
        Assertions.assertEquals(0, answer);
    }
}
