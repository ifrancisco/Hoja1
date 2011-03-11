package Ejercicio9;
/**
 * Pasarle esta clase a los chavales
 * <E> quiere decir que puede guardar cualquier objeto de tipo/clase E.
 * @author isegura
 *
 * @param <E>
 */
public class Node<E> {
	private Integer item;
	private Node<E> next;
	//Inicio Getters & Setters
	public Integer getItem()
	{
		return item;
	}

	public void setItem(Integer item)
	{
		this.item = item;
	}

	public Node<E> getNext()
	{
		return next;
	}

	public void setNext(Node<E> next)
	{
		this.next = next;
	}
	//Fin Getters & Setters
	public Node(){
		item=null;
		next=null;
	}
	
	public Node(Integer objecto, Node<E> n){
		item=objecto;
		next=n;
	}
	public Node(Integer objecto){
		item=objecto;
		next=null;
	}
}
