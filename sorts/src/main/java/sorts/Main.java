package sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase principal que ejecuta y mide el tiempo de ejecución de diferentes algoritmos de ordenamiento.
 * Los algoritmos evaluados son: Insertion Sort, Merge Sort, Quick Sort, Radix Sort y Shell Sort.
 * Se mide el tiempo de ejecución para datos desordenados y ordenados.
 */
public class Main {
    
    /**
     * Método principal que ejecuta los algoritmos de ordenamiento y mide su rendimiento.
     * 
     * @param args Argumentos de línea de comandos (no utilizados en esta implementación).
     */
    public static void main(String[] args) {
        int[] sizes = {10, 100, 300, 500, 700, 900, 1200, 1500, 1800, 2000}; // Tamaños de los arreglos a evaluar
        Random rand = new Random();

        
        System.out.println("Tamaño | InsertionSort (ms) | InsertionSort (Ordenado) | MergeSort (ms) | MergeSort (Ordenado) | QuickSort (ms) | QuickSort (Ordenado) | RadixSort (ms) | RadixSort (Ordenado) | ShellSort (ms) | ShellSort (Ordenado)");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int size : sizes) {
            Integer[] array = generateRandomArray(size, rand);

            // Copias del arreglo para cada algoritmo
            Integer[] insertionArray = Arrays.copyOf(array, array.length);
            Integer[] mergeArray = Arrays.copyOf(array, array.length);
            Integer[] quickArray = Arrays.copyOf(array, array.length);
            Integer[] radixArray = Arrays.copyOf(array, array.length);
            Integer[] shellArray = Arrays.copyOf(array, array.length);

            long startTime, endTime;
            double insertionTime, insertionTimeSorted;
            double mergeTime, mergeTimeSorted;
            double quickTime, quickTimeSorted;
            double radixTime, radixTimeSorted;
            double shellTime, shellTimeSorted;

            // Insertion Sort (Desordenado)
            startTime = System.nanoTime();
            InsertionSort.sort(insertionArray);
            endTime = System.nanoTime();
            insertionTime = (endTime - startTime) / 1e6;

            // Insertion Sort (Ordenado)
            startTime = System.nanoTime();
            InsertionSort.sort(insertionArray);
            endTime = System.nanoTime();
            insertionTimeSorted = (endTime - startTime) / 1e6;

            // Merge Sort (Desordenado)
            startTime = System.nanoTime();
            MergeSort.sort(mergeArray);
            endTime = System.nanoTime();
            mergeTime = (endTime - startTime) / 1e6;

            // Merge Sort (Ordenado)
            startTime = System.nanoTime();
            MergeSort.sort(mergeArray);
            endTime = System.nanoTime();
            mergeTimeSorted = (endTime - startTime) / 1e6;

            // Quick Sort (Desordenado)
            startTime = System.nanoTime();
            QuickSort.sort(quickArray);
            endTime = System.nanoTime();
            quickTime = (endTime - startTime) / 1e6;

            // Quick Sort (Ordenado)
            startTime = System.nanoTime();
            QuickSort.sort(quickArray);
            endTime = System.nanoTime();
            quickTimeSorted = (endTime - startTime) / 1e6;

            // Radix Sort (Desordenado)
            startTime = System.nanoTime();
            RadixSort.sort(radixArray);
            endTime = System.nanoTime();
            radixTime = (endTime - startTime) / 1e6;

            // Radix Sort (Ordenado)
            startTime = System.nanoTime();
            RadixSort.sort(radixArray);
            endTime = System.nanoTime();
            radixTimeSorted = (endTime - startTime) / 1e6;

            // Shell Sort (Desordenado)
            startTime = System.nanoTime();
            ShellSort.sort(shellArray);
            endTime = System.nanoTime();
            shellTime = (endTime - startTime) / 1e6;

            // Shell Sort (Ordenado)
            startTime = System.nanoTime();
            ShellSort.sort(shellArray);
            endTime = System.nanoTime();
            shellTimeSorted = (endTime - startTime) / 1e6;

            // Imprimir resultados en formato de tabla
            System.out.printf("%6d | %18.3f | %26.3f | %14.3f | %24.3f | %14.3f | %24.3f | %14.3f | %24.3f | %14.3f | %24.3f\n",
                    size, insertionTime, insertionTimeSorted, mergeTime, mergeTimeSorted, 
                    quickTime, quickTimeSorted, radixTime, radixTimeSorted, shellTime, shellTimeSorted);
        }
    }

    /**
     * Genera un arreglo de números aleatorios en un rango de 0 a 9999.
     * 
     * @param size Tamaño del arreglo a generar.
     * @param rand Objeto Random para la generación de números aleatorios.
     * @return Un arreglo de enteros aleatorios.
     */
    private static Integer[] generateRandomArray(int size, Random rand) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000);
        }
        return array;
    }
}
