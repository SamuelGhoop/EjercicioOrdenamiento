import java.util.Arrays;
import java.util.List;

// Bubble Sort generico usando Comparable
public class BubbleSortComparable {

    public static <T extends Comparable<T>> void sort(List<T> list) {
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

    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Charlie", "Alice", "Bob", "Eve", "Diana");
        System.out.println("Antes:   " + nombres);
        sort(nombres);
        System.out.println("Despues: " + nombres);
    }
}