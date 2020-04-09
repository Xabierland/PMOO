package packlaboratorio7;

public class Hombre extends Alumno
{
	// constructora
	public Hombre(String pDNI, String pNombre, String pApellido, int pEdad)
	{
		super(pDNI,pNombre,pApellido,pEdad);
	}
	
	// metodos
	public boolean aceptar(Mujer pMujer)
	{
		ListaAlumnos lista=this.getListaPreferencias();
		boolean aceptar=false;
		if(lista.esta(pMujer))
		{
			aceptar=true;
		}
		return aceptar;
	}
	
	public void anadirPreferencia(Alumno pAlumno)
	 {
		ListaAlumnos lista=this.getListaPreferencias();
	 	if(pAlumno instanceof Mujer)
	 	{
	 		lista.anadirAlumno(pAlumno);
	 		System.out.println("Has añadido una mujer en la lista de preferencais de un hombre con exito");
	 	}
	 	else
	 	{
	 		System.out.println("Has intentado añadir un hombre a la lista de preferencias de un hombre, intentalo de nuevo");
	 	}
	 }
}
