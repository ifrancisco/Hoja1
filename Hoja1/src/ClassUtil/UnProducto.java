package ClassUtil;

public class UnProducto
{

		private int id;
		private String nombre;
		private float precio;

		public int getId()
		{
			return id;
		}

		public void setId(int id)
		{
			this.id = id;
		}

		public String getNombre()
		{
			return nombre;
		}

		public void setNombre(String nombre)
		{
			this.nombre = nombre;
		}

		public float getPrecio()
		{
			return precio;
		}

		public void setPrecio(float precio)
		{
			this.precio = precio;
		}

		/**
		 * Constructor de Producto
		 * 
		 * @param i
		 * @param n
		 * @param p
		 */
		public UnProducto(int i, String n, float p)
		{
			this.setId(i);
			this.setNombre(n);
			this.setPrecio(p);
		}

		/**
		 * Constructor por defecto
		 */
		public UnProducto()
		{
			this.setId(0);
			this.setNombre("");
			this.setPrecio(0.0f);
		}

		public void view()
		{
			System.out.println(this.toString());
		}

		public String toString()
		{
			return id + "-" + nombre + ":" + precio;
		}
		
		/**
		 * Comporador de 2 productos.
		 * 
		 * @param comp1
		 * @param comp2
		 * @return 1 si comp1>comp2; 0 si comp1=comp2; -1 si comp2>comp1
		 */
		
		public int comparar(UnProducto comp2){
			//
			if(this.getId()>comp2.getId()){
				return 1;
			}
			else{
				if (this.getId()==comp2.getId())
					return 0;
			}
			return -1;
		}
}
