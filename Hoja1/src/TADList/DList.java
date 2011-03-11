package TADList;


/**
 * Entregar a los alumnos para que peudan resolver E-7 y E-8
 * 
 * Clase que implementa una lista doble enlazada usando dos 
 * nodos centinelas que apuntan al primer y último nodo. 
 * 
 * Un centinela es un nodo especial, que no tiene un valor asociado (item), 
 * y que sirven para facilitar la programación. 
 * 
 * El centinela header con su referencia next apunta al primer elemento de la lista.
 * Su referencia prev es null
 * 
 * El centinela tailer con su referencia prev apunta al último elemento de la lista. 
 * Su referencia next es null
 * 
 *
 * @author isegura
 *
 */
public class DList<E> {
	/**Nodo centinela cuyo propiedad next apunta al primer nodo de la lista*/
	public DNode<E> header;
	/**Nodo centinela cuyo propiedad prev apunta al último nodo de la lista*/
	public DNode<E> tailer;
	public  int size;
	
	/**
	 * Crea una lista vacía. Para ello 
	 * inicializa los dos nodos centinelas
	 */
	public DList() {
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
		
		DNode<E> oldPrimero=header.next;
		//El nuevo nodo deberá apuntar al primer nodo de la lista
		newNodo.next=oldPrimero;
		oldPrimero.prev=newNodo;
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
	 * Borra el primer elemento de la lista. Complejidad O(1).
	 */
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("La lista ya está vacia!!!");
			return; //salimos del método
		}
		
		DNode<E> oldPrimero=header.next;
		DNode<E> newPrimero=oldPrimero.next;
		//primerNodo debe pasar a ser el siguiente nodo. 
		header.next=newPrimero;
		newPrimero.prev=header;
		size--;
	}

	/**
	 * Borra el último nodo de la lista. Complejidad O(1).
	 */
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("La lista ya está vacia!!!");
			return; //salimos del método
		}
		
		DNode<E> oldLast=tailer.prev;
		DNode<E> newLast=oldLast.prev;
		tailer.prev=newLast;
		newLast.next=tailer;
		size--;
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

	/**
	 * Inserta después del nodo v. Complejidad O(1)
	 * @param v
	 * @param newNodo
	 */
	public void insertAfter(DNode<E> v, DNode<E> newNodo) {
		if (v==tailer) {
			System.out.println("No puedo insert después del nodo centinela.");
			return;
		}
		DNode<E> aux=v.next;
		newNodo.next=aux;
		aux.prev=newNodo;
		newNodo.prev=v;
		v.next=newNodo;
		size++;
		
	}
	
	/**
	 * Inserta antes del nodo v
	 * Complejidad O(1)
	 * @param v
	 * @param newNodo
	 */
	public void insertBefore(DNode<E> v, DNode<E> newNodo) {
		if (v==header) {
			System.out.println("No puedo insert antes del nodo centinela.");
			return;
		}
		DNode<E> aux=v.prev;
		newNodo.prev=aux;
		aux.next=newNodo;
		newNodo.next=v;
		v.prev=newNodo;
		size++;
	}
	
	/**
	 * remove el nodo v. O(1)
	 * @param v
	 */
	public void remove(DNode<E> v) {
		if (v==header || v==tailer) {
			System.out.println("Not to remove a sentinel node.");
			return;
		}
		DNode<E> ant=v.prev;
		DNode<E> sig=v.next;
		sig.prev=ant;
		ant.next=sig;
		size--;
	}
	
//	public void show() {
//		DNode<E> aux=header.next;
//		while (aux!=tailer) {
//			System.out.println(aux.item);
//			aux=aux.next;
//		}
//	}
}
