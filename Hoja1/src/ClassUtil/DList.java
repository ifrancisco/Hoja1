package ClassUtil;


/**
 * Entregar a los alumnos para que peudan resolver E-7 y E-8
 * 
 * Clase que implementa una lista doble enlazada usando dos 
 * nodos centinelas que apuntan al primer y �ltimo nodo. 
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
	private DNode<E> header;
	/**Nodo centinela cuyo propiedad prev apunta al último nodo de la lista*/
	private DNode<E> tailer;
	private  int size;
	
	//Getter y Setter
	public DNode<E> getHeader()
	{
		return header;
	}

	public void setHeader(DNode<E> header)
	{
		this.header = header;
	}

	public DNode<E> getTailer()
	{
		return tailer;
	}

	public void setTailer(DNode<E> tailer)
	{
		this.tailer = tailer;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}
	//\/\/\/\/Fin Getter y Setter\/\/\/\/\\
	
	/**
	 * Crea una lista vacía. Para ello 
	 * inicializa los dos nodos centinelas
	 */
	public DList() {
		header=new DNode<E>();
		tailer=new DNode<E>();
		//Se apuntan el uno al otro
		header.setNext(tailer);
		tailer.setPrev(header);
		size=0;
	}
	
	/**
	 * Devuelve true si la lista está vacía, false en otro caso.
	 * @return
	 */
	public boolean esVacia() {
		return (size==0);
	}
	
	
	/**
	 * ESte método inserta el nodo newNodo al principio de la lista.
	 * Complejidad O(1), porque el método ejecuta un número constante de instrucciones.
	 * @param newNodo
	 */
	public  void insertarInicio(DNode<E> newNodo) {
		if (newNodo==null) {
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		
		DNode<E> oldPrimero=header.getNext();
		//El nuevo nodo deberá apuntar al primer nodo de la lista
		newNodo.setNext(oldPrimero);
		oldPrimero.setPrev(newNodo);
		//Ahora hacemos que el primer nodo sea newNodo
		header.setNext(newNodo);
		newNodo.setPrev(header);
		
		//Incrementamos el tamaño de la lista
		size++;
		
	}
	
	/**
	 * ESte método inserta el nodo newNodo al final de la lista.
	 * Complejidad O(1), porque el método ejecuta un número constante de instrucciones.
	 * @param newNodo
	 */
	public  void insertarFinal(DNode<E> newNodo) {
		if (newNodo==null) {
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		
		DNode<E> oldUltimo=tailer.getPrev();
		oldUltimo.setNext(newNodo);
		newNodo.setPrev(oldUltimo);
		newNodo.setNext(tailer);
		tailer.setPrev(newNodo);
		
		//Incrementamos el tamaño de la lista
		size++;
		
	}
	
	
	/**
	 * Borra el primer elemento de la lista. 
	 * Complejidad O(1).
	 */
	public void borrarPrimerNodo() {
		if (esVacia()) {
			System.out.println("La lista ya está vacia!!!");
			return; //salimos del método
		}
		
		DNode<E> oldPrimero=header.getNext();
		DNode<E> newPrimero=oldPrimero.getNext();
		//primerNodo debe pasar a ser el siguiente nodo. 
		header.setNext(newPrimero);
		newPrimero.setPrev(header);
		size--;
	}

	/**
	 * Borra el último nodo de la lista. 
	 * Complejidad O(1).
	 */
	public void borrarFinal() {
		if (esVacia()) {
			System.out.println("La lista ya está vacia!!!");
			return; //salimos del método
		}
		
		DNode<E> oldUltimo=tailer.getPrev();
		DNode<E> newUltimo=oldUltimo.getPrev();
		tailer.setPrev(newUltimo);
		newUltimo.setNext(tailer);
		size--;
	}
	
	
	/**Recorre los elementos de la lista y los muestra*/
	public void show() {
		DNode<E> auxiliar=header.getNext();
		while (auxiliar.getNext()!=null) {
			System.out.print(auxiliar.getItem()+",");
			auxiliar=auxiliar.getNext();
		}
		System.out.println();
	}

	

	
	/**
	 * Inserta después del nodo v
	 * Complejidad O(1)
	 * @param v
	 * @param newNodo
	 */
	public void insertarDespues(DNode<E> v, DNode<E> newNodo) {
		if (v==tailer) {
			System.out.println("No puedo insertar después del nodo centinela.");
			return;
		}
		DNode<E> aux=v.getNext();
		
		newNodo.setNext(aux);
		aux.setPrev(newNodo);
		
		newNodo.setPrev(v);
		v.setNext(newNodo);
		
	}
	
	/**
	 * Inserta antes del nodo v
	 * Complejidad O(1)
	 * @param v
	 * @param newNodo
	 */
	public void insertarAntes(DNode<E> v, DNode<E> newNodo) {
		if (v==header) {
			System.out.println("No puedo insertar antes del nodo centinela.");
			return;
		}
		
		DNode<E> aux=v.getPrev();
		
		
		newNodo.setPrev(aux);
		aux.setNext(newNodo);
		
		newNodo.setNext(v);
		v.setPrev(newNodo);
		
	}
	
	/**
	 * Borrar el nodo v
	 * O(1)
	 * @param v
	 */
	public void borrar(DNode<E> v) {
		if (v==header || v==tailer) {
			System.out.println("No puedo borrar un nodo centinela.");
			return;
		}
		DNode<E> ant=v.getPrev();
		DNode<E> sig=v.getNext();
		sig.setPrev(ant);
		ant.setNext(sig);
		
		
	}
}
