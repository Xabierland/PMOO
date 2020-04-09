package packlaboratorio5;

public class Usuario
{
	//atributos
	private int idUsuario;
	private String nombreCompleto;
	private int maxLibros=3;
	private ListaLibros librosEnPrestamo;
	
	
	//constructora

	public Usuario(String pNombreCompleto, int pIdUsuario)
	{
		this.idUsuario=pIdUsuario;
		this.nombreCompleto=pNombreCompleto;
		this.librosEnPrestamo=new ListaLibros();
	}

	// otros metodos

	public boolean tieneEsteId(int pId)
	{
		boolean igual=false;
		if (this.idUsuario==pId)
		{
			igual=true;
		}
		else
		{
			igual=false;
		}
		return igual;
	}
	
	public boolean tieneElMismoId(Usuario pUsuario)
	{
		boolean igual=false;
		if (this.idUsuario==pUsuario.idUsuario)
		{
			igual=true;
			System.out.println("Ambos usuarios tiene la misma ID");
		}
		else
		{
			igual=false;
			System.out.println("Ambos usuarios tiene DIFERENTES ID");
		}
		return igual;
	}

	public boolean haAlcanzadoElMaximo()
	{
		boolean maximo=false;
		if(this.librosEnPrestamo.obtenerNumLibros()==this.maxLibros)
		{
			maximo=true;
			System.out.println("Se ha alcanzado el maximo numero de libros");
			
		}
		else
		{
			maximo=false;
			System.out.println("No se ha alcanzado el maximo numero de libros");
			
		}
		return maximo;
	}

	public void anadirLibro(Libro pLibro)
	{
		if (this.librosEnPrestamo.obtenerNumLibros()!=this.maxLibros)
		{
			this.librosEnPrestamo.anadirLibro(pLibro);
			System.out.println("Se ha anadido el libro con exito");
		}
		else
		{
			System.out.println("No se ha annadido ya que a alcanzado el maximo");
		}
		
	}

	public void eliminarLibro(Libro pLibro)
	{
		if (this.librosEnPrestamo.esta(pLibro))
		{
			this.librosEnPrestamo.eliminarLibro(pLibro);
			System.out.println("Se ha eliminado el libro con exito");
		}
		else
		{
			System.out.println("No se ha encontrado el libro luego no se ha podido eliminar");			
		}
	}

	public boolean loTieneEnPrestamo(Libro pLibro)
	{
		return this.librosEnPrestamo.esta(pLibro);
	}

	public void imprimir()
	{
		String msg,msg2;
		msg=String.format("ID: %s: %s", this.idUsuario,this.nombreCompleto);
		System.out.println(msg);
		
		if(this.librosEnPrestamo.obtenerNumLibros()!=0)
		{
			msg2=String.format("---> Tiene %d libros en prestamo", this.librosEnPrestamo.obtenerNumLibros());
			System.out.println(msg2);
			this.librosEnPrestamo.imprimir();
		}
		else
		{
			System.out.println("---> No tiene ningun libro en prestamo");
		}
	}
}
