package ClassUtil;
/**
 * <E> quiere decir que puede guardar cualquier objeto de tipo/clase E.
 * @author isegura
 *
 * @param <E>
 */
public class DNode<E> {
	private E item;
	private DNode<E> prev;
	private DNode<E> next;
	
	public DNode(){
		setPrev(null);
		setNext(null);
	}
	public DNode(E objecto, DNode<E> p, DNode<E> n){
		setItem(objecto);
		setPrev(p);
		setNext(n);
	}
	//Principio Getters&Setters
	public DNode(E objecto){
		setItem(objecto);
	}
	
	public void setItem(E item)
	{
		this.item = item;
	}
	public E getItem()
	{
		return item;
	}
	public void setPrev(DNode<E> prev)
	{
		this.prev = prev;
	}
	public DNode<E> getPrev()
	{
		return prev;
	}
	public void setNext(DNode<E> next)
	{
		this.next = next;
	}
	public DNode<E> getNext()
	{
		return next;
	}
	//Final Getters&Setters
}
