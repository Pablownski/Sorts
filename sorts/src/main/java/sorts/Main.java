package sorts;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 300, 500, 700, 900, 1200, 1500, 1800, 2000};
        Random rand = new Random();

        System.out.println("Tamaño | InsertionSort (ms) | InsertionSort Ordenado (ms) | MergeSort (ms) | MergeSort Ordenado (ms) | QuickSort (ms) | QuickSort Ordenado (ms) | RadixSort (ms) | RadixSort Ordenado (ms) | ShellSort (ms) | ShellSort Ordenado (ms)");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int size : sizes) {
            Integer[] array = generateRandomArray(size, rand);

            // Crear copias para cada algoritmo
            Integer[] insertionArray = Arrays.copyOf(array, array.length);
            Integer[] mergeArray = Arrays.copyOf(array, array.length);
            Integer[] quickArray = Arrays.copyOf(array, array.length);
            Integer[] radixArray = Arrays.copyOf(array, array.length);
            Integer[] shellArray = Arrays.copyOf(array, array.length);

            long startTime, endTime;
            double insertionTime, insertionTimeSorted, mergeTime, mergeTimeSorted;
            double quickTime, quickTimeSorted, radixTime, radixTimeSorted, shellTime, shellTimeSorted;

            // Insertion Sort (desordenado)
            startTime = System.nanoTime();
            InsertionSort.sort(insertionArray);
            endTime = System.nanoTime();
            insertionTime = (endTime - startTime) / 1e6;

            // Insertion Sort (ordenado)
            startTime = System.nanoTime();
            InsertionSort.sort(insertionArray);
            endTime = System.nanoTime();
            insertionTimeSorted = (endTime - startTime) / 1e6;

            // Merge Sort (desordenado)
            startTime = System.nanoTime();
            MergeSort.sort(mergeArray);
            endTime = System.nanoTime();
            mergeTime = (endTime - startTime) / 1e6;

            // Merge Sort (ordenado)
            startTime = System.nanoTime();
            MergeSort.sort(mergeArray);
            endTime = System.nanoTime();
            mergeTimeSorted = (endTime - startTime) / 1e6;

            // Quick Sort (desordenado)
            startTime = System.nanoTime();
            QuickSort.sort(quickArray);
            endTime = System.nanoTime();
            quickTime = (endTime - startTime) / 1e6;

            // Quick Sort (ordenado)
            startTime = System.nanoTime();
            QuickSort.sort(quickArray);
            endTime = System.nanoTime();
            quickTimeSorted = (endTime - startTime) / 1e6;

            // Radix Sort (desordenado)
            startTime = System.nanoTime();
            RadixSort.sort(radixArray);
            endTime = System.nanoTime();
            radixTime = (endTime - startTime) / 1e6;

            // Radix Sort (ordenado)
            startTime = System.nanoTime();
            RadixSort.sort(radixArray);
            endTime = System.nanoTime();
            radixTimeSorted = (endTime - startTime) / 1e6;

            // Shell Sort (desordenado)
            startTime = System.nanoTime();
            ShellSort.sort(shellArray);
            endTime = System.nanoTime();
            shellTime = (endTime - startTime) / 1e6;

            // Shell Sort (ordenado)
            startTime = System.nanoTime();
            ShellSort.sort(shellArray);
            endTime = System.nanoTime();
            shellTimeSorted = (endTime - startTime) / 1e6;

            // Imprimir resultados en formato de tabla
            System.out.printf("%6d | %18.3f | %25.3f | %14.3f | %23.3f | %14.3f | %25.3f | %14.3f | %25.3f | %14.3f | %25.3f\n",
                    size, insertionTime, insertionTimeSorted, mergeTime, mergeTimeSorted, quickTime, quickTimeSorted,
                    radixTime, radixTimeSorted, shellTime, shellTimeSorted);
        }
    }

    private static Integer[] generateRandomArray(int size, Random rand) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000); // Números entre 0 y 9999
        }
        return array;
    }
}
