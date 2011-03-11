package Ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import ClassUtil.ListNode;

/**
 * Clase que implementa una lista simple enlazada. En esta clase, sólo se guarda
 * la referencia al primer nodo de la lista
 * 
 * @author isegura
 * 
 */
public class SList
{

	/** Es el primer nodo de la lista */
	private ListNode primerNodo;

	/** Guarda el número de elementos de la lista */
	private int size;

	public ListNode getPrimerNodo()
	{
		return primerNodo;
	}

	public void setPrimerNodo(ListNode primerNodo)
	{
		this.primerNodo = primerNodo;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	/** Crea una lista vacía. Head debe ser null */
	public SList()
	{
		primerNodo = null;
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
		if (primerNodo == null)
			return true;
		else
			return false;
		// return (size==0);
	}

	/**
	 * Devuelve el número nodos de la lista
	 * 
	 * @return
	 */
	public int getSize()
	{
		return size;
	}

	/**
	 * Borra el primer elemento de la lista. Complejidad O(1).
	 */
	public void borrarInicio()
	{
		if (esVacia())
		{
			System.out.println("La lista ya está vacia!!!");
			return; // salimos del método
		}

		ListNode oldFirst = primerNodo;
		// primerNodo debe pasar a ser el siguiente nodo.
		primerNodo = primerNodo.getNext();
		// disminuimos el tamaño de la lista
		size--;
		oldFirst.setNext(null);
	}

	/**
	 * Borra el último nodo de la lista. Debemos recorrer la lista hasta
	 * encontrar el penúltimo nodo cuya propiedad getNext() ahora deberá pasar a
	 * ser null Complejidad O(n), porque el número de operaciones depende del
	 * tamaño de la lista (ya que debemos visitar sus n nodos).
	 */
	public void borrarFinal()
	{
		if (esVacia())
		{
			System.out.println("La lista ya está vacia!!!");
			return; // salimos del método
		}

		ListNode ultimo = primerNodo;
		ListNode penultimo = null;
		// Recorremos la lista hasta encontrar el último nodo
		while (ultimo.getNext() != null)
		{
			penultimo = ultimo;
			ultimo = ultimo.getNext();
		}

		if (penultimo == null)
		{
			/*
			 * Quiere decir que la lista solo tenía un nodo. primerNodo debe ser
			 * null, porque estamos borrando el único nodo que tenía.
			 */
			primerNodo = null;
		} else
		{
			// La lista tiene dos o más elementos
			penultimo.setNext(null);
		}
		size--;
	}

	/**
	 * ESte método inserta el nodo newNodo al principio de la lista. Complejidad
	 * O(1), porque el método ejecuta un número constante de instrucciones.
	 * 
	 * @param newNodo
	 */
	public void insertarInicio(ListNode newNodo)
	{
		if (newNodo == null)
		{
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; // salimos del método
		}

		// El primer nodo actual ahora será el segundo
		newNodo.setNext(primerNodo);
		// Ahora hacemos que el primer nodo sea newNodo
		primerNodo = newNodo;
		// Incrementamos el tamaño de la lista
		size++;
	}

	/**
	 * 
	 * Este método inserta el nodo newNodo al final de la lista. Complejidad
	 * O(n), porque el número de instrucciones a ejecutar depende del número de
	 * nodos (n), que debemos visitar.
	 * 
	 * @param newNodo
	 *            nodo a insertr
	 */
	public void insertarFinal(ListNode newNodo)
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
			ListNode auxiliar = primerNodo;
			while (auxiliar.getNext() != null)
			{
				auxiliar = auxiliar.getNext();
			}
			// hemos llegado al último nodo, ahora su referencia getNext()
			// debe ser newNodo
			auxiliar.setNext(newNodo);
			// newNodo.getNext() debe ser nulo, porque es el final de la lista
			newNodo.setNext(null);
			// incrementamos el tamaño
			size++;
		}
	}

	/** Recorre los elementos de la lista y los muestra */
	public void show()
	{
		// [MODIFICADO]Pendiente de comentar
		ListNode auxiliar = this.getPrimerNodo();
		// Cadena donde se almacenaran los items
		String cad = "";
		// Si no esta vacia mostrara el contenido de la lista
		if (!this.esVacia())
		{
			// Recorremos la lista
			while (auxiliar != null)
			{
				// (Codigo original) System.out.print(auxiliar.getItem() + ",");
				// [Modificacion] En la variable cad se concatenan los items
				// extraidos de cada nodo de la lista
				cad = cad + auxiliar.getItem() + ",";
				auxiliar = auxiliar.getNext();
			}
			// A cad se le quita la ultima coma usando un substring que coje
			// todos los caracteres exceptuando el ultimo y lo imprime por pantalla
			cad = cad.substring(0, cad.length() - 1);
			System.out.println(cad);
			System.out.println();
			
		}
		//Si esta vacia la lista imprime "Lista Vacia"
		else
		{
			System.out.println("Lista vacia");
			System.out.println();
		}
	}

	/**
	 * Recorre la lista para buscar el máximo de la lista
	 * 
	 * @return
	 */
	public int buscarMaximo()
	{
		// Max debe tener un valor inicial por si la lista esta vacia.
		int max = 0;
		if (!this.esVacia())
		{
			// Inicialmente cogemos max como el primer elemento
			max = this.primerNodo.getItem();
			ListNode aux = this.primerNodo.getNext();
			// Recorremos la lista
			while (aux != null)
			{
				// Si el elemento es mayor que el mayor actual asignamos el
				// valor del nodo actual a la variable max.
				if (aux.getItem() > max)
				{
					max = aux.getItem();
				}
				aux = aux.getNext();
			}
		}
		return max;
	}

	/**
	 * Recorre la lista para buscar el mínimo de la lista
	 * 
	 * @return
	 */
	public int buscarMinimo()
	{
		// Min debe tener un valor inicial por si la lista esta vacia.
		int min = 0;
		if (!this.esVacia())
		{
			// Inicialmente cogemos min como el primer elemento.
			min = this.primerNodo.getItem();
			ListNode aux = this.primerNodo.getNext();
			// Recorremos la lista.
			while (aux != null)
			{
				// Si el elemento es menor que el menor actual asignamos el
				// valor del nodo actual a la variable min.
				if (aux.getItem() < min)
				{
					min = aux.getItem();
				}
				aux = aux.getNext();
			}
		}
		return min;
	}

	/**
	 * Método que busca un valor en una lista.
	 * 
	 * @param num
	 *            Numero a buscar
	 * @return Posición en la que se encuentra (comienza en 0) si el valor no
	 *         existe devuelve -1
	 */
	public int seeker(int num)
	{
		if (!this.esVacia())
		{
			// Iniciamos posicion a 0
			int posicion = 0;
			ListNode auxNext = this.getPrimerNodo();
			// Recorremos la lista
			while (auxNext != null)
			{
				// Si el item actual es igual al pasado por parametro
				// devolvemos la posición actual.
				if (auxNext.getItem() == num)
				{
					return posicion;
				}
				posicion++;
				auxNext = auxNext.getNext();
			}
		}
		// Si es vacio devuelve -1
		return -1;
	}

	/**
	 * Método que busca un valor en una lista. Y devuelve todas las posiciones
	 * en las que aparece
	 * 
	 * @param num
	 *            Numero a buscar
	 * @return Posición en la que se encuentra (comienza en 0) si el valor no
	 *         existe devuelve -1
	 */
	public String seekerString(int num)
	{
		String posiciones = "";
		if (!this.esVacia())
		{
			// Iniciamos posicion a 0
			int posicion = 0;
			ListNode auxNext = this.getPrimerNodo();
			// Recorremos la lista
			while (auxNext != null)
			{
				// Si el item actual es igual al pasado por parametro
				// devolvemos la posición actual.
				if (auxNext.getItem() == num)
				{
					posiciones = posiciones + (posicion + 1) + ",";
				}
				posicion++;
				auxNext = auxNext.getNext();
			}
		}
		if (posiciones != "")
		{
			posiciones = posiciones.substring(0, posiciones.length() - 1);
		} else
		{
			posiciones = "No encontrado";
		}
		// Si es vacio devuelve -1
		return posiciones;
	}

	/**
	 * Borra todos los elementos que contengan el valor pasado por parametros
	 * 
	 * @param num
	 *            Valor a borrar.
	 * @return Devuelve uan cadena con el numero
	 */
	public String deleteByItem(int num)
	{
		String devuelto = "No existe";
		int contBorrados = 0;
		if (!this.esVacia())
		{
			// Necesitamos tener el nodo por el que recorremos (auxNext)
			// y además el anterior por si tenemos que eleminar
			ListNode auxNext = this.getPrimerNodo();
			ListNode anterior = null;
			// Recorremos la lista.
			while (auxNext != null)
			{
				// Si es igual borramos, si no seguimos recorriendo al lista.
				if (auxNext.getItem() == num)
				{
					contBorrados++;
					// Si no es el primero asignamos la referencia de anterior
					// al siguiente del que queremos borrar
					if (anterior != null)
					{
						anterior.setNext(auxNext.getNext());
					}
					// Si es el primero asignamos la cabecera al segundo nodo.
					else
					{
						this.setPrimerNodo(auxNext.getNext());
					}
				} else
				{
					anterior = auxNext;
				}
				auxNext = auxNext.getNext();
			}
		}
		// Si el contador de borrados es mayor que 0 modificamos la cadena
		if (contBorrados != 0)
		{
			// Si solo se ha borrado 1, quitamos plurales
			if (contBorrados == 1)
			{
				devuelto = "Se ha borrado: " + contBorrados + " elemento "
						+ "que contenia el valor: " + num;
			} else
			{
				devuelto = "Se han borrado: " + contBorrados + " elementos "
						+ "que contenian el valor: " + num;
			}
		}
		// Devuelve la cadena.
		return devuelto;
	}

	/**
	 * Inserta por orden de Mayor a menor en la lista.
	 * 
	 * @param nuevo
	 *            Nuevo nodo a insertar
	 */
	public void insertarMayorMenor(ListNode nuevo)
	{
		if (!esVacia())
		{
			ListNode aux = this.getPrimerNodo();
			// Comienza a null pues antes del primero no hay nada
			ListNode anterior = null;
			boolean insertado = false;
			// Una vez insertado el nodo, la variable insertado se pone a true y
			// sale del bucle
			while (!insertado)
			{
				// Si el nodo que queremos insertar es mayor que el que tenemos
				// seleccionado
				// se debe insertar antes del seleccionado por ello utilizamos
				// la variable
				// anterior.
				if (aux.getItem() < nuevo.getItem())
				{
					// Si anterior es null significa que es el primero por tanto
					// primerNodo apuntara
					// al nuevo y el nuevo al que antes era el primero.
					if (anterior == null)
					{
						nuevo.setNext(aux);
						this.setPrimerNodo(nuevo);
					}
					// Si no, el anterior registro apuntara al nuevo y el nuevo
					// al registro actual.
					else
					{
						anterior.setNext(nuevo);
						nuevo.setNext(aux);
					}
					insertado = true;
				} // Si no es mayor seguimos recoriendo la lista y a anterior le
					// asignamos el nodo actual
				else
				{
					anterior = aux;
					aux = aux.getNext();
					if (aux == null)
					{
						insertado = true;
						anterior.setNext(nuevo);
					}
				}
			}
		}
		// Si es el primer elemento de la lista lo insertamos al inicio
		else
		{
			this.setPrimerNodo(nuevo);
		}
		size++;
	}

	/**
	 * Sobrecarga de insertarMayorMenor
	 * 
	 * @param num
	 *            Valor del item del nuevo nodo
	 */
	public void insertarMayorMenor(int num)
	{
		ListNode nuevo = new ListNode(num);
		if (!esVacia())
		{
			ListNode aux = this.getPrimerNodo();
			// Comienza a null pues antes del primero no hay nada
			ListNode anterior = null;
			boolean insertado = false;
			// Una vez insertado el nodo, la variable insertado se pone a true y
			// sale del bucle
			while (!insertado)
			{
				// Si el nodo que queremos insertar es mayor que el que tenemos
				// seleccionado
				// se debe insertar antes del seleccionado por ello utilizamos
				// la variable
				// anterior.
				if (aux.getItem() < nuevo.getItem())
				{
					// Si anterior es null significa que es el primero por tanto
					// primerNodo apuntara
					// al nuevo y el nuevo al que antes era el primero.
					if (anterior == null)
					{
						nuevo.setNext(aux);
						this.setPrimerNodo(nuevo);
					}
					// Si no, el anterior registro apuntara al nuevo y el nuevo
					// al registro actual.
					else
					{
						anterior.setNext(nuevo);
						nuevo.setNext(aux);
					}
					insertado = true;
				} // Si no es mayor seguimos recoriendo la lista y a anterior le
					// asignamos el nodo actual
				else
				{
					anterior = aux;
					aux = aux.getNext();
					if (aux == null)
					{
						insertado = true;
						anterior.setNext(nuevo);
					}
				}
			}
		}
		// Si es el primer elemento de la lista lo insertamos al inicio
		else
		{
			this.setPrimerNodo(nuevo);
		}
		size++;
	}

	/**
	 * El método main nos permite crear una lista
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		try
		{
			
			Random rnd = new Random();
			SList lista = new SList();
			// Vamos a guardar 10 elementos

			for (int i = 0; i < 20; i++)
			{
				// Creamos un nodo con el valor i, y que su next sea null
				// ListNode newNodo = new ListNode(rnd.nextInt(50)); // También
				// podría
				// insertar un
				// numero aleatorio
				// (rnd.getInt());
				// lista.insertarMayorMenor(newNodo);
				lista.insertarMayorMenor(rnd.nextInt(50));
			}
			/*
			 * for (int i = 5; i < 10; i++) { // Creamos un nodo con el valor i,
			 * y que su getNext() sea null ListNode newNodo = new ListNode(i);
			 * // También podría insertar un // numero aleatorio //
			 * (rnd.getInt()); lista.insertarMayorMenor(newNodo); }
			 */
			// Mostramos la lsita
			lista.show();
			if (!lista.esVacia())
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(
						System.in));
				System.out.print("¿Que valor desea borrar?: ");
				int numero = Integer.parseInt(in.readLine());
				System.out.println("Posicion de " + numero + " es: "
						+ lista.seekerString(numero));
				System.out.println(lista.deleteByItem(numero));
				lista.show();
			}
		} catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * while (!lista.esVacia()) { lista.borrarFinal(); if (lista.size > 0)
		 * lista.show(); lista.borrarInicio(); if (lista.size > 0) lista.show();
		 * System.out.println(); }
		 */
	}

}
