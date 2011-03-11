package Ejercicio9;

/**
 * Clase que implementa una lista simple enlazada. En esta clase, sólo se
 * guarda la referencia al primer nodo de la lista
 * 
 * @author isegura
 * 
 */
public class SListCircular<E>
{

	/** Es el primer nodo de la lista */
	private Node<Integer> head;
	/** Guarda el número de elementos de la lista */
	private int size;

	// Inicio Getters & Setters
	public Node<Integer> getHead()
	{
		return head;
	}

	public void setHead(Node<Integer> head)
	{
		this.head = head;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	/**
	 * Devuelve el numero nodos de la lista
	 * 
	 * @return
	 */
	public int getSize()
	{
		return size;
	}

	// Fin Getters & Setters
	/** Crea una lista vacía. Head debe ser null */
	public SListCircular()
	{
		head = new Node<Integer>();
		head.setNext(head);
		size = 0;
	}

	/**
	 * Método que devuelve true si la lista está vacía y false en otro caso.
	 * Complejidad O(1)
	 * 
	 * @return
	 */
	public boolean esVacia()
	{
		if (getSize() == 0)
			return true;
		else
			return false;
		// return (size==0);
	}

	/**
	 * Borra el primer elemento de la lista. Complejidad O(1).
	 */
	public void borrarInicio()
	{
		if (esVacia())
		{
			System.out.println("La lista ya esta vacia!!!");
			return; // salimos del metodo
		}
		if (head.getNext() != head)
		{
			Node<Integer> oldFirst = head.getNext();
			// head debe pasar a ser el siguiente nodo.
			head.setNext(oldFirst.getNext());
			// disminuimos el tamaño de la lista
			size--;
		}
	}

	/**
	 * Borra el último nodo de la lista. Debemos recorrer la lista hasta
	 * encontrar el penúltimo nodo cuya propiedad next ahora deberá pasar a
	 * ser null Complejidad O(n), porque el número de operaciones depende del
	 * tamaño de la lista (ya que debemos visitar sus n nodos).
	 */
	public void borrarFinal()
	{
		if (esVacia())
		{
			System.out.println("La lista ya esta vacia!!!");
			return; // salimos del método
		}

		Node<Integer> ultimo = head;
		Node<Integer> penultimo = null;
		// Recorremos la lista hasta encontrar el último nodo
		while (ultimo.getNext() != head)
		{
			penultimo = ultimo;
			ultimo = ultimo.getNext();
		}

		if (penultimo == null)
		{
			/*
			 * Quiere decir que la lista solo tenía un nodo. head debe ser
			 * null, porque estamos borrando el único nodo que tenía.
			 */
			head.setNext(head);
		} else
		{
			// ahora debe ser el último, y por tanto apuntar a null
			penultimo.setNext(head);
		}
		size--;
	}

	/**
	 * ESte método inserta el nodo newNodo al principio de la lista.
	 * Complejidad O(1), porque el método ejecuta un número constante de
	 * instrucciones.
	 * 
	 * @param newNodo
	 */
	public void insertarInicio(Node<Integer> newNodo)
	{
		if (newNodo == null)
		{
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; // salimos del método
		}
		// El primer nodo actual ahora sera el segundo
		newNodo.setNext(head.getNext());
		// Ahora hacemos que el primer nodo sea newNodo
		head.setNext(newNodo);
		// Incrementamos el tamaño de la lista
		size++;
	}

	/**
	 * 
	 * Este metodo inserta el nodo newNodo al final de la lista. Complejidad
	 * O(1), porque solo tenemos que ejecutar un numero constante de
	 * instrucciones que no dependen del tama�o de la lista
	 * 
	 * @param newNodo
	 *            nodo a insertr
	 */
	public void insertarFinal(Node<Integer> newNodo)
	{
		if (newNodo == null)
		{
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; // salimos del método
		}
		if (esVacia())
			insertarInicio(newNodo);
		else
		{
			Node<Integer> aux = head;
			while (aux.getNext() != head)
			{
				aux = aux.getNext();
			}
			aux.setNext(newNodo);
			newNodo.setNext(head);
			// incrementamos el tamaño
			size++;
		}
	}

	/** Recorre los elementos de la lista y los muestra */
	public void show()
	{
		Node<Integer> auxiliar = head;
		while (auxiliar.getNext() != head)
		{
			if (auxiliar != head)
			{
				System.out.print(auxiliar.getItem() + ",");
			}
			auxiliar = auxiliar.getNext();
		}
		System.out.print(auxiliar.getItem());
		System.out.println();
	}

	/**
	 * El método main nos permite crear una lista
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		SListCircular<Integer> lista = new SListCircular<Integer>();
		// Vamos a guardar 10 elementos
		for (int i = 0; i < 5; i++)
		{
			// Creamos un nodo con el valor i, y que su next sea null
			Node<Integer> newNodo = new Node<Integer>(i); // También podría
															// insertar un
															// numero aleatorio
															// (rnd.getInt());

			lista.insertarInicio(newNodo);
		}
		for (int i = 5; i < 10; i++)
		{
			// Creamos un nodo con el valor i, y que su next sea null
			Node<Integer> newNodo = new Node<Integer>(i); // También podría
															// insertar un
															// numero aleatorio
															// (rnd.getInt());
			lista.insertarFinal(newNodo);
		}

		// Mostramos la lsita
		lista.show();
		while (!lista.esVacia())
		{
			lista.borrarFinal();
			if (lista.size > 0)
				lista.show();
			lista.borrarInicio();
			if (lista.size > 0)
				lista.show();
			System.out.println();
		}
	}

}
