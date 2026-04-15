public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;
    private char sexo;

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public char getSexo() { return sexo; }

    // Ordena primero por nombre alfabeticamente, si son iguales entonces por edad
    @Override
    public int compareTo(Persona otra) {
        int cmp = this.nombre.compareTo(otra.nombre);
        if (cmp != 0) return cmp;
        return Integer.compare(this.edad, otra.edad);
    }

    @Override
    public String toString() {
        return nombre + " | Edad: " + edad + " | Sexo: " + sexo;
    }
}