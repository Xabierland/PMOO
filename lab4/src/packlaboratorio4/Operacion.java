package packlaboratorio4;

public class Operacion
{
	// atributos
	private int idOperacion;
	private int idCliente;
	private String claveTecleada;
	private double cantidad;
	private static double comisionNoPref=0.1;
	
	
	// constructora
	   
	public Operacion(int pIdOper, int pIdCliente, String pClaveTecleada, double pCant)
	{
		this.idOperacion=pIdOper;
		this.idCliente=pIdCliente;
		this.claveTecleada=pClaveTecleada;
		this.cantidad=pCant;
	}
   
	// otros metodos
	
	public boolean tieneMismoId(int pIdOperacion)
	{
		boolean esIgual=false;
		if (this.idOperacion==pIdOperacion)
		{
			esIgual=true;
		}
		return esIgual;
	}
   
	public void realizarOperacion ()
	{
		ListaClientes LC= ListaClientes.getListaClientes();
		Cliente unCliente=null;
		
		if(LC.buscarClientePorId(this.idCliente)!=null)
		{
			unCliente = LC.buscarClientePorId(this.idCliente);
			if (unCliente.esPreferente())
			{
				unCliente.actualizarSaldo(this.claveTecleada, this.cantidad);
				System.out.println("Cliente preferente detectado");
			}
			else
			{
				unCliente.actualizarSaldo(this.claveTecleada, this.cantidad+(this.cantidad*Operacion.comisionNoPref));
				System.out.println("Cliente no preferente detectado");
			}
			
			System.out.println("La operacion se ha realizado con exito");
		}
		else
		{
			System.out.println("No se a encontrado cliente que coincida con la ID proporcionada");
		}
	}
}
