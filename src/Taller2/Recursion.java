package Taller2;

public class Recursion {

    // indice
    // salida
    // constructor de numeros
    // suma
    // return


    public static int Punto1(String s, int i, String builder, int suma) {

        //salidas
        if (s.isEmpty()) return -1;

        if (i == s.length()) {
            if (!builder.isEmpty()) suma += Integer.parseInt(builder);
            return suma;
        }

        if (Character.isDigit(s.charAt(i))) {
            builder += s.charAt(i);
        } else if (!builder.isEmpty()) {
            suma += Integer.parseInt(builder);
            builder = "";
        }

        return Punto1(s, i + 1, builder, suma);

    }

    public static void Punto3(int[] arr, int i, String actual) {
        // EL REPOSO (Caso Base): Cuando ya recorrimos todo el camino
        if (i == arr.length) {
            System.out.println("[" + actual + "]"); // Aquí se manifiesta el subconjunto
            return;
        }

        // EL CAMINO DE LA OMISIÓN: No incluimos el número actual
        // Pasamos al siguiente (i + 1) y el mensaje (actual) sigue igual
        Punto3(arr, i + 1, actual);

        // EL CAMINO DE LA ACCIÓN: Sí incluimos el número en nuestro grupo
        // Si ya hay algo, ponemos una coma para el orden; si no, solo el número
        String conElemento = actual.isEmpty() ? String.valueOf(arr[i]) : actual + "," + arr[i];
        Punto3(arr, i + 1, conElemento);
    }





    public static void main(String[] args) {
        System.out.println(Recursion.Punto1("123asda1", 0, "", 0));
        int[] entrada = {1, 2}; // Los datos del ejercicio
        Punto3(entrada, 0, "");
    }
}


