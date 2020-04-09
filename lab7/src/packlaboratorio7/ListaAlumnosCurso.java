package packlaboratorio7;

import java.util.*;

public class ListaAlumnosCurso
{
	//atributos
	private ArrayList<Alumno> lista; 
	private static ListaAlumnosCurso miListaCurso;
	
	//constructora
	private ListaAlumnosCurso()
	{
		this.lista=new ArrayList<Alumno>();
	}

	//metodos
	public static ListaAlumnosCurso getListaAlumnosCurso()
	{
		if(miListaCurso==null)
		{
			ListaAlumnosCurso.miListaCurso = new ListaAlumnosCurso();
			System.out.println("Se ha creado la unica instancia de la Lista de alumnos del curso");
		}
		else
		{
			System.out.println("Se ha devuelto la unica instancia de la lista de alumnos del curso");
		}
		return ListaAlumnosCurso.miListaCurso;
	}

	public void anadirAlumnoCurso(Alumno pAlumno)
	{
		if(!this.existeUnAlumnoConMismoDNI(pAlumno))
		{
			this.lista.add(pAlumno);
			System.out.println("Se ha añadido el usuario con exito");
		}
		else
		{
			System.out.println("Ya existe alguien con ese DNI y no se a añadido a la lista");
		}
	}

	private Iterator<Alumno> getIterador()
	{
		return this.lista.iterator();
	}

	private boolean existeUnAlumnoConMismoDNI(Alumno pAlumno)
	{
		 Alumno unAlumno=null;
		 Iterator<Alumno> itr=this.getIterador();
		 boolean encontrado=false;
		 while(itr.hasNext()&&!encontrado)
		 {
			 unAlumno=itr.next();
			 if(unAlumno.tieneElMismoDNI(pAlumno))
			 {
				 encontrado=true;
				 System.out.println("SI existe un alumno con el mismo DNI");
			 }
		 }
		 if(!encontrado)
		 {
			 encontrado=false;
			 System.out.println("NO existe un alumno con el mismo DNI");
		 }
		 return encontrado;
	}

	public Alumno buscarAlumnoPorDNI(String pDNI)
	{
		 Alumno unAlumno=null;
		 Iterator<Alumno> itr=this.getIterador();
		 boolean encontrado=false;
		 while(itr.hasNext() && !encontrado)
		 {
			 unAlumno=itr.next();
			 if(unAlumno.tieneEsteDNI(pDNI))
			 {
				 encontrado=true;
				 System.out.println("Se ha encontrado al usuario");
			 }
		 }
		 if(encontrado==false)
		 {
			 unAlumno=null;
			 System.out.println("No se ha encontrado al usuario");
		 }
		 return unAlumno;
	}

	public boolean hayAlumnosSinPareja()
	{
		ListaParejas lista=ListaParejas.getListaParejas();
		boolean sinpareja=false;
		Alumno unAlumno=null;
		Iterator<Alumno> itr=this.getIterador();
		while(itr.hasNext() && !sinpareja)
		{
			unAlumno=itr.next();
			if(lista.obtenerParejaDe(unAlumno)!=null)
			{
				sinpareja=true;
				System.out.println("Hay un alumno sin pareja");
			}
		}
		if(!sinpareja)
		{
			System.out.println("Todos los alumnos tienen pareja");
		}
		return sinpareja;
	}

	public ListaAlumnos getsoloHombres()
	{
		Iterator<Alumno> itr=this.getIterador();
		ListaAlumnos soloHombres=new ListaAlumnos();
		Alumno unAlumno;
		while(itr.hasNext())
		{
			unAlumno=itr.next();
			if (unAlumno instanceof Hombre)
			{
				soloHombres.anadirAlumno(unAlumno);
			}
		}
		return soloHombres;
	}
	
 	public void resetear()
	{
		this.lista=new ArrayList<Alumno>();
	}
}
