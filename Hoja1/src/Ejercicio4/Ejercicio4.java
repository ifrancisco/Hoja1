package Ejercicio4;

import java.util.Random;

import ClassUtil.MyDoubleListNode;

public class Ejercicio4
{

	static final int TAM = 200000;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			Random rnd = new Random();
			MyDoubleListNode lista = new MyDoubleListNode(
					rnd.nextInt(500000)/*, true*/);
			MyDoubleListNode aux;
			aux = lista;
			for (int i = 0; i < TAM; i++)
			{
				aux.setNextElem(new MyDoubleListNode(rnd.nextInt(5000000)));
				if (aux.isFirst())
				{
					aux.getNextElem().setPreviousElem(lista);
				} else
				{
					aux.getNextElem().setPreviousElem(aux);
				}
				aux = aux.getNextElem();
			}
			aux=lista;
			int cont = 0;
			System.out.println("Contenido: ");
			while (aux.getNextElem() != null)
			{
				System.out.println("N:" + cont + "|" + aux.getValorLista());
				aux = aux.getNextElem();
				cont++;
			}
			aux=lista;
			long t1 = System.currentTimeMillis();
			darMayMin(aux);
			long t2 = System.currentTimeMillis();
			System.out.println("Tiempo: " + (t2 - t1));

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void darMayMin(MyDoubleListNode lista)
	{
		int mayor = lista.getValorLista();
		int menor = lista.getValorLista();
		int posMay = 0;
		int posMen = 0;
		int cont = 0;
		while (lista.getNextElem() != null)
		{
			lista = lista.getNextElem();
			cont++;
			if (lista.getValorLista() > mayor)
			{
				mayor = lista.getValorLista();
				posMay = cont;
			} else if (lista.getValorLista() < menor)
			{
				menor = lista.getValorLista();
				posMen = cont;
			}
		}
		System.out.println("El mayor de la lista es: " + mayor
				+ "... En la posicion: " + posMay);
		System.out.println("El menor de la lista es: " + menor
				+ "... En la posicion: " + posMen);
	}

}
