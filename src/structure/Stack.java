package structure;

/**
 * 
 * @author Daniel Contreras
 *
 * @param <T>
 */
public class Stack<T> extends Node<T> {
	private Node<T> top;

	public Stack() {
		this.top = null;
	}

	public void push(T info) {
		this.top = new Node<T>(info, this.top);
	}
	
//	public void push(Node<T> info) {ESTA MALL
//		this.top = info;
//	}

	public T pop() {
		if (!(this.top == null)) {
			T aux = this.top.getInfo();
			this.top = this.top.getNext();
			return aux;
		}
		return null;
	}

}
