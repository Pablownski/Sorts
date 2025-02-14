package sorts;
import java.util.Arrays;

/**
 * Este algoritmo ordena los números enteros en base a sus dígitos,
 * procesando los dígitos de menor a mayor peso.
 */
public class RadixSort {

    /**
     * Ordena un arreglo de enteros utilizando Radix Sort.
     * 
     * @param array Arreglo de enteros a ordenar.
     */
    public static void sort(Integer[] array) {
        int max = Arrays.stream(array).max(Integer::compareTo).orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    /**
     * Ordena un arreglo de enteros según el dígito correspondiente a la
     * posición dada por exp, utilizando Counting Sort como subrutina.
     * 
     * @param array Arreglo de enteros a ordenar.
     * @param exp   Factor de expansión que representa la posición del dígito actual.
     */
    private static void countingSort(Integer[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Cuenta las ocurrencias de cada dígito en la posición actual
        for (int num : array) count[(num / exp) % 10]++;

        // Acumula los conteos para determinar las posiciones finales
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];

        // Construye el arreglo de salida con los elementos ordenados por dígitos
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copia el arreglo ordenado de vuelta al original
        for (int i = 0; i < array.length; i++) array[i] = output[i];
    }
}
