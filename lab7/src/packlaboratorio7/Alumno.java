package packlaboratorio7;

public abstract class Alumno 
{
	// atributos
	private String DNI;
	private String Nombre;
	private String Apellido;
	private int Edad;
	private ListaAlumnos lista;
	
	// constructora
	public Alumno(String pDNI, String pNombre, String pApellido, int pEdad)
	{
		DNI=pDNI;
		Nombre=pNombre;
		Apellido=pApellido;
		Edad=pEdad;
	}

	//metodos
	protected ListaAlumnos getListaPreferencias()
	{
		return lista;
	}

	protected int getEdad()
	{
		return Edad;
	}

	public String getNombre()
	{
		return Nombre;
	}

	public String getApellido()
	{
		return Apellido;
	}

	public boolean tieneEsteDNI(String pDNI)
	{
		boolean igual=false;
		if (this.DNI==pDNI)
		{
			igual=true;
			System.out.println("El Alumno tiene este DNI");
		}
		else
		{
			System.out.println("El Alumno tiene otro DNI");
		}
		return igual;
	}

	public boolean tieneElMismoDNI(Alumno pAlumno)
	{
		boolean igual=false;
		if(this.DNI==pAlumno.DNI)
		{
			igual=true;
			System.out.println("Ambos Alumnos tienen el mismo DNI");
		}
		else
		{
			System.out.println("Los Alumnos tienen distintos DNI");
		}
		return igual;
	}

	public abstract void anadirPreferencia(Alumno pAlumno);  
}
