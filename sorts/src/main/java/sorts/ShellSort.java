package sorts;
/**
 Implementación del algoritmo de ordenamiento Shell Sort.
 Shell Sort es una optimización de Insertion Sort que permite intercambios 
 de elementos distantes, mejorando el rendimiento en comparación con el ordenamiento 
 por inserción tradicional.
 **/ 

public class ShellSort {
    // Ordena un arreglo utilizando el algoritmo Shell Sort.
    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
         // Se inicia con un gap grande y se reduce en cada iteración.
        for (int gap = n / 2; gap > 0; gap /= 2) {
             // Se aplica Insertion Sort considerando la separación (gap).
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j;
                // Desplaza los elementos hacia la derecha para insertar el actual en la posición correcta.
                for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}