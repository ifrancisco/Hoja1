package TADList;

import java.util.Random;

/**
 * Clase que implementa una lista simple enlazada. 
 * En esta clase, sólo se guarda la referencia al primer nodo
 * de la lista
 * @author isegura
 *
 */
public class SListTail<E> {

	/**Es el primer nodo de la lista*/
	Node<E> head;
	
	/**Es el ultimo nodo de la lista*/
	Node<E> tail;
	
	/**Guarda el número de elementos de la lista*/
	int size;
	
	/**Crea una lista vacía. Head debe ser null*/
	public SListTail() {
		head=null;
		tail=null;
		size=0;
	}
	
	
	
	
	/**
	 * Método que devuelve true si la lista está vacía
	 * y false en otro caso.
	 * Complejidad O(1)
	 * @return
	 */
	public boolean esVacia() {
		if (head==null) return true;
		else return false;
		//return (size==0);
	}
	
	/**
	 * Devuelve el número nodos de la lista
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Borra el primer elemento de la lista. 
	 * Complejidad O(1).
	 */
	public void borrarInicio() {
		if (esVacia()) {
			System.out.println("La lista ya está vacia!!!");
			return; //salimos del método
		}
		
		Node<E> oldFirst=head;
		//head debe pasar a ser el siguiente nodo. 
		head=head.next;
		//Si la lista se ha quedado vacía, entonces tail también debe ser null
		if (head==null) tail=null;
		//disminuimos el tamaño de la lista
		size--;
		oldFirst.next=null;
	}
	
	/**
	 * Borra el último nodo de la lista.
	 * Debemos recorrer la lista hasta encontrar el penúltimo nodo
	 * cuya propiedad next ahora deberá pasar a ser null 
	 * Complejidad O(n), porque el número de operaciones depende del
	 * tamaño de la lista (ya que debemos visitar sus n nodos).
	 */
	public void borrarFinal() {
		if (esVacia()) {
			System.out.println("La lista ya está vacia!!!");
			return; //salimos del método
		}
		
		Node<E> ultimo=head;
		Node<E> penultimo=null;
		//Recorremos la lista hasta encontrar el último nodo
		while (ultimo.next!=null) {
			penultimo=ultimo;
			ultimo=ultimo.next;
		}
		
		
		if (penultimo==null) {
			/*Quiere decir que la lista solo tenía un nodo.
			head debe ser null, porque estamos borrando el 
			único nodo que tenía.*/
			head=null;
			tail=null;
		} else {
			//ahora debe ser el último, y por tanto apuntar a null
			penultimo.next=null;
			tail=penultimo;
		}
		size--;
	}
	
	

	/**
	 * ESte método inserta el nodo newNodo al principio de la lista.
	 * Complejidad O(1), porque el método ejecuta un número constante de instrucciones.
	 * @param newNodo
	 */
	public  void insertarInicio(Node<E> newNodo) {
		if (newNodo==null) {
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		
		//El primer nodo actual ahora será el segundo
		newNodo.next=head;
		//Ahora hacemos que el primer nodo sea newNodo
		head=newNodo;
		//Si la lista estaba vacía, el últimoNodo debe apuntar a este único
		//y nuevo nodo
		if (tail==null) tail=newNodo;
		//Incrementamos el tamaño de la lista
		size++;
		
	}
	/**
	 * 
	 * Este método inserta el nodo newNodo al final de la lista.
	 * Complejidad O(1), porque sólo tenemos que ejecutar un número
	 * constante de instrucciones que no dependen del tamaño de la lista
	 * @param newNodo nodo a insertr
	 */
	public void insertarFinal(Node<E> newNodo) {
		if (newNodo==null) {
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		if (esVacia()) insertarInicio(newNodo);
		else {
			newNodo.next=null;
			//debemos enlazar el nuevo nodo al final de la lista
			tail.next=newNodo;
			//debemos actualizar el último nodo
			tail=newNodo;
			//incrementamos el tamaño
			size++;	
		}	
	}
	
	/**Recorre los elementos de la lista y los muestra*/
	public void show() {
		Node<E> auxiliar=head;
		while (auxiliar!=null) {
			System.out.print(auxiliar.item+",");
			auxiliar=auxiliar.next;
		}
		System.out.println();
	}
	
	
	/**
	 * El método main nos permite crear una lista
	 * @param args
	 */
	public static void main(String args[]) {
		SListTail lista=new SListTail();
		//Vamos a guardar 10 elementos
		for (int i=0; i<5; i++) {
			//Creamos un nodo con el valor i, y que su next sea null 
			Node<Integer> newNodo=new Node<Integer>(i); //También podría insertar un numero aleatorio (rnd.getInt());
			lista.insertarInicio(newNodo);
		}
		for (int i=5; i<10; i++) {
			//Creamos un nodo con el valor i, y que su next sea null 
			Node<Integer> newNodo=new Node<Integer>(i); //También podría insertar un numero aleatorio (rnd.getInt());
			lista.insertarFinal(newNodo);
		}
		
		//Mostramos la lsita
		lista.show();
		while (!lista.esVacia()) {
			lista.borrarFinal();
			if (lista.size>0) lista.show();
			lista.borrarInicio();
			if (lista.size>0) lista.show();
			System.out.println();
		}
		
	}

	}
