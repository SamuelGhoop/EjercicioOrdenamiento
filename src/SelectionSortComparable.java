import java.util.Arrays;
import java.util.List;

// Selection Sort generico usando Comparable
public class SelectionSortComparable {

    public static <T extends Comparable<T>> void sort(List<T> list) {
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
        List<String> nombres = Arrays.asList("Charlie", "Alice", "Bob", "Eve", "Diana");
        System.out.println("Antes:   " + nombres);
        sort(nombres);
        System.out.println("Despues: " + nombres);
    }
}