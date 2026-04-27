public class BusquedaBinaria {

    public static int busquedaBinaria(int[] arr, int a){
        int izquierda = 0;
        int derecha = arr.length - 1;
        while(izquierda <= derecha){
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arr[medio] == a){
                return medio;
            }
            if (arr[medio] < a){
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> int busquedaBinaria(T[] arr, T a){
        int izquierda = 0;
        int derecha = arr.length - 1;
        while(izquierda <= derecha){
            int medio = izquierda + (derecha - izquierda) / 2;
            int cmp = arr[medio].compareTo(a);

            if (cmp == 0){
                return medio;
            }
            if (cmp < 0){
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int buscar = 13;
        int pos = busquedaBinaria(arr, buscar);
        if (pos == -1) {
            System.out.println("El valor " + buscar + " no se encontró");
        } else {
            System.out.println("El valor " + buscar + " está en la posición " + pos);
        }

        String[] palabras = {"banana", "cereza", "kiwi", "mango", "pera"};
        String objetivo = "mango";
        int posStr = busquedaBinaria(palabras, objetivo);
        if (posStr == -1) {
            System.out.println("La palabra " + objetivo + " no se encontró");
        } else {
            System.out.println("La palabra " + objetivo + " está en la posición " + posStr);
        }
    }
}
