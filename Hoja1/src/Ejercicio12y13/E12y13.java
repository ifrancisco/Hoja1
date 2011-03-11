package Ejercicio12y13;

import TADList.LinkedListStack;

public class E12y13
{
	public boolean isNumeric(Character c)
	{
		try
		{
			Integer.parseInt(c.toString());
			return true;
		} catch (NumberFormatException e)
		{
			return false;
		}
	}

	public LinkedListStack<Integer> invertirPila(LinkedListStack<Integer> pila,
			int elemAInvertir)
	{
		int[] auxChange = new int[pila.size()];
		for (int i = 0; i < elemAInvertir; i++)
		{
			auxChange[i] = pila.pop();
		}
		for (int k = 0; k < auxChange.length; k++)
		{
			pila.push(auxChange[k]);
		}
		return pila;
	}

	public boolean checkParenthesis(char[] c)
	{
		return false;
	}

	public int postFixedFormat(char[] c)
	{
		LinkedListStack<Integer> pila = new LinkedListStack<Integer>();
		int resultado = 0;
		int resulMul = 0;
		int opr = 0;
		int numsEnPila = 0;
		if ((!isNumeric(c[0]) || (isNumeric(c[c.length-1]))))
		{
			System.out
					.println("La cadena introducida no tiene formato adecuado. Porfavor corrijalo.");
		} else
		{
			for (int i = 0; i < c.length - 1; i++)
			{
				if (isNumeric(c[i]))
				{
					pila.push(Integer.parseInt(String.valueOf(c[i])));
					numsEnPila++;

				} else
				{
					switch (c[i])
					{
					case '*':
						resulMul = 1;
						for (int j = 0; j < numsEnPila; j++)
						{
							resulMul *= pila.pop();
						}
						resultado += resulMul;
						pila.push(resultado);
						break;
					case '-':
						for (int j = 0; j < numsEnPila - 1; j++)
						{
							resultado -= pila.pop();
						}
						resultado += pila.pop();
						pila.push(resultado);
						break;
					case '+':
						for (int j = 0; j < numsEnPila; j++)
						{
							resultado += pila.pop();
						}
						pila.push(resultado);
						break;
					case '/':
						pila = invertirPila(pila, numsEnPila);
						resultado = pila.pop();
						for (int j = 0; j < numsEnPila - 1; j++)
						{
							resultado /= pila.pop();
						}
						pila.push(resultado);
						break;
					}
					resultado = 0;
					numsEnPila = 0;
				}
			}
			opr = pila.size();
			switch (c[c.length - 1])
			{
			case '*':
				resulMul = 1;
				for (int j = 0; j < opr; j++)
				{
					resulMul *= pila.pop();
				}
				resultado += resulMul;
				break;
			case '-':
				for (int j = 0; j < opr - 1; j++)
				{
					resultado -= pila.pop();
				}
				resultado += pila.pop();
				break;
			case '+':
				for (int j = 0; j < opr; j++)
				{
					resultado += pila.pop();
				}
				break;
			case '/':
				pila = invertirPila(pila, pila.size());
				resultado = pila.pop();
				for (int j = 0; j < opr - 1; j++)
				{
					resultado /= pila.pop();
				}
				break;
			}
		}
		return resultado;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		E12y13 e = new E12y13();

		String c1 = "[(5+x]-(y+2)]";
		System.out.println(c1);
		System.out.println("Tt is: " + e.checkParenthesis(c1.toCharArray()));

		String c2 = "4522*3421+4/";
		System.out.println(c2);
		System.out.println("It is: " + e.postFixedFormat(c2.toCharArray()));

	}

}
