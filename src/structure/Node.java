package structure;

public class Node<T> {
	protected Node<T> next;
	protected T info;

	public Node(T info) {
		this.info = info;
		this.next = null;
	}

	public Node(T info, Node<T> next) {
		this.next = next;
		this.info = info;
	}
	
	public Node() {
		this.next = null;
		this.info = null;
	}

	public Node<T> getNext() {
		return this.next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return this.info;
	}
	
	@Override
	public String toString() {
		return "Node<T> [next=" + this.next + ", info=" + this.info + "]";
	}
}
