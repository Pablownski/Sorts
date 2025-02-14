package sorts;

/**
 * Este algoritmo usa recursión para dividir y conquistar la lista,
 * seleccionando un pivote y reorganizando los elementos a su alrededor.
 */
public class QuickSort {

    /**
     * Ordena un arreglo utilizando el algoritmo QuickSort.
     * 
     * @param <T>   Tipo de los elementos del arreglo, debe ser comparable.
     * @param array Arreglo de elementos a ordenar.
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Aplica el algoritmo QuickSort de manera recursiva.
     * 
     * @param <T>   Tipo de los elementos del arreglo, debe ser comparable.
     * @param array Arreglo de elementos a ordenar.
     * @param low   Índice inferior del subarreglo a ordenar.
     * @param high  Índice superior del subarreglo a ordenar.
     */
    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    /**
     * Particiona el arreglo en torno a un pivote y devuelve su índice final.
     * 
     * @param <T>   Tipo de los elementos del arreglo, debe ser comparable.
     * @param array Arreglo de elementos a ordenar.
     * @param low   Índice inferior del subarreglo.
     * @param high  Índice superior del subarreglo (se usa como pivote).
     * @return Índice final del pivote después de la partición.
     */
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Intercambia dos elementos en un arreglo.
     * 
     * @param <T>   Tipo de los elementos del arreglo.
     * @param array Arreglo en el que se realizará el intercambio.
     * @param i     Índice del primer elemento a intercambiar.
     * @param j     Índice del segundo elemento a intercambiar.
     */
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
