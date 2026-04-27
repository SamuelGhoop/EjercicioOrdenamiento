import java.util.HashMap;
import java.util.Map;

public class Taller2 {

    public static boolean balanceados(String s){
        return balanceados(s, 0, 0);
    }

    private static boolean balanceados(String s, int i, int abiertos){
        if (i == s.length()) return abiertos == 0;
        char c = s.charAt(i);
        if (c == '(') return balanceados(s, i + 1, abiertos + 1);
        if (c == ')'){
            if (abiertos == 0) return false;
            return balanceados(s, i + 1, abiertos - 1);
        }
        return balanceados(s, i + 1, abiertos);
    }

    public static void main(String[] args) {
        String[] pruebas = {"(())()", "(()", "())", "()()", "", "((()))"};
        for (String p : pruebas){
            System.out.println("'" + p + "' -> " + balanceados(p));
        }

        // Llamada inicial: prefijo vacío y "ab" como caracteres por colocar.
        permutacion("", "ab");

        // Prueba del ejercicio 10: ordenar por frecuencia (mayor a menor).
        int[] datos = {4, 4, 1, 2, 2, 2, 3};
        problem10(datos);
        System.out.print("Ordenado por frecuencia: [");
        for (int x = 0; x < datos.length; x++){
            System.out.print(datos[x] + (x < datos.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    // Genera todas las permutaciones de "restante" anteponiendo "prefijo".
    // prefijo  -> los caracteres ya elegidos (en orden).
    // restante -> los caracteres que aún faltan por colocar.
    private static void permutacion(String prefijo, String restante){
        // Caso base: si no queda nada por colocar, ya formamos una permutación completa.
        if (restante.isEmpty()){
            System.out.println(prefijo);
            return;
        }

        // Recorremos cada caracter de "restante" para probar ponerlo como siguiente.
        for (int i = 0; i < restante.length(); i++){
            // ch es el caracter que vamos a "elegir" en esta rama de la recursión.
            char ch = restante.charAt(i);

            // nuevoRestante = restante sin el caracter de la posición i.
            // Lo armamos pegando la parte de antes de i con la parte después de i.
            String nuevoRestante = restante.substring(0, i) + restante.substring(i + 1);

            // Llamada recursiva: agregamos ch al prefijo y seguimos con los que quedan.
            permutacion(prefijo + ch, nuevoRestante);
        }
    }

    // Ordena el arreglo según la frecuencia (de mayor a menor) usando merge sort.
    public static void problem10(int[] arreglo){
        // 1) Contamos cuántas veces aparece cada valor con un HashMap.
        Map<Integer, Integer> frecuencia = new HashMap<>();
        for (int valor : arreglo){
            frecuencia.put(valor, frecuencia.getOrDefault(valor, 0) + 1);
        }

        // 2) Llamamos al merge sort que usa el mapa para comparar.
        mergeSortFrecuencia(arreglo, 0, arreglo.length - 1, frecuencia);
    }

    // Merge sort recursivo: divide el arreglo en mitades hasta tener trozos de 1 elemento.
    private static void mergeSortFrecuencia(int[] arreglo, int inicio, int fin, Map<Integer, Integer> frecuencia){
        // Caso base: si el rango tiene 0 o 1 elementos, ya está ordenado.
        if (inicio >= fin) return;

        int medio = inicio + (fin - inicio) / 2;
        // Ordenamos la mitad izquierda y la mitad derecha por separado.
        mergeSortFrecuencia(arreglo, inicio, medio, frecuencia);
        mergeSortFrecuencia(arreglo, medio + 1, fin, frecuencia);
        // Mezclamos las dos mitades ya ordenadas en una sola.
        merge(arreglo, inicio, medio, fin, frecuencia);
    }

    // Mezcla dos sub-arreglos contiguos: [inicio..medio] y [medio+1..fin].
    private static void merge(int[] arreglo, int inicio, int medio, int fin, Map<Integer, Integer> frecuencia){
        // Copiamos el rango actual a un arreglo temporal para tener "fuente" estable.
        int[] temp = new int[fin - inicio + 1];
        for (int k = 0; k < temp.length; k++) temp[k] = arreglo[inicio + k];

        int i = 0;                       // índice en la mitad izquierda del temp
        int j = medio - inicio + 1;      // índice en la mitad derecha del temp
        int finIzq = medio - inicio;     // último índice de la mitad izquierda dentro de temp
        int k = inicio;                  // posición donde escribimos en el arreglo original

        // Mientras queden elementos en ambas mitades, elegimos el "mayor" según frecuencia.
        while (i <= finIzq && j < temp.length){
            int freqI = frecuencia.get(temp[i]);
            int freqJ = frecuencia.get(temp[j]);

            // Mayor frecuencia primero. Si empatan, mantenemos el orden de aparición (estable).
            if (freqI >= freqJ){
                arreglo[k++] = temp[i++];
            } else {
                arreglo[k++] = temp[j++];
            }
        }
        // Copiamos lo que sobre de la mitad izquierda (si quedó algo).
        while (i <= finIzq) arreglo[k++] = temp[i++];
        // Copiamos lo que sobre de la mitad derecha (si quedó algo).
        while (j < temp.length) arreglo[k++] = temp[j++];
    }

}
