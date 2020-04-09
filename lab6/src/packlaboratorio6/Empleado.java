package packlaboratorio6;

public class Empleado
{
	//atributos
	private int idEmpleado;
	private String Nombre;
	private String Apellido;
	private ListaConceptos listadeConceptos;
	private int cantidadBruta;
	private int numeroDeHoras;
	private int anosTrabajando;
	
	
	//constructora
	public Empleado(int pIdEmpleado, String pNombre, String pApellido, int pCantidadBruta, int pNumeroDeHoras, int pAnosTrabajando) 
	{
		this.idEmpleado=pIdEmpleado;
		this.Nombre=pNombre;
		this.Apellido=pApellido;
		this.cantidadBruta=pCantidadBruta;
		this.numeroDeHoras=pNumeroDeHoras;
		this.anosTrabajando=pAnosTrabajando;
	}
	// otros metodos
	public boolean tieneEstaId(int pId)
	{
		boolean tiene=false;
		if (this.idEmpleado==pId)
		{
			tiene=true;
			String resp=String.format("La ID coincide con la de %s y %s", this.Nombre,this.Apellido);
			System.out.println(resp);
		}
		return tiene;
	}
	
	public double calcularSueldo()
	{
		return this.listadeConceptos.sumaConceptos(this.cantidadBruta, this.numeroDeHoras, this.anosTrabajando);
	}
}
