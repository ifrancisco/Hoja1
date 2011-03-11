package ClassUtil;

public class MyDoubleListNode
{

	// Propiedades
	private int valorLista;
	private MyDoubleListNode nextElem;
	private MyDoubleListNode previousElem;
	//private boolean first = false;

	// private int lenght = 0;

	// Fin de propiedades
	// Constructores
	public MyDoubleListNode()
	{
		valorLista = 0;
		previousElem = null;
		nextElem = null;
	}

	public MyDoubleListNode(int valorLista)
	{
		this.valorLista = valorLista;
		//first = false;
		previousElem = null;
		this.nextElem = null;
	}

	public MyDoubleListNode(int valorLista, MyDoubleListNode next)
	{
		this.valorLista = valorLista;
		this.nextElem = next;
		previousElem = null;
	}
	public MyDoubleListNode(int valorLista, MyDoubleListNode next,MyDoubleListNode previous)
	{
		this.valorLista = valorLista;
		this.nextElem = next;
		this.previousElem = previous;
	}
	/*public MyListNode(int valueList, boolean first)
	{
		this.valorLista = valueList;
		this.first = first;
		previousElem = null;
	}*/
	// Fin constructores

	// Getter y Setter
	public int getValorLista()
	{
		return valorLista;
	}

	public void setValorLista(int valorLista)
	{
		this.valorLista = valorLista;
	}

	public MyDoubleListNode getNextElem()
	{
		return nextElem;
	}

	public void setNextElem(MyDoubleListNode nextElem)
	{
		this.nextElem = nextElem;
	}

	public MyDoubleListNode getPreviousElem()
	{
		return previousElem;
	}

	public void setPreviousElem(MyDoubleListNode previousElem)
	{
		this.previousElem = previousElem;
	}

	/*public void setFirst(boolean first)
	{
		this.first = first;
	}

	public boolean isFirst()
	{
		return first;
	}*/
	// Fin de getter y setter
}
