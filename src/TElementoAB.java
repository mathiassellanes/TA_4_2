public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(TElementoAB<T> elemento) {
        hijoIzq = elemento;
    }

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(TElementoAB<T> elemento) {
        hijoDer = elemento;
    }

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    @Override
    public SearchResult buscar(Comparable unaEtiqueta, int counter) {
        if (etiqueta.equals(unaEtiqueta)) {
            return new SearchResult(counter, this);
        }

        if (this.hijoIzq != null && etiqueta.compareTo(unaEtiqueta) > 0) {
            counter++;
            return this.hijoIzq.buscar(unaEtiqueta, counter);
        }

        if (this.hijoDer != null) {
            counter++;
            return this.hijoDer.buscar(unaEtiqueta, counter);
        }

        return new SearchResult(0, null);
    }

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    @Override
    public InsertResult insertar(TElementoAB<T> elemento, int counter) {
        Comparable elemEtiqueta = elemento.getEtiqueta();

        if (etiqueta.equals(elemEtiqueta)) {
            return new InsertResult(0, false);
        }

        counter++;

        if (etiqueta.compareTo(elemEtiqueta) < 0) {
            if (hijoDer != null) {
                return hijoDer.insertar(elemento, counter);
            }

            hijoDer = elemento;
        } else {
            if (hijoIzq != null) {
                return hijoIzq.insertar(elemento, counter);
            }



            hijoIzq = elemento;
        }

        return new InsertResult(counter, true);
    }

    /**
     * Imprime en preorden el arbol separado por guiones.
     *
     * @return String conteniendo el PreOrden
     */
    public String preOrden() {
        String tempStr = "";
        String separator = ", ";

        tempStr = tempStr + this.getEtiqueta();

        if (hijoIzq != null) {
            tempStr += separator + hijoIzq.preOrden();
        }

        if (hijoDer != null) {
            tempStr += separator + hijoDer.preOrden();
        }

        return tempStr;
    }

    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden() {
        String tempStr = "";
        String separator = ", ";

        if (hijoIzq != null) {
            tempStr += hijoIzq.inOrden() + separator;
        }

        tempStr += this.getEtiqueta();

        if (hijoDer != null) {
            tempStr += separator + hijoDer.inOrden();
        }

        return tempStr;
    }

    /**
     * Imprime en postorden el arbol separado por guiones.
     *
     * @return String conteniendo el PostOrden
     */
    public String postOrden() {
        String tempStr = "";
        String separator = ", ";

        if (hijoIzq != null) {
            tempStr += hijoIzq.postOrden() + separator;
        }

        if (hijoDer != null) {
            tempStr += hijoDer.postOrden() + separator;
        }

        tempStr += this.getEtiqueta();

        return tempStr;
    }

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getDatos() {
        return null;
    }

    /**
     * Elimina un elemento dada una etiqueta.
     *
     * @param unaEtiqueta
     * @return
     */
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        return null;
    }

}
