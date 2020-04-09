package packlaboratorio4;

import java.util.*;

public class ListaOperaciones
{
	// atributos
	private ArrayList<Operacion> lista;
	private static ListaOperaciones miListaOperaciones=null;
	
	
	// constructora
	
	private ListaOperaciones()
	{ 
		this.lista = new ArrayList<Operacion>();
	}
	
	// otros metodos
	
  	public static ListaOperaciones getListaOperaciones()
	{
		if (ListaOperaciones.miListaOperaciones==null)
		{
			ListaOperaciones.miListaOperaciones=new ListaOperaciones();
			System.out.println("Unica instancia de la lista creada");
		}
		else
		{
			System.out.println("Devolviendo la unica instancia de la lista");
		}
		return ListaOperaciones.miListaOperaciones;
	}
  	private Iterator<Operacion> getIterador()
 	{
 		return this.lista.iterator();
 	} 	
 	public int cantidadOperaciones()
 	{
 		return this.lista.size();
 	} 	
 	public void anadirOperacion(int pIdOperacion, int pIdCliente, String pClaveTecleada, double pCantidad)
 	{
 		Operacion op= new Operacion(pIdOperacion,pIdCliente,pClaveTecleada,pCantidad);
 		this.lista.add(op);
 	}  	
 	public Operacion buscarOperacionPorId(int pId)
 	{
 		boolean encontrado=false;
 		Operacion op=null;
 		Iterator<Operacion> itr=this.getIterador();
 		while (itr.hasNext() && !encontrado)
 		{
 			op=itr.next();
 			if (op.tieneMismoId(pId))
 			{
 				encontrado=true;
 			}
 		}
 		return op;
 	}
 	public void realizarOperaciones()
 	{
 		Operacion op=null;
 		Iterator<Operacion> itr=this.getIterador();
 		while (itr.hasNext())
 		{
 			op=itr.next();
 			op.realizarOperacion();
 		}
 	}
 	
 	public void resetear()
 	{
 		this.lista=new ArrayList<Operacion>();
 	}
}	
