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
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (etiqueta.equals(unaEtiqueta)) {
            return this;
        }

        if (this.hijoIzq != null && etiqueta.compareTo(unaEtiqueta) > 0) {
            return this.hijoIzq.buscar(unaEtiqueta);
        }

        if (this.hijoDer != null) {
            return this.hijoDer.buscar(unaEtiqueta);
        }

        return null;
    }

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    @Override
    public boolean insertar(TElementoAB<T> elemento, int counter) {
        Comparable elemEtiqueta = elemento.getEtiqueta();

        if (etiqueta == elemEtiqueta) {
            System.out.println(counter);
            return false;
        }

        counter++;

        if (etiqueta.compareTo(elemEtiqueta) > 0) {
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
    
        System.out.println(counter);
        return true;
    }

    /**
     * Imprime en preorden el arbol separado por guiones.
     *
     * @return String conteniendo el PreOrden
     */
    public String preOrden() {
        String tempStr = "";

        tempStr = tempStr + this.getEtiqueta();

        if (hijoDer != null) {
            tempStr = hijoDer.preOrden();
        }

        if (hijoIzq != null) {
            tempStr = hijoIzq.preOrden();
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

        if (hijoDer != null) {
            tempStr = hijoDer.inOrden();
        }

        tempStr = tempStr + this.getEtiqueta();

        if (hijoIzq != null) {
            tempStr = hijoIzq.inOrden();
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

        if (hijoDer != null) {
            tempStr = hijoDer.postOrden();
        }

        if (hijoIzq != null) {
            tempStr = hijoIzq.postOrden();
        }

        tempStr = tempStr + this.getEtiqueta();

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
