package ClassUtil;

public class MyDoubleList
{
	// Atributos
	private MyDoubleListNode head;
	private MyDoubleListNode tail;
	private int count = 0;

	// private int index;

	// Constructores

	public MyDoubleList()
	{
		this.head = null;
		this.tail = null;
		this.count = 0;
	}

	public MyDoubleList(MyDoubleListNode head)
	{
		this.head = head;
		this.tail = null;
		this.count++;
	}

	public MyDoubleList(MyDoubleListNode head, MyDoubleListNode tail)
	{
		this.head = head;
		this.tail = tail;
		// Aqui hacer metodo para contar los elementos
	}

	// Getters & Setters
	public MyDoubleListNode getHead()
	{
		return head;
	}

	public void setHead(MyDoubleListNode head)
	{
		this.head = head;
	}

	public MyDoubleListNode getTail()
	{
		return tail;
	}

	public void setTail(MyDoubleListNode tail)
	{
		this.tail = tail;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	// Metodos

	// Introducir al principio
	public void insertBegining(MyDoubleListNode newNode)
	{
		if (newNode != null)
		{
			if (head == null)
			{
				setHead(newNode);
			} else
			{
				newNode.setNextElem(this.head);
				this.head.setPreviousElem(newNode);
				setHead(newNode);
			}
			count++;
		}
	}

	// Introducir al final
	public void insertEnd(MyDoubleListNode newNode)
	{
		if (newNode != null)
		{
			if (tail == null)
			{
				setTail(newNode);
				setHead(newNode);

			} else
			{
				newNode.setNextElem(null);
				this.tail.setNextElem(newNode);
				newNode.setPreviousElem(this.tail);
				setTail(newNode);
			}
			count++;
		}
	}

	// Borrar el primero
	public void deleteFirst()
	{
		if (head != null)
		{
			setHead(this.head.getNextElem());
			this.head.setPreviousElem(null);
			count--;
		}
	}

	// Borrar el ultimo
	public void deleteLast()
	{
		if (tail != null)
		{
			setTail(this.tail.getPreviousElem());
			this.tail.setNextElem(null);
			count--;
		}
	}
	//Devuelve el tamaño de la lista
	public int lenght()
	{
		int lenght = 0;
		MyDoubleListNode aux = getHead();
		while (aux!= null)
		{
			lenght++;
			aux = aux.getNextElem();
		}
		return lenght;
	}
}
