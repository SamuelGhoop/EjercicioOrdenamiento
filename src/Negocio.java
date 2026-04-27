public class Negocio {
    private Hamburguesa[] hamburguesas;

    public void AgregarHamburguesa(Hamburguesa hamburguesa){
        int libre = -1;
        for (int i = 0; i < hamburguesas.length; i++){
            if (hamburguesas[i] == null){
                if (libre == -1) libre = i;
                continue;
            }
            if (hamburguesa.equals(hamburguesas[i])){
                System.out.println("La hamburguesa no se pudo crear: id ya existe");
                return;
            }
        }
        if (libre == -1){
            System.out.println("La hamburguesa no se pudo crear: arreglo lleno");
            return;
        }
        hamburguesas[libre] = hamburguesa;
    }
}
