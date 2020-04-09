package packlaboratorio7;

import java.util.*;

public class ListaAlumnos
{
	// atributos
	private ArrayList<Alumno> lista;
	
	// constructora
	public ListaAlumnos()
	{
		this.lista=new ArrayList<Alumno>();
	}

	//metodos
	public void anadirAlumno(Alumno pAlumno)
	{
		this.lista.add(pAlumno);
	}	

	public void retirarAlumno(Alumno pAlumno)
	{
		this.lista.remove(pAlumno);
	}

	public int obtenerNumeroAlumnos()
	{
		return this.lista.size();
	}

	public Alumno getAlumnoEnPos(int pPos)
	{
		return this.lista.get(pPos);
	}

	public boolean esta(Alumno pAlumno)
	{
		return this.lista.contains(pAlumno);
	}

}
