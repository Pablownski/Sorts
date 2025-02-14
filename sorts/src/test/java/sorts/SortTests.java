package sorts;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para verificar el correcto funcionamiento de los algoritmos de ordenamiento.
 */
public class SortTests {

    /**
     * Prueba que verifica que un arreglo aleatorio se ordena correctamente con QuickSort.
     */
    @Test
    void testRandomArraySorting() {
        Integer[] array = {5, 3, 8, 2, 1};
        Integer[] expected = {1, 2, 3, 5, 8}; // Arreglo esperado ordenado

        QuickSort.sort(array); // Cambia el algoritmo según lo que desees probar

        assertArrayEquals(expected, array, "El arreglo no fue ordenado correctamente.");
    }

    /**
     * Prueba que verifica que un arreglo ya ordenado permanece sin cambios después de ordenar.
     */
    @Test
    void testSortedArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5}; // Ya está ordenado

        MergeSort.sort(array); // Prueba con MergeSort

        assertArrayEquals(expected, array, "El sort cambió un arreglo ya ordenado.");
    }

    /**
     * Prueba que verifica que un arreglo con elementos repetidos se ordena correctamente.
     */
    @Test
    void testArrayWithDuplicates() {
        Integer[] array = {4, 1, 3, 1, 2, 2, 4};
        Integer[] expected = {1, 1, 2, 2, 3, 4, 4}; // Orden correcto

        ShellSort.sort(array); // Prueba con ShellSort

        assertArrayEquals(expected, array, "El algoritmo no maneja correctamente los duplicados.");
    }
}
