import java.util.Arrays;
import java.util.List;

public class Ejercicio1 {

    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static <T extends Comparable<T>> void selectionSort(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).compareTo(list.get(minIdx)) < 0) {
                    minIdx = j;
                }
            }
            T tmp = list.get(minIdx);
            list.set(minIdx, list.get(i));
            list.set(i, tmp);
        }
    }

    public static void main(String[] args) {
        List<Persona> listaBubble = Arrays.asList(
                new Persona("Carlos", 25, 'M'),
                new Persona("Ana", 30, 'F'),
                new Persona("Luis", 20, 'M'),
                new Persona("Maria", 25, 'F'),
                new Persona("Pedro", 35, 'M'),
                new Persona("Laura", 20, 'F')
        );
        bubbleSort(listaBubble);
        System.out.println("Bubble Sort:");
        for (Persona p : listaBubble) System.out.println("  " + p);

        List<Persona> listaInsertion = Arrays.asList(
                new Persona("Carlos", 25, 'M'),
                new Persona("Ana", 30, 'F'),
                new Persona("Luis", 20, 'M'),
                new Persona("Maria", 25, 'F'),
                new Persona("Pedro", 35, 'M'),
                new Persona("Laura", 20, 'F')
        );
        insertionSort(listaInsertion);
        System.out.println("Insertion Sort:");
        for (Persona p : listaInsertion) System.out.println("  " + p);

        List<Persona> listaSelection = Arrays.asList(
                new Persona("Carlos", 25, 'M'),
                new Persona("Ana", 30, 'F'),
                new Persona("Luis", 20, 'M'),
                new Persona("Maria", 25, 'F'),
                new Persona("Pedro", 35, 'M'),
                new Persona("Laura", 20, 'F')
        );
        selectionSort(listaSelection);
        System.out.println("Selection Sort:");
        for (Persona p : listaSelection) System.out.println("  " + p);
    }
}

/*
 * Un metodo de ordenamiento es ESTABLE si cuando hay elementos con el mismo valor de comparacion
 * (en este caso el mismo nombre), estos mantienen el orden relativo que tenian en la lista original.
 *
 * Por ejemplo, Carlos(25) aparece antes que Maria(25) en la lista original.
 * Un algoritmo estable garantiza que Carlos siempre aparecera antes que Maria en el resultado.
 *
 * - Bubble Sort:    ESTABLE - solo intercambia elementos adyacentes cuando uno es estrictamente mayor,
 *                   por lo que elementos iguales nunca se intercambian entre si.
 *
 * - Insertion Sort: ESTABLE - inserta cada elemento en su posicion correcta sin mover los elementos
 *                   que ya tienen el mismo valor, preservando el orden original.
 *
 * - Selection Sort: NO ESTABLE - al intercambiar el minimo con la posicion actual, puede saltar
 *                   por encima de elementos iguales y cambiar su orden relativo.
 *                   Ejemplo: lista [3a, 3b, 1] -> selecciona 1, lo intercambia con 3a -> [1, 3b, 3a]
 *                   Ahora 3b aparece antes que 3a, el orden original se perdio.
 */