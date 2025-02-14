package sorts;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class SortTests {

    // 1. Prueba: Verifica que el algoritmo ordene correctamente un arreglo aleatorio
    @Test
    void testRandomArraySorting() {
        Integer[] array = {5, 3, 8, 1, 2};
        Integer[] expected = {1, 2, 3, 5, 8};

        QuickSort.sort(array); // Cambia por cualquier sort que quieras probar

        assertArrayEquals(expected, array, "El arreglo no fue ordenado correctamente.");
    }

    // 2. Prueba: Verifica que un arreglo ya ordenado permanece igual
    @Test
    void testSortedArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        MergeSort.sort(array);

        assertArrayEquals(expected, array, "El sort cambió un arreglo ya ordenado.");
    }

    // 3. Prueba: Verifica que un arreglo con elementos repetidos se ordene correctamente
    @Test
    void testArrayWithDuplicates() {
        Integer[] array = {4, 1, 3, 1, 4, 2, 2};
        Integer[] expected = {1, 1, 2, 2, 3, 4, 4};

        ShellSort.sort(array);

        assertArrayEquals(expected, array, "El algoritmo no maneja correctamente los duplicados.");
    }
}