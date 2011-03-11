package ClassUtil;

import java.util.Random;

public class MainListaDEnlazada
{
private static String nameProductos[]={"lapiz","goma","folios","toner"};
	
	public static void main(String args[]){
		Random rand = new Random();
		DListProducto1 lstProd = new DListProducto1();
		for(int i = 0; i<nameProductos.length;i++){
			int id = rand.nextInt(10);
			UnProducto oProd = new UnProducto(id,nameProductos[i]+id,rand.nextInt(100));
			//lstProd.insertarProducto(oProd);
			System.out.println("Despues de insertar: "+id);
			//lstProd.showProductos();
		}
	}


}
