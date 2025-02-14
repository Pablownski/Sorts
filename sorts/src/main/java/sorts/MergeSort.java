package sorts;
import java.util.Arrays;
/** Implementación del algoritmo de ordenamiento Merge Sort.
Este algoritmo sigue el paradigma de "divide y vencerás", dividiendo 
el arreglo en mitades recursivamente, ordenándolas y luego combinándolas.
**/

public class MergeSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        sort(left);
        sort(right);
        merge(array, left, right);
    }

// Método auxiliar que combina dos arreglos ordenados en uno solo.


    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
             // Combina elementos de left y right en array en orden ascendente.
        while (i < left.length && j < right.length) {
            array[k++] = (left[i].compareTo(right[j]) <= 0) ? left[i++] : right[j++];
        }
           // Copia los elementos restantes de left, si hay alguno.
        while (i < left.length) array[k++] = left[i++];
            // Copia los elementos restantes de right, si hay alguno.
        while (j < right.length) array[k++] = right[j++];
    }
}