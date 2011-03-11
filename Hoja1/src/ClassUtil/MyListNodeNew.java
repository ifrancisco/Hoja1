package ClassUtil;


	public class MyListNodeNew
	{

		// Propiedades
		private int valorLista;
		private MyListNodeNew nextElem;

		// Fin de propiedades
		
		// Constructores
		public MyListNodeNew()
		{
			valorLista = 0;
			nextElem = null;
		}

		public MyListNodeNew(int valorLista)
		{
			this.valorLista = valorLista;
			//first = false;
			this.nextElem = null;
		}

		public MyListNodeNew(int valorLista, MyListNodeNew next)
		{
			this.valorLista = valorLista;
			this.nextElem = next;
		}
		
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

		public MyListNodeNew getNextElem()
		{
			return nextElem;
		}

		public void setNextElem(MyListNodeNew nextElem)
		{
			this.nextElem = nextElem;
		}

		// Fin de getter y setter
	}
