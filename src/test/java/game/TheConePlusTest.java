package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TheConePlusTest {
    private final TheCone theCone = mock(TheCone.class);

    @Test
    @DisplayName("plus combo if i enter three '2' ")
    public void plusCombo4() {
        when(theCone.plus(3, 2)).thenReturn(20);
        int answer = theCone.plus(3, 2);
        Assertions.assertEquals(20, answer);
    }

    @Test
    @DisplayName("plus combo if i enter four '2' ")
    public void plusCombo5() {
        when(theCone.plus(4, 2)).thenReturn(40);
        int answer = theCone.plus(4, 2);
        Assertions.assertEquals(40, answer);
    }

    @Test
    @DisplayName("plus combo if i enter five '2' ")
    public void plusCombo6() {
        when(theCone.plus(5, 2)).thenReturn(200);
        int answer = theCone.plus(5, 2);
        Assertions.assertEquals(200, answer);
    }

    @Test
    @DisplayName("plus combo if i enter less 2")
    public void plusCombo1() {
        when(theCone.plus(0, 2)).thenReturn(0);
        int answer = theCone.plus(1, 4);
        Assertions.assertEquals(0, answer);
    }

}
