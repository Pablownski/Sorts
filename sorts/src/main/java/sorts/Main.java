package sorts;
import java.util.Arrays;
import java.util.Random;

/**
 * Clase principal que ejecuta y mide el rendimiento de diferentes algoritmos de ordenamiento.
 */

public class Main {

     /**
     * Método principal que ejecuta los algoritmos de ordenamiento en diferentes tamaños de datos.
     */

    public static void main(String[] args) {
        int[] sizes = {0, 100, 300, 500, 700, 900, 1200, 1500, 1800, 2100, 2400, 2700, 3000};
        Random rand = new Random();
        // Tamaños de los arreglos a ordenar, creando una tabla

        System.out.println("Tamaño | InsertionSort (ms) | MergeSort (ms) | QuickSort (ms) | RadixSort (ms) | ShellSort (ms)");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (int size : sizes) {
            Integer[] array = generateRandomArray(size, rand);

            // Copias para cada algoritmo
            Integer[] insertionArray = Arrays.copyOf(array, array.length);


            long startTime, endTime;
            double insertionTime, mergeTime, quickTime, radixTime, shellTime;

            // Insertion Sort
            startTime = System.nanoTime();
            InsertionSort.sort(insertionArray);
            endTime = System.nanoTime();
            insertionTime = (endTime - startTime) / 1e6; // Convertir a milisegundos

            // Merge Sort
            startTime = System.nanoTime();
        
            endTime = System.nanoTime();
            mergeTime = (endTime - startTime) / 1e6;

            // Quick Sort
            startTime = System.nanoTime();
            
            endTime = System.nanoTime();
            quickTime = (endTime - startTime) / 1e6;

            // Radix Sort
            startTime = System.nanoTime();
            
            endTime = System.nanoTime();
            radixTime = (endTime - startTime) / 1e6;

            // Shell Sort
            startTime = System.nanoTime();
            
            endTime = System.nanoTime();
            shellTime = (endTime - startTime) / 1e6;

            // Imprimir resultados
            System.out.printf("%6d | %18.3f | %14.3f | %14.3f | %14.3f | %14.3f\n",
                    size, insertionTime, mergeTime, quickTime, radixTime, shellTime);
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
