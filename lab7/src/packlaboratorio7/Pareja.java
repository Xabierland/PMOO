package packlaboratorio7;

public class Pareja
{
	// atributos
	private Alumno Hombre;
	private Alumno Mujer;
	// constructora
	public Pareja(Alumno pAlumno1, Alumno pAlumno2)
	{
		if (pAlumno1 instanceof Hombre && pAlumno2 instanceof Mujer)
		{
			this.Hombre=pAlumno1;
			this.Mujer=pAlumno2;
			System.out.println("La pareja se formo con exito");
		}
		else if(pAlumno1 instanceof Mujer && pAlumno2 instanceof Hombre)
		{
			this.Hombre=pAlumno2;
			this.Mujer=pAlumno1;
			System.out.println("La pareja se formo con exito");
		}
		else
		{
			this.Hombre=null;
			this.Mujer=null;
			System.out.println("La pareja no se pudo formar");
		}
	}

	// otros métodos
	public Mujer getElla()
	{
		return (Mujer)this.Mujer;
	}
	
	public Hombre getEl()
	{
		return (Hombre)this.Hombre;
	}

	public boolean esta(Alumno pAlumno)
	{
		boolean esta=false;
		if(this.Hombre==pAlumno || this.Mujer==pAlumno)
		{
			esta=true;
			System.out.println("El alumno esta en la pareja");
		}
		else
		{
			esta=false;
			System.out.println("El alumno no esta en la pareja");
		}
		return esta;
	}
}
