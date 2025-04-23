
/**
 *
 * @author ernesto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManejadorArchivosGenerico mArchivos = new ManejadorArchivosGenerico();
        TArbolBB arbol1 = new TArbolBB<>();

        Comparable[] claves1 = mArchivos.leerArchivo("./src/claves1.txt");

        for (Comparable clave : claves1) {
            TElementoAB nodo = new TElementoAB<String>(clave,"graciass");
            arbol1.insertar(nodo);
        }


    }
}
