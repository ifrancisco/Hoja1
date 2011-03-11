package Ejercicio4;

import java.util.Random;

import ClassUtil.MyDoubleList;
import ClassUtil.MyDoubleListNode;

public class Ejercicio4V2
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
			MyDoubleList list = new MyDoubleList(new MyDoubleListNode(rnd.nextInt(500000)));
			System.out.println(list.lenght());
			for (int i = 0; i < TAM; i++)
			{
				list.insertEnd(new MyDoubleListNode(rnd.nextInt(5000000)));
			}
			int cont = 0;
			System.out.println("Contenido: ");
			MyDoubleListNode aux = list.getHead();
			while (aux!= null)
			{
				System.out.println("N:" + cont + "|" + aux.getValorLista());
				aux = aux.getNextElem();
				cont++;
			}
			long t1 = System.currentTimeMillis();
			darMayMin(list.getHead());
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
		while (lista!= null)
		{
			if (lista.getValorLista() > mayor)
			{
				mayor = lista.getValorLista();
				posMay = cont;
			} else if (lista.getValorLista() < menor)
			{
				menor = lista.getValorLista();
				posMen = cont;
			}
			lista = lista.getNextElem();
			cont++;
		}
		System.out.println("El mayor de la lista es: " + mayor
				+ "... En la posicion: " + posMay);
		System.out.println("El menor de la lista es: " + menor
				+ "... En la posicion: " + posMen);
	}

}
