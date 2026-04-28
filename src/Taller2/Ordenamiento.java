package Taller2;



//#orden{

    public class Ordenamiento {

        // 1. Método principal que el usuario llama
        public static void quickSort(int[] arr, int inicio, int fin) {
            if (inicio < fin) {
                // Se obtiene la posición del pivote tras la partición
                int indicePivote = particion(arr, inicio, fin);

                // Llamadas recursivas para ordenar las dos mitades
                quickSort(arr, inicio, indicePivote - 1); // Mitad izquierda
                quickSort(arr, indicePivote + 1, fin);    // Mitad derecha
            }
        }

        // 2. Método de Partición (donde ocurre la magia)
        public static int particion(int[] arr, int inicio, int fin) {
            // Elegimos el último elemento como pivote [cite: 25]
            int pivote = arr[fin];
            int i = (inicio - 1); // Índice del elemento más pequeño

            for (int j = inicio; j < fin; j++) {
                // Si el elemento actual es menor o igual al pivote
                // (Cambia <= por >= para orden descendente como en el Ejercicio 8) [cite: 25]
                if (arr[j] >= pivote) {
                    i++;
                    // Intercambio (Swap) de arr[i] y arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // Colocar el pivote en su posición correcta (i + 1)
            int temp = arr[i + 1];
            arr[i + 1] = arr[fin];
            arr[fin] = temp;

            return i + 1; // Retorna la posición final del pivote
        }

        // Método para probar en el main
        public static void main(String[] args) {
            int[] datos = {3, 1, 4, 2}; // Ejemplo del Ejercicio 8
            quickSort(datos, 0, datos.length - 1);

            // Imprimir resultado
            for (int n : datos) System.out.print(n + " ");
        }
    }

