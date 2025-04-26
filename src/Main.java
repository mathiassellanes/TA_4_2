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
    
        String[] claves = mArchivos.leerArchivo("src\\claves1.txt");
        String[] resultados = new String[claves.length];
    
        for (int i = 0; i < claves.length; i++) {
            TElementoAB<String> nodo = new TElementoAB<>(claves[i], "valor");
            boolean insertado = arbol1.insertar(nodo);
            resultados[i] = claves[i] + " " + (insertado ? i + 1 : 0);
        }
    
        mArchivos.escribirArchivo("./src/output.txt", resultados);
        
        String[] consultas = mArchivos.leerArchivo("src\\consultaPrueba.txt");
        String[] resultadosConsultas = new String[consultas.length];

        for (int i = 0; i < consultas.length; i++) {
            TElementoAB<String> resultado = arbol2.buscar(consultas[i]);
            resultadosConsultas[i] = consultas[i] + " " + (resultado != null ? i + 1 : -(i + 1));
        }

        mArchivos.escribirArchivo("./src/consultas_output.txt", resultadosConsultas);
    }
}