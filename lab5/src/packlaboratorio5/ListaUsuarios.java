package packlaboratorio5;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaUsuarios
{
	// atributos
	private ArrayList<Usuario> lista;
	private static ListaUsuarios miListaUsuarios=null;

	// constructora

	private ListaUsuarios()
	{ 
		this.lista=new ArrayList<Usuario>();
	}

	// otros métodos

	public static ListaUsuarios getListaUsuarios()
	{
		if (ListaUsuarios.miListaUsuarios==null)
		{
			ListaUsuarios.miListaUsuarios=new ListaUsuarios();
			System.out.println("Se ha creado la unica instancia de la Lista de Usuarios");
		}
		else
		{
			System.out.println("Se ha devuelto la unica instancia de la Lista de Usuarios");
		}
		return miListaUsuarios;
	}

	public int obtenerNumUsuarios()
	{
		return this.lista.size();
	}

	private Iterator<Usuario> getIterador()
	{
		return this.lista.iterator();
	}

	public Usuario buscarUsuarioPorId(int pId) throws DarDeBaja
	{
		Iterator<Usuario> itr=this.getIterador();
		boolean encontrado=false;
		Usuario unUsuario=null;
		while(itr.hasNext() && !encontrado)
		{
			unUsuario=itr.next();
			if(unUsuario.tieneEsteId(pId))
			{
				encontrado=true;
				System.out.println("Se ha encontrado el usuario");
			}
		}
		if(!encontrado)
		{
			unUsuario=null;
			throw(new DarDeBaja());
		}
		return unUsuario;		
	}

	public boolean existeUnUsuarioConMismoId(Usuario pUsuario)
	{
		Iterator<Usuario> itr=this.getIterador();
		boolean encontrado=false;
		Usuario unUsuario=null;
		while(itr.hasNext() && !encontrado)
		{
			unUsuario=itr.next();
			if(unUsuario.tieneElMismoId(pUsuario))
			{
				encontrado=true;
				System.out.println("Se ha encontrado el usuario");
			}
		}
		if(!encontrado)
		{
			System.out.println("No se ha encontrado el usuario");
		}
		return encontrado;
	}

	public void darDeAltaUsuario(Usuario pUsuario)
	{
		if(!this.existeUnUsuarioConMismoId(pUsuario))
		{
			this.lista.add(pUsuario);
		}
	}

	public void darDeBajaUsuario(int pIdUsuario)
	{
		boolean correcto=false;
		try
		{
			this.buscarUsuarioPorId(pIdUsuario);
			correcto=true;
			
		}
		catch(DarDeBaja mee)
		{
			System.out.println("No se ha encontrado al usuario luego no se le ha dado de baja");
		}
		
		if(correcto)
		{
			System.out.println("Se ha dado de baja al usuario con exito");
		}
	}

	public Usuario quienLoTienePrestado(Libro pLibro) throws IntentarDevolverUnLibro
	{
		Usuario unUsuario=null;
		boolean encontrado=false;
		Iterator<Usuario> itr=this.getIterador();
		while (itr.hasNext() && !encontrado)
		{
			unUsuario=itr.next();
			if (unUsuario.loTieneEnPrestamo(pLibro))
			{
				encontrado=true;
				System.out.println("Este es el usuario que tiene el libro");
			}
		}
		if(!encontrado)
		{
			unUsuario=null;
			throw (new IntentarDevolverUnLibro());
		}
		return unUsuario;		
	}

	public void imprimir()
	{	
		Usuario unUsuario=null;
		Iterator<Usuario> itr=this.getIterador();
		
		while(itr.hasNext())
		{
			unUsuario=itr.next();
			unUsuario.imprimir();
		}
	}

	public void resetear()
	{
		this.lista=new ArrayList<Usuario>();
	}

}
