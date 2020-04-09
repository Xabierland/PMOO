package packlaboratorio5;

import java.util.Scanner;

public class Catalogo
{
	// atributos
	
	private ListaLibros lista;
	private static Catalogo miCatalogo=null;
	private Scanner sc;
	// constructora
	
	private Catalogo()
	{ 
		this.lista=new ListaLibros();
	}
	
	
 	public static Catalogo getCatalogo() 
	{
		if (Catalogo.miCatalogo==null)
		{
			Catalogo.miCatalogo=new Catalogo();
			System.out.println("La unica instancia del catalogo a sido creada con exito");
		}
		else
		{
			System.out.println("Se ha devuelto la unica instancia del catalogo");
		}
		return Catalogo.miCatalogo;
	}

 	public int obtenerNumLibros()
 	{
 		return this.lista.obtenerNumLibros();
 	}
 	 	
 	public Libro buscarLibroPorId(int pIdLibro)
 	{
 		return this.lista.buscarLibroPorId(pIdLibro);
 	}
 	
 	public void prestarLibro(int pIdLibro, int pIdUsuario)
	{
		ListaUsuarios LU=ListaUsuarios.getListaUsuarios();
		Usuario unUsuario=LU.buscarUsuarioPorId(pIdUsuario);
		Libro unLibro=this.lista.buscarLibroPorId(pIdLibro);
		if(!unUsuario.haAlcanzadoElMaximo())
		{
			if(LU.quienLoTienePrestado(unLibro)==null)
			{
				unUsuario.anadirLibro(unLibro);
				System.out.println("El libro ha sido anadido a la lista del usuario correctamente");
			}
			else
			{
				System.out.println("El usuario no ha alcanzado el maximo pero el libro ya esta en prestamo");
			}
		}
		else
		{
			System.out.println("El usuario no puede coger las libros prestados debido a que ha alcanzado el maximo");
		}
	}

 	public void devolverLibro(int pIdLibro)
	{
		ListaUsuarios LU=ListaUsuarios.getListaUsuarios();
		Libro unLibro=this.lista.buscarLibroPorId(pIdLibro);
		Usuario unUsuario=null;
		boolean correcto=false;
		try
		{
			unUsuario=LU.quienLoTienePrestado(unLibro);
			correcto=true;
		}
		catch(IntentarDevolverUnLibro mee)
		{
			System.out.println("El libro,");
			unLibro.imprimir();
			System.out.println("no esta en prestamo en este momento luego no puede ser devuelto");
		}
		
		if(correcto)
		{
			unUsuario.eliminarLibro(unLibro);
			System.out.println("El libro ha sido devuelto correctamente");
		}
		
	}
 	
 	public void catalogarLibro(Libro pLibro)
	{
 		boolean correcto=false;
 		int i=0;
 		do
 		{
 			try
 			{
 				this.lista.existeUnLibroConMismoId(pLibro);
 				correcto=true;
 			}
 			catch(CatalogarUnLibro mee)
 			{
 				System.out.println("Existe un libro catalogado con la misma ID, porfavor, introduce una nueva ID valida:");
 				int id=sc.nextInt();
 				i=i+1;
 			}
 		}
 		
 		while(!correcto && i<3);
			{
				if(correcto)
				{
					this.lista.anadirLibro(pLibro);
				}
				else
				{
					System.out.println("No se ha agregado el libro al Catalogo");
				}
			}
 	}

 	public void descatalogarLibro(int pIdLibro)
 	{
 		ListaUsuarios LU=ListaUsuarios.getListaUsuarios();
 		Libro unLibro=this.lista.buscarLibroPorId(pIdLibro);
 		Usuario unUsuario=LU.quienLoTienePrestado(unLibro);
 		if(unUsuario==null)
 		{
 			this.lista.eliminarLibro(unLibro);
 			System.out.println("El libro ha sido descatalogado con exito");
 		}
 		else
 		{
 			System.out.println("El libro esta actualmente en prestamo y no puede ser descatalogado");
 		}
	}

 	public void imprimir()
 	{
 		this.lista.imprimir();
 	}

 	public void resetear()
 	{
 		this.lista=new ListaLibros();
 	}
	
}