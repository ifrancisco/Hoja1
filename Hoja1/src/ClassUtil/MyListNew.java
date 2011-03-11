package ClassUtil;
public class MyListNew
{
	// Atributos
	private MyListNodeNew head;
	private MyListNodeNew tail;
	private int count = 0;

	// private int index;

	// Constructores

	public MyListNew()
	{
		this.head = null;
		this.tail = null;
		this.count = 0;
	}

	public MyListNew(MyListNodeNew head)
	{
		this.head = head;
		//[MODIFICADO] FCORTES: 21:15
		// Al poner tail a null a la hora de insertar perderias el nodo pasado por parametros
		// por tanto ahora head y tail son iguales para poder conservar este elemento.
		
		/*this.tail = null;*/
		this.tail = head;
		this.count++;
	}

	/**
	 * Constructor que recibe un primer elemento y un ultimo elemento y almacena la lista.
	 * Debemos pasar un head un tail enlazado.
	 * @param head
	 * @param tail
	 */
	public MyListNew(MyListNodeNew head, MyListNodeNew tail)
	{
		this.head = head;
		this.tail = tail;
		MyListNodeNew aux = head;
		// Aqui hacer metodo para contar los elementos
		//[MODIFICADO] FCORTES: 15/02/2011 21:28
		//   Agregado metodo que cuenta los elementro entre el head y tail pasados por parametros.
		if(head!=tail){
			count = 1;
			while(aux!=null){
				aux = aux.getNextElem();
				count++;
			}
		}else{
			count=1;
		}
		
	}

	// Getters & Setters
	public MyListNodeNew getHead()
	{
		return head;
	}

	public void setHead(MyListNodeNew head)
	{
		this.head = head;
	}

	public MyListNodeNew getTail()
	{
		return tail;
	}

	public void setTail(MyListNodeNew tail)
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

	/**
	 * Insertar al principio de la lista
	 * 
	 * @param newNode Nuevo nodo a insertar al inicio
	 */
	public void insertBegining(MyListNodeNew newNode)
	{
		if (newNode != null)
		{
			if (head == null)
			{
				setHead(newNode);
			} else
			{
				newNode.setNextElem(this.head);
				setHead(newNode);
			}
			count++;
		}
	}

	/**
	 * Insertar al final de la lista
	 * 
	 * @param newNode Nodo a introducir
	 */
	public void insertEnd(MyListNodeNew newNode)
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
				setTail(newNode);
			}
			count++;
		}
	}


/**
 * Borra el primer elemento de la lista
 */
	public void deleteFirst()
	{
		if (head != null)
		{
			setHead(this.head.getNextElem());
			count--;
		}
	}

	/**
	 * Borra el ultimo elemento de la lista
	 */
	public void deleteLast()
	{
		if (tail != null)
		{
			this.tail.setNextElem(null);
			count--;
		}
	}
	/**
	 * Obtiene el tamaño
	 * 
	 * @return Devuelve el tamaño de la lista
	 */
	public int lenght()
	{
		int lenght = 0;
		MyListNodeNew aux = getHead();
		while (aux!= null)
		{
			lenght++;
			aux = aux.getNextElem();
		}
		return lenght;
	}
}
