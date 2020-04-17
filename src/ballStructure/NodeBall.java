package ballStructure;

/**
 * 
 * @author Daniel Felipe Contreras Lopez
 * @author daniel.contreras@uptc.edu.co
 * @author cldfrkr@hotmail.com
 * @param <T>
 */
public class NodeBall<T> {
	protected NodeBall<T> next;
	protected T info;

	/**
	 * Crea un nodo. Con un nodo siguiente nulo
	 * 
	 * @param info
	 *            Tipo T
	 */
	public NodeBall(T info) {
		this.info = info;
		this.next = null;
	}

	/**
	 * Crea un nodo. Con un nodo sigueinte existente
	 * 
	 * @param info
	 *            Tipo T
	 * @param next
	 *            Tipo Node T, ya existente
	 */
	public NodeBall(T info, NodeBall<T> next) {
		this.next = next;
		this.info = info;
	}

	/**
	 * Crea un nodo vacio
	 */
	public NodeBall() {
		this.next = null;
		this.info = null;
	}

	/**
	 * Retorna el nodo siguiente al nodo actual
	 * 
	 * @return Node T
	 */
	public NodeBall<T> getNext() {
		return this.next;
	}

	/**
	 * Agrega un nodo siguiente al nodo actual
	 * 
	 * @param next
	 *            Tipo Node T
	 */
	public void setNext(NodeBall<T> next) {
		this.next = next;
	}

	/**
	 * Retorna el nodo actual
	 * 
	 * @return Tipo T
	 */
	public T getInfo() {
		return this.info;
	}

}
