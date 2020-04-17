package structure;
/**
 * 
 * @author Daniel Contreras
 *
 * @param <T>
 */
public class Queue<T> extends Node<T>{
	
	private Node<T> head;
	private Node<T> queue;
	
	public void push(T info) {
		if (!(this.isEmpty())) {
			this.queue.setNext( new Node<T>(info) );
			this.queue = this.queue.getNext();
		}else {
			this.head = new Node<T>(info);
			this.queue =this.head;
		}
	}
	
	public T pop() {
		if (!(this.isEmpty())) {
			T info = this.head.info;
			this.head = this.head.getNext();
			return info;
		}
		return null;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	
	
	public Node<T> getHead() {
		return head;
	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		queue.push("primero -> segundo");
		queue.push("segundo -> tercero");
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.push("tercero -> cuarto");
		queue.push("cuarto -> quinto");
		System.out.println(queue.pop());
	}

}
