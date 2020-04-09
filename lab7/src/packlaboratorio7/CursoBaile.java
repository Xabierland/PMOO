package packlaboratorio7;

public class CursoBaile
{
	// atributos
	private ListaAlumnosCurso lista;
	private static CursoBaile miCursoBaile;

	// constructora
	private CursoBaile()
	{
		this.lista=ListaAlumnosCurso.getListaAlumnosCurso();
	}
	
	// metodos
	public static CursoBaile getCursoBaile()
	{
		if (miCursoBaile==null)
		{
			CursoBaile.miCursoBaile=new CursoBaile();
			System.out.println("Creada la unica instancia del Curso de Baile");
		}
		else
		{
			System.out.println("Se ha devuelto la unica instancia del Curso de Baile");
		}
		return CursoBaile.miCursoBaile;
	}

	public void darDeAltaPareja(String pDNI1, String pDNI2)
	{
		ListaAlumnosCurso listaCurso=ListaAlumnosCurso.getListaAlumnosCurso();
		Alumno Alumno1=listaCurso.buscarAlumnoPorDNI(pDNI1);
		Alumno Alumno2=listaCurso.buscarAlumnoPorDNI(pDNI2);
		if(Alumno1!=null)
		{
			if (Alumno2!=null)
			{
				new Pareja(Alumno1, Alumno2);
			}
			else
			{
				System.out.println("No hay ningun alumno con ese DNI");
			}
		}
		else
		{
			System.out.println("No hay ningun alumno con ese DNI");
		}
	}

	public void darDeAltaAlumno(String pDNI, String pNombre, String pApellido, int pEdad,  char pSexo)
	{
		if (pSexo=='h' || pSexo=='H')
		{
			new Hombre(pDNI, pNombre, pApellido, pEdad);
			System.out.println("Se ha creado un nuevo hombre con exito");
		}
		else if (pSexo=='m' || pSexo=='M')
		{
			new Mujer(pDNI, pNombre, pApellido, pEdad);
			System.out.println("Se ha creado una nueva mujer con exito");
		}
		else
		{
			System.out.println("El sexo elegido no es correcto");
		}
	}

	public void anadirPreferencia(String pIdQuien, String pIdSuPreferencia)
	{
		ListaAlumnosCurso lista=ListaAlumnosCurso.getListaAlumnosCurso();
		Alumno AlumnoA = lista.buscarAlumnoPorDNI(pIdQuien);
		Alumno AlumnoB = lista.buscarAlumnoPorDNI(pIdSuPreferencia);
		AlumnoA.getListaPreferencias().anadirAlumno(AlumnoB);
	}

	public void empezarCurso()
	{
		this.lista.resetear();
	}

	public void ajustarParejasSegunPreferencias()
	{

	}
}
