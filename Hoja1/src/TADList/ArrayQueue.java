package TADList;
public class ArrayQueue<E> {
	protected E queue[];
	protected int front=-1;
	protected int tail=-1;
	
	public ArrayQueue(int maxElem){
		queue=(E[]) new Object[maxElem];
	}
	/**Return and Remove the element at the position front*/
	public E dequeue() {
		if (isEmpty()) { 
            System.out.println("Queue is empty");
            return null;
		}
		E temp=queue [front]; 
		if (size()==1){
			front=-1;
			tail=-1;
		}else{
		front = (front + 1) % queue.length;
		}
		return temp; 
	}
	public int size() {
		if (isEmpty()) return 0;
		if (tail < front) return queue.length - front + tail + 1;
		else return tail -front + 1;
		}
	
	
	public void enqueue(E e) {
		if (front == (tail+1)%queue.length) {
			System.out.println("Queue is full");
			return;
		}
		tail = (tail + 1) % queue.length; 
		queue [tail] = e;
		if (front==-1) front++;//front 0 tail 0
        
	}
	public E front() {
		if (isEmpty()) { 
            System.out.println("Queue is empty");
            return null;
		}
		return queue [front]; 
	}
	
	public boolean isEmpty() {	return ((front==-1) && (tail==-1));	}
	
	
	/**show from front to tail */
	public void show() {
		if (isEmpty()) {
			System.out.println("The queue is empty");
			return;
		}
		String strCola="(";
		if (tail<front) {
			for (int i=front; i<queue.length;i++) {
				strCola+=String.valueOf(queue[i])+",";
			}
			for (int i=0; i<=tail;i++) {
				strCola+=String.valueOf(queue[i])+",";
			}
		} else {
			for (int i=front; i<=tail;i++) {
				strCola+=String.valueOf(queue[i])+",";
			}
		}
		
		
		strCola=strCola.substring(0,strCola.length()-1)+")";
		System.out.println(strCola);
		
	}

	
	public static void main(String args[]) {
		ArrayQueue<Integer> cola=new ArrayQueue<Integer>(5);
		for (int i=0;i<=5;i++) {
			cola.enqueue(i);
			cola.show();
		}
		for (int i=0;i<=5;i++) {
			cola.dequeue();	cola.show();
		}
		}
}

