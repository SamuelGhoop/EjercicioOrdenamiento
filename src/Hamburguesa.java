import java.util.ArrayList;
import java.util.Objects;

// Clase Hamburguesa: representa una hamburguesa con código, valor y nombre.
// Implementa Comparable para poder ordenarse por precio (valor).
public class Hamburguesa implements Comparable<Hamburguesa> {

    // Atributos privados (encapsulamiento)
    private int codigo;      // Identificador único de la hamburguesa
    private float valor;     // Precio de la hamburguesa
    private String nombre;   // Nombre de la hamburguesa

    // Constructor: inicializa los atributos al crear una Hamburguesa
    public Hamburguesa(int codigo, float valor, String nombre) {
        this.codigo = codigo;
        this.valor = valor;
        this.nombre = nombre;
    }
    // toString: representación en texto de la hamburguesa (útil para imprimir)
    @Override
    public String toString() {
        return "Hamburguesa{codigo=" + codigo + ", nombre='" + nombre + "', valor=" + valor + "}";
    }

    // equals: define cuándo dos hamburguesas son "iguales".
    // Aquí se consideran iguales si comparten el mismo código.
    @Override
    public boolean equals(Object o) {
        // Si el objeto es null o de otra clase, no son iguales
        if (o == null || getClass() != o.getClass()) return false;
        // Casteamos a Hamburguesa para poder comparar su atributo código
        Hamburguesa that = (Hamburguesa) o;
        return codigo == that.codigo;
    }

    // hashCode: genera un número hash basado en el código.
    // Debe ser coherente con equals (si equals es true, hashCode debe coincidir).
    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    // compareTo: define el orden natural de las hamburguesas según su precio.
    // Retorna  1 si esta hamburguesa es más cara que la otra,
    //         -1 si es más barata,
    //          0 si tienen el mismo valor.
    public int compareTo(Hamburguesa o) {
        if(this.valor > o.valor) return 1;
        else if(this.valor < o.valor) return -1;
        else return 0;

    }

    // Metodo que inserta una hamburguesa en la lista manteniendo el orden por precio.
    // Usa compareTo (de Comparable) para encontrar la posición correcta.
    public static void agregarOrdenada(ArrayList<Hamburguesa> lista, Hamburguesa nueva) {
        // Recorremos la lista buscando la primera hamburguesa más cara que "nueva"
        for (int i = 0; i < lista.size(); i++) {
            // Si la nueva es más barata (o igual) que la de la posición i, se inserta ahí
            if (nueva.compareTo(lista.get(i)) < 0) {
                lista.add(i, nueva);
                return;
            }
        }
        // Si no se insertó antes, es la más cara: va al final
        lista.add(nueva);
    }

    // Metodo main: punto de entrada para probar la clase
    public static void main(String[] args) {
        // Creamos una lista de hamburguesas
        ArrayList<Hamburguesa> lista = new ArrayList<>();

        // Insertamos varias hamburguesas usando el metodo agregarOrdenada.
        // Observa que no importa el orden en que las añadimos:
        // la lista siempre queda ordenada por precio (de menor a mayor).
        agregarOrdenada(lista, new Hamburguesa(1, 15000f, "Sencilla"));
        agregarOrdenada(lista, new Hamburguesa(2, 25000f, "Doble Queso"));
        agregarOrdenada(lista, new Hamburguesa(3, 10000f, "Vegetariana"));
        agregarOrdenada(lista, new Hamburguesa(4, 30000f, "BBQ Especial"));
        agregarOrdenada(lista, new Hamburguesa(5, 20000f, "Pollo Crispy"));

        // Imprimimos la lista resultante para verificar el orden por precio
        System.out.println("Hamburguesas ordenadas por precio:");
        for (Hamburguesa h : lista) {
            System.out.println(h);
        }
    }
}