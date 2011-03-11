package TADList;
/**
 * Pasarle esta clase a los chavales
 * <E> quiere decir que puede guardar cualquier objeto de tipo/clase E.
 * @author isegura
 *
 * @param <E>
 */
public class DNode<E> {
	public E item;
	public DNode<E> prev, next;
	
	public DNode(){
		prev=null;
		next=null;
	}
	public DNode(E objecto, DNode<E> p, DNode<E> n){
		item=objecto;
		prev=p;
		next=n;
	}
	public DNode(E objecto){
		item=objecto;
	}
}
