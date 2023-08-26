package TesteUnitario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import BuscaOrdenacao.*;

public class BubbleSortTest {
    private final BubbleSort bs = new BubbleSort();

    int v[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int v2[] = { 1, 2, 3, 4, 7, 6, 5, 8, 9, 10 };
    int desordenado[] = { 10, 7, 2, 5, 1, 4, 6, 9, 8, 3 };

    @Test
    void sortedOk() {
        assertEquals(v, bs.ordenar(desordenado));
    }

    @Test
    void sortedNotOk() {
        assertNotEquals(v2, bs.ordenar(desordenado));
    }
}
