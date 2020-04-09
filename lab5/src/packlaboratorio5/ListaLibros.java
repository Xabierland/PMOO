package packlaboratorio5;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaLibros
{
	// atributos
	private ArrayList<Libro> lista;

	// constructora

	public ListaLibros()
	{
		this.lista=new ArrayList<Libro>();
	}

	// otros metodos

	public int obtenerNumLibros()
	{  
		return this.lista.size();
	}

	private Iterator<Libro> getIterador()
	{
		return this.lista.iterator();
	}

	public Libro buscarLibroPorId(int pIdLibro)
	{
		boolean encontrado=false;
		Libro unLibro=null;
		Iterator<Libro> itr=this.getIterador();
		while(itr.hasNext() && !encontrado)
		{
			unLibro=itr.next();
			if(unLibro.tieneEsteId(pIdLibro))
			{
				encontrado=true;
				System.out.println("Se ha encontrado un libro con esa ID");
			}
		}
		if (!encontrado)
		{
			System.out.println("No se ha encontrado ningun libro con esa ID");
			unLibro=null;
			
		}
		return unLibro;
	}
	
	public boolean esta(Libro pLibro)
	{
		return this.lista.contains(pLibro);
	}

	public boolean existeUnLibroConMismoId(Libro pLibro) throws CatalogarUnLibro
	{
		boolean existe=false;
		Libro unLibro=null;
		Iterator<Libro> itr=this.getIterador();
		
		while(itr.hasNext() && !existe)
		{
			unLibro=itr.next();
			
			if(unLibro.tieneElMismoId(pLibro))
			{
				existe=true;
				System.out.println("Exite otro libro con la misma ID");
			}
		}
		if(!existe)
		{
			throw(new CatalogarUnLibro());	
		}
		return existe;
	}
	
	public void anadirLibro(Libro pLibro)
	{
		if (!this.esta(pLibro))
		{
			this.lista.add(pLibro);
		}
	}

	public void eliminarLibro(Libro pLibro)
	{
		if (this.esta(pLibro))
		{
			this.lista.remove(pLibro);
		}
	}
	
	public void imprimir()
	{
		Libro unLibro;
		Iterator<Libro> itr=this.getIterador();
		
		while(itr.hasNext())
		{
			unLibro=itr.next();
			unLibro.imprimir();
		}
	}
}