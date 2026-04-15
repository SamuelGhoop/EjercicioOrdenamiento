import java.util.Arrays;

// Selection Sort basico con arreglo de enteros
public class SelectionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 1, 9, 2, 7};
        System.out.println("Antes:   " + Arrays.toString(numeros));
        sort(numeros);
        System.out.println("Despues: " + Arrays.toString(numeros));
    }
}