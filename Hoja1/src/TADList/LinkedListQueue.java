package TADList;


public class LinkedListQueue<E> {
	/**This variables point to the head and tail of the queue. 
	 * For efficiency reasons, the front is stored into the first node*/
	protected Node<E> front, tail;
	protected int size=-1;
	public LinkedListQueue() {
		size=0; 
		front=tail=null;
	}
	public E dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		E temp=front.item;
		front=front.next;
		size--;
		if (size==0) tail=null;
		return temp;
	}
	
	
	public void enqueue(E e) {
		Node<E> newNodo=new Node<E>(e,null);
		if (isEmpty()) front=newNodo;
		else tail.next=newNodo;
		tail=newNodo;
		size++;
	}
	public E front() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		return front.item;
	}
	public int size() { return (size); }
	public boolean isEmpty() { return (size==0); 	}
	
	
	
	
}
