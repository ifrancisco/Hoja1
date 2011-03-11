package ClassUtil;

/**
 * Clase que implementa una estructura de datos para representar nodos que
 * almacenan enteros.
 * 
 * @author isegura
 * 
 */
public class ListNode
{

	/** Propiedad item que almacena el valor entero */
	private int item;

	/**
	 * Referencia al siguiente nodo
	 * */
	private ListNode next;
	

	//Inicio Getters && Setters
	public int getItem()
	{
		return item;
	}

	public void setItem(int item)
	{
		this.item = item;
	}

	public ListNode getNext()
	{
		return next;
	}

	public void setNext(ListNode next)
	{
		this.next = next;
	}

	/**
	 * Método constructor que inicializa las propiedades de un nodo
	 * */
	public ListNode(int x, ListNode nodo)
	{
		item = x;
		next = nodo;
	}

	/**
	 * Método constructor que inicializa sólo la propiedad item del nodod la
	 * propiedad next es nulo
	 * */
	public ListNode(int x)
	{
		item = x;
		next = null;
	}
}