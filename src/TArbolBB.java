public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operacián
     */

    @Override
    public InsertResult insertar(TElementoAB<T> unElemento) {
        if (raiz == null) {

            raiz = unElemento;

            return new InsertResult(0, true);
        }

        InsertResult insercion = raiz.insertar(unElemento, 0);

        return insercion;
    }

    /**
     * Busca un elemento dentro del árbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     *                    .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public SearchResult buscar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return null;
        }

        return raiz.buscar(unaEtiqueta, 0);
    }

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden() {
        if (raiz == null) {
            return "";
        }
        return raiz.preOrden();
    }

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden() {
        if (raiz == null) {
            return "";
        }
        return raiz.inOrden();
    }

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String postOrden() {
        if (raiz == null) {
            return "";
        }

        return raiz.postOrden();
    }

    /**
     * Elimina un elemento dada una etiqueta.
     *
     * @param unaEtiqueta
     */
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

}
