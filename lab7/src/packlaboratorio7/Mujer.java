package packlaboratorio7;

public class Mujer extends Alumno
{
	// constructora
	public Mujer(String pDNI, String pNombre, String pApellido, int pEdad)
	{
		super(pDNI,pNombre,pApellido,pEdad);
	}

	//metodos
	public int getEdad()
	{
		return super.getEdad();
	}

	/**
	 * 
	 * @param pHombreDisponibles
	 * @return devuelve el primer Hombre de los que hay en la lista de preferencias
	 *         de la mujer que se encuentre en la lista de alumnos pHombresDisponibles
	 *         y que acepta a la mujer actual (esto es, la tiene entre sus propias
	 *         preferencias).
	 *         Si no existe tal hombre, se devuelve el objeto null.
	 *         Si en la lista pHombresDisponibles se encuentra alguna mujer, se muestra
	 *         un aviso por consola y se devuelve null.
	 */
	public Hombre emparejar(ListaAlumnos pHombreDisponibles)
	{
		ListaAlumnos listaPref=this.getListaPreferencias();
		ListaAlumnos listaHomb=ListaAlumnosCurso.getListaAlumnosCurso().getsoloHombres();
		Alumno unAlumno=null;
		int i=0;
		boolean encontrado=false;
		
		while(i<listaHomb.obtenerNumeroAlumnos() && !encontrado)
		{
			unAlumno=listaHomb.getAlumnoEnPos(i);
			if (listaPref.esta(unAlumno))
			{
				encontrado=true;
			}
		}
		if (!encontrado)
		{
			unAlumno=null;
		}
		return (Hombre)unAlumno;
	}

	public void anadirPreferencia(Alumno pAlumno)
	{
		ListaAlumnos lista=getListaPreferencias();
		if (pAlumno instanceof Hombre)
		{
			lista.anadirAlumno(pAlumno);
			System.out.println("El hombre ha sido introducido exitosamente en la lista de preferencias a una mujer");
		}
		else
		{
			System.out.println("Has intentado introducir una mujer en la lista de preferencia de una mujer");
		}
	}
}
