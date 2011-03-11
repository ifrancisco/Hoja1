package TADList;
/**
 * Pasarle esta clase a los chavales
 * <E> quiere decir que puede guardar cualquier objeto de tipo/clase E.
 * @author isegura
 *
 * @param <E>
 */
public class Node<E> {
	public E item;
	public Node<E> next;
	
	public Node(){
		item=null;
		next=null;
	}
	
	public Node(E objecto, Node<E> n){
		item=objecto;
		next=n;
	}
	public Node(E objecto){
		item=objecto;
		next=null;
	}
}
