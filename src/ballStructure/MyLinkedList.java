package ballStructure;

/**
 * 
 * @author Daniel Felipe Contreras Lopez
 * @author daniel.contreras@uptc.edu.co
 * @author cldfrkr@hotmail.com
 * @param <T>
 */
public class MyLinkedList<T> {
	private NodeBall<T> head;

	/**
	 * Agrega un nodo ya existente al final de la lista
	 * 
	 * @param node
	 *            Nodo Tipo T
	 */
	public void add(NodeBall<T> node) {
		if (this.head != null) {
			NodeBall<T> currentNode = this.head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		} else {
			this.head = node;
		}
	}

	/**
	 * Agrega un nuevo nodo al final de la lista
	 * 
	 * @param info
	 *            Tipo T
	 */
	public void add(T info) {
		if (this.head != null) {
			NodeBall<T> currentNode = this.head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(new NodeBall<T>(info));
		} else {
			this.head = new NodeBall<T>(info);
		}
	}

	/**
	 * Busca por nodo y regresa Verdadero si exite
	 * 
	 * @param node
	 *            Nodo Tipo T
	 * @return Boolean
	 */
	public boolean search(NodeBall<T> node) {
		NodeBall<T> currentNode = this.head;
		while (currentNode != null) {
			if (currentNode.equals(node)) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}

	/**
	 * Busca por la informacio y regresa un Nodo si existe
	 * 
	 * @param data
	 *            Tipo T
	 * @return Nodo T
	 * @throws Exception
	 *             element not fount
	 */
	public NodeBall<T> search(T data) throws Exception {
		NodeBall<T> currentNode = this.head;
		while (currentNode != null) {
			if (currentNode.getInfo().equals(data)) {
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		throw new Exception("element not fount");
	}

	/**
	 * Borra un Nodo tipo Nodo T
	 * 
	 * @param node
	 *            Nodo T
	 */
	public void delete(NodeBall<T> node) {
		if (node != this.head) {
			NodeBall<T> currentNode = this.head;
			while (currentNode.getNext() != null) {
				if (currentNode.getNext() == node) {
					currentNode.setNext(node.getNext());
					node = null;
					return;
				}
				currentNode = currentNode.getNext();
			}
		} else {
			this.head = this.head.getNext();
		}
	}

	/**
	 * Borra un nodo basado en la informacion
	 * 
	 * @param info
	 *            Tipo T
	 */
	public void delete(T info) {
		if (this.head.getInfo() != info) {
			NodeBall<T> currentNode = this.head;
			while (currentNode.getNext() != null) {
				if (currentNode.getNext().getInfo() == info) {
					currentNode.setNext(currentNode.getNext().getNext());
					return;
				}
				currentNode = currentNode.getNext();
			}
		} else {
			this.head = this.head.getNext();
		}
	}

	/**
	 * Inserta un nodo entre dos nodos
	 * 
	 * @param node
	 *            Nodo Tipo T en la lista
	 * @param newNode
	 *            Nodo Tipo T para insertar
	 */
	public void insert(NodeBall<T> node, NodeBall<T> newNode) {
		if (this.search(node)) {
			newNode.setNext(node.getNext());
			node.setNext(newNode);
		}
	}

	/**
	 * Vacia toda la lista, verdadero para borrar
	 * 
	 * @param clear
	 *            True borra
	 */
	public void clear(boolean clear) {
		if (clear) {
			this.head = null;
		}
	}

	public NodeBall<T> getHead() {
		return head;
	}
}
