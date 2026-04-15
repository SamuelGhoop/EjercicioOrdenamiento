import java.util.Arrays;

// Bubble Sort basico con arreglo de enteros
public class BubbleSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 1, 9, 2, 7};
        System.out.println("Antes:   " + Arrays.toString(numeros));
        sort(numeros);
        System.out.println("Despues: " + Arrays.toString(numeros));
    }
}