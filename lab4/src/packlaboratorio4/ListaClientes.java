package packlaboratorio4;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaClientes
{
	
	// atributos
	private ArrayList<Cliente> lista;
	private static ListaClientes miListaClientes=null;
	
	
		
	// constructora
	
	private ListaClientes()		//La constructora es privada ya que sigue el patron singelton
	{ 
		 this.lista = new ArrayList<Cliente>();
	}
	
	// otros metodos
	
	public static ListaClientes getListaClientes()
  	{
		if (ListaClientes.miListaClientes==null)
		{
			ListaClientes.miListaClientes = new ListaClientes();
		}
		return ListaClientes.miListaClientes;
	}

 	private Iterator<Cliente> getIterador()
 	{
 		return this.lista.iterator();
 	}

 	public int cantidadClientes()
 	{
 		return this.lista.size();
 	}
 	
  	public void anadirCliente(int pIdCliente, String pNombre, String pClave, double pSaldo, boolean pEsPreferente)
 	{
  		Cliente cl=new Cliente(pIdCliente,pNombre,pClave,pSaldo,pEsPreferente);
  		this.lista.add(cl);  		
 	}
 
	public Cliente buscarClientePorId(int pId)
 	{
		
		boolean encontrado=false;
		Cliente unCliente=null;
		Iterator<Cliente> itr=this.getIterador();
		while (itr.hasNext() && !encontrado)
		{
			unCliente=itr.next();
			if (unCliente.tieneMismoId(pId))
			{
				encontrado=true;
				System.out.println("Cliente detectado");
			}
			
		}
		if (!encontrado)
		{
			unCliente=null;
			System.out.println("Cliente no detectado");
		}
		return unCliente;
 	}
  	
  	public void resetear()
 	{
 		this.lista=new ArrayList<Cliente>();
 	}
}
