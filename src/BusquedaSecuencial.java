public class BusquedaSecuencial {
    public static int BusquedaSecuencial(int[] v, int busqueda){
        int index = -1;
        for (int i = 0; i < v.length; i++){
            if (v[i] == busqueda){
                index = i;
                return index;
            }
        }
        return index;
    }

    public static int Mejorado(int[] v, int busqueda){
        boolean find = false;
        int index =1;
        int i =0;
        while(i<v.length && !find){
            if (v[i]==busqueda) index=i; find = true;
        }
        i++;
        return index;
    }

    public static boolean EncontrarSuma(int[] v, int busqueda){
        for (int i=0; i < v.length; i++){
            for (int j= i+1; j < v.length;j++){
                if (v[i]+v[j] == busqueda) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] v = new int[] {1,2,3,4,5,6,7,8};
        int busqueda =7;
        System.out.println(EncontrarSuma(v,busqueda));
    }
}
