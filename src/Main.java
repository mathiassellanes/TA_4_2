import java.io.Console;

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
        TArbolBB<String> arbol1 = new TArbolBB<>();
        TArbolBB<String> arbol2 = new TArbolBB<>();

        String[] claves = mArchivos.leerArchivo("src/claves1.txt");
        String[] resultados = new String[claves.length];

        for (int i = 0; i < claves.length; i++) {
            TElementoAB<String> nodo = new TElementoAB<>(Integer.parseInt(claves[i]), "valor");
            InsertResult insertado = arbol1.insertar(nodo);
            resultados[i] = claves[i] + " " + (insertado.counter);
        }

        mArchivos.escribirArchivo("./src/output.txt", resultados);

        String[] consultas = mArchivos.leerArchivo("src/consultaPrueba.txt");
        String[] resultadosConsultas = new String[consultas.length];

        for (int i = 0; i < consultas.length; i++) {
            TElementoAB<String> nodo = new TElementoAB<>(Integer.parseInt(consultas[i]), "valor");
            arbol2.insertar(nodo);
        }

        for (int i = 0; i < consultas.length; i++) {
            SearchResult<String> resultado = arbol2.buscar(Integer.parseInt(consultas[i]));

            resultadosConsultas[i] = consultas[i] + " " + (resultado.inserted != null ? resultado.counter : -resultado.counter);
        }

        mArchivos.escribirArchivo("./src/consultas_output.txt", resultadosConsultas);

        System.out.println(arbol2.preOrden());
        System.out.println(arbol2.inOrden());
        System.out.println(arbol2.postOrden());
    }
}
