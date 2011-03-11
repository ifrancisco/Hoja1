package TADList;


/**
 * Dqueue implementada como una lista doble enlazada.
 * Dqueue vs DList
 * 1) Dqueue no tiene los métodos remove, insertAfter, insertBefore.
 * 2) En Dqueue los métodos removeFirst y removeLast deben devolver el valor del Nodo, 
 * mientras que en DList  estos métodos no devuelve nada.
 * @author isegura
 */
public class DQueue<E> {
	/**Nodo centinela cuyo propiedad next apunta al primer nodo de la lista*/
	public DNode<E> header;
	/**Nodo centinela cuyo propiedad prev apunta al último nodo de la lista*/
	public DNode<E> tailer;
	public  int size;
	
	/**
	 * Crea una lista vacía. Para ello 
	 * inicializa los dos nodos centinelas
	 */
	public DQueue() {
		header=new DNode<E>();
		tailer=new DNode<E>();
		//Se apuntan el uno al otro
		header.next=tailer;
		tailer.prev=header;
		size=0;
	}
	
	/**
	 * Devuelve true si la lista está vacía, false en otro caso.
	 * @return
	 */
	public boolean isEmpty() {
		return (size==0);
	}
	
	
	/**
	 * ESte método inserta el nodo newNodo al principio de la lista.
	 * Complejidad O(1), porque el método ejecuta un número constante de instrucciones.
	 * @param newNodo
	 */
	public  void insertFirst(DNode<E> newNodo) {
		if (newNodo==null) {
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		
		DNode<E> oldFirst=header.next;
		//El nuevo nodo deberá apuntar al primer nodo de la lista
		newNodo.next=oldFirst;
		oldFirst.prev=newNodo;
		//Ahora hacemos que el primer nodo sea newNodo
		header.next=newNodo;
		newNodo.prev=header;
		
		//Incrementamos el tamaño de la lista
		size++;
		
	}
	
	/**
	 * ESte método inserta el nodo newNodo al final de la lista.
	 * Complejidad O(1), porque el método ejecuta un número constante de instrucciones.
	 * @param newNodo
	 */
	public  void insertLast(DNode<E> newNodo) {
		if (newNodo==null) {
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		
		DNode<E> oldLast=tailer.prev;
		oldLast.next=newNodo;
		newNodo.prev=oldLast;
		newNodo.next=tailer;
		tailer.prev=newNodo;
		
		//Incrementamos el tamaño de la lista
		size++;
		
	}
	
	
	/**
	 * Borra el primer elemento de la lista. 
	 * Complejidad O(1).
	 */
	public E removeFirst() {
		if (isEmpty()) {
			System.out.println("La lista ya está vacia!!!");
			return null; //salimos del método
		}
		
		DNode<E> oldFirst=header.next;
		E value=oldFirst.item;
		DNode<E> newPrimero=oldFirst.next;
		//primerNodo debe pasar a ser el siguiente nodo. 
		header.next=newPrimero;
		newPrimero.prev=header;
		size--;
		return value;
	}

	/**
	 * Borra el último nodo de la lista. 
	 * Complejidad O(1).
	 */
	public E removeLast() {
		if (isEmpty()) {
			System.out.println("La lista ya está vacia!!!");
			return null; //salimos del método
		}
		
		DNode<E> oldLast=tailer.prev;
		E value=oldLast.item;
		DNode<E> newLast=oldLast.prev;
		tailer.prev=newLast;
		newLast.next=tailer;
		size--;
		return value;
	}
	
	
	/**Recorre los elementos de la lista y los muestra*/
	public void show() {
		DNode<E> auxiliar=header.next;
		while (auxiliar!=tailer) {
			System.out.print(auxiliar.item+",");
			auxiliar=auxiliar.next;
		}
		System.out.println();
	}

	
	
	
	
}
