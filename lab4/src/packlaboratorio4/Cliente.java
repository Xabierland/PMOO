package packlaboratorio4;

public class Cliente
{
	// atributos
	private int idCliente;
	private String nombre;
	private String clave;
	private double saldo;
	private boolean esPreferente;
	
	
	// constructora	
	
	public Cliente(int pId, String pNombre, String pClave, double pSaldo, boolean pPref)
	{
		this.idCliente=pId;
		this.nombre=pNombre;
		this.clave=pClave;
		this.saldo=pSaldo;
		this.esPreferente=pPref;
	}

   // otros metodos
   
	public boolean esPreferente()
	{
		return this.esPreferente;
	}
   
	public boolean tieneMismoId(int pId)
	{
		boolean esIgual=false;
		if (this.idCliente==pId)
		{
			esIgual=true;
		}
		return esIgual;
	}
   
	public double obtenerSaldo(String pClaveTecleada)
	{
		double valor=0.0;
	   if (this.comprobarClave(pClaveTecleada))
	   {
		   valor = this.saldo;
	   }
	   else
	   {
		   valor = 0.0;
	   }
	   //System.out.println(valor);
	   return valor;
	}
   
	private boolean comprobarClave(String pClave)
	{
		boolean esIgual=false;
		
		if (this.clave==pClave)
		{
			esIgual=true;
			System.out.println("La clave introduccida es correcta");
		}
		else
		{
			System.out.println("La clave introduccida es incorrecta");
		}
		
		return esIgual;
	}
	
	
	
	public void actualizarSaldo(String pClaveTecleada, double pCantidad)
	{
	   if(this.comprobarClave(pClaveTecleada))
	   {
		   if((this.obtenerSaldo(pClaveTecleada)-pCantidad)>=0)
		   {
			   this.saldo=this.saldo-pCantidad;
			   System.out.println("El saldo de se ha actualizado con exito para");
			   System.out.println(this.nombre);
			   System.out.println("Su nuevo saldo es:");
			   System.out.println(this.obtenerSaldo(pClaveTecleada));
		   }
		   else
		   {
			   System.out.println("No ha saldo para realizar la actualizacion");
		   }
	   }
	   else
	   {
		   System.out.println("La clave tecleada es incorrecta");
	   }
	}
}
