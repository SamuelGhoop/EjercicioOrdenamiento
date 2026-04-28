package Taller2;

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
}
