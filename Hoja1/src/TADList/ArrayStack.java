package TADList;
/**An array-based implementation to represent a stack * */
public class ArrayStack<E> {
	/**Array for storing the elements of the stack*/
	private E stack[];
	/**index for the top element in the stack*/
	private int top=-1;
	/**stores the actual capacity (number of elements) of the stack*/
	private  int capacity=-1;
	
	/**Constructor. Initially, it creates an array of a given size*/
	public ArrayStack(int size) {
		capacity=size;
		stack=(E[])new Object[size];
	}
	
	/**Add the element e at the top of the stack*/
	public void push(E e) {
		if (size()==capacity) {
			System.out.println("Stack is full!!!. We cannot add any new element");
			return;
		}
		top++;//increase top to store the new element at the following index
		stack[top]=e;
	}
	
	/**Returns the top element of the stack and remove it.	*/
	public E pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty. There is no top element.");
			return null;
		}
		E temp=stack[top];
		stack[top]=null;
		top--; //decrease the variable top
		return temp;
	}
	

	/**Returns the top element of the stack without remove it.	 */
	public E top() {
		if (isEmpty()) {
			System.out.println("Stack is empty. There is no top element.");
			return null;
		}
		return stack[top];
	}
	
	
	/**Returns the size of the stack*/
	public int size() { return (top+1); }
	/**Returns true if the stack is empty, eoc false*/
	public boolean isEmpty() { return (top<0); 	}
	
	
	
		
	/**This methods prints the elements of the stack*/
	public String toString() {
		if (isEmpty()) return "The Stack is empty";
		String out="[";
		for (int i=0; i<size();i++) {
			out+=stack[i]+",";
		}
		if (out.length()>1) out=out.substring(0,out.length()-1);
		out+="]";
		return out;
		
	}
	
	/**show from top */
	public void show() {
		if (isEmpty()) {
			System.out.println("The list is empty");
			return;
		}
		String strPila="(";
		for (int i=top; i>=0;i--) {
			strPila+=String.valueOf(stack[i])+",";
		}
		
		strPila=strPila.substring(0,strPila.length()-1)+")";
		System.out.println(strPila);
		
	}
	
	
	
}
