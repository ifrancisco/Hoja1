package TADList;
/**A linked list-based implementation of a stack. 
 * The top element of stack is stored at the beginning of the list*/
public class LinkedListStack<E>  {
	/**This variable stores the reference to the top element of the stack*/
	protected Node<E> top;
	/**Stores the number of elements of the stack*/
	protected int size=-1;
		
	/**Constructor. It creates an empty stack*/
	public LinkedListStack() {
		size=0;
		top=null;
	}
	public E pop(){
		if (isEmpty()) {
			System.out.println("Stack is empty. There is no top element.");
			return null;
		}
		E temp=top.item;
		top=top.next;
		size--;
		return temp;
	}
	/**Returns the top element of the stack without remove it.*/
	public E top() {
		if (isEmpty()) {
			System.out.println("Stack is empty. There is no top element.");
			return null;
		}
		return top.item;
	}
	
	/**Add the element e at the top of the stack*/
	public void push(E e) {
		Node<E> newNode=new Node<E>(e,top);
		top=newNode;
		size++;
	}
	/**Returns the size of the stack*/
	public int size() { return (size); }
	/**Returns true if the stack is empty, eoc false*/
	public boolean isEmpty() { return (size<=0); 	}
	/**Returns the top element of the stack and remove it.	 */
		
	/**This methods prints the elements of the stack*/
	public String toString() {
		if (isEmpty()) return "The Stack is empty";
		String out="";
		Node<E> aux=top;
		while (aux!=null) {
			out+=aux.item+",";
			aux=aux.next;
		}
		if (out.length()>1) out=out.substring(0,out.length()-1);
		//Reverse the string
		int i, len = out.length();
		StringBuffer dest = new StringBuffer(len);
		for (i = (len - 1); i >= 0; i--)
		      dest.append(out.charAt(i));
		    
		out="["+dest+"]";
		
		return out;
		
	}
	
	
	
	
	
	
	public static void main(String args[]) {
		ArrayStack<Character> oStackChar=new ArrayStack<Character>(10);
		oStackChar.push('h');
		System.out.println(oStackChar.toString());
		oStackChar.push('e');
		System.out.println(oStackChar.toString());
		oStackChar.push('l');
		System.out.println(oStackChar.toString());
		oStackChar.push('l');
		System.out.println(oStackChar.toString());
		oStackChar.push('o');
		System.out.println(oStackChar.toString());
		oStackChar.push('!');
		System.out.println(oStackChar.toString());
		oStackChar.pop();
		System.out.println(oStackChar.toString());
		
	}
}
