package packlaboratorio7;

import java.util.*;

public class ListaParejas
{
	// atributos
	private ArrayList<Pareja> lista;
	private static ListaParejas miListaParejas;

	// constructora
	private ListaParejas()
	{
		this.lista=new ArrayList<Pareja>();
	}
	
	//metdos
	public static ListaParejas getListaParejas()
	{
		if(ListaParejas.miListaParejas==null)
		{
			ListaParejas.miListaParejas=new ListaParejas();
			System.out.println("Creada la unica instancia del Lista de Parejas");
		}
		else
		{
			System.out.println("Se ha devuelto la unica instancia del Lista de Parejas");
		}
		return ListaParejas.miListaParejas;
	}

	private Iterator<Pareja> getIterador()
	{
		return this.lista.iterator();
	}

	public void anadirOrdenadoPareja(Pareja pPareja)
	{
		Iterator<Pareja> itr=this.getIterador();
		Pareja unaPareja;
		boolean encontrado=false;
		int index=0;
		while (itr.hasNext() && !encontrado)
		{
			unaPareja=itr.next();
			if(pPareja.getElla().getEdad()<=unaPareja.getElla().getEdad())
			{
				this.lista.add(index,pPareja);
			}
			index=index+1;
		}
	}

	public Alumno obtenerParejaDe(Alumno pAlumno)
	{
		Pareja unaPareja;
		Alumno unAlumno=null;
		Iterator<Pareja> itr=this.getIterador();
		boolean encontrado=false;
		
		while (itr.hasNext() && encontrado==true)
		{
			unaPareja=itr.next();
			if(unaPareja.esta(pAlumno))
			{
				encontrado=true;
				System.out.println("Se ha encontrado la pareja del alumno");
				if(pAlumno instanceof Hombre)
				{
					unAlumno=(Alumno)unaPareja.getElla();
				}
				else
				{
					unAlumno=(Alumno)unaPareja.getEl();
				}
			}
		}
		if(encontrado==false)
		{
			unAlumno=null;
			System.out.println("No se ha encontrado la pareja del alumno");
		}
		return unAlumno;
	}

	/**
	 * post: si ha sido posible, se han reajustado las parejas. Si no ha sido posible,
	 *       la lista de parejas se ha dejado como al principio.
	 *       
	 *       Se utiliza una lista auxiliar para ir recolocando las parejas en orden descendente de
	 *       edad de la mujer, y una lista con todos los hombres disponibles.
	 *       Para cada mujer, se busca entre la lista de hombres disponibles uno con el que poder emparejarla
	 *       hasta llegar al final de la lista (en cuyo caso se modifica la lista de parejas dejando en su
	 *       lugar la lista de parejas auxiliar) o hasta encontrar una mujer que no se pueda emparejar (en 
	 *       cuyo caso el proceso termina, se muestra un aviso por pantalla y se deja la lista de parejas
	 *       como estaba).
	 * 
	 *       (Ver el enunciado del ejercicio para más detalles sobre el algoritmo de reajuste de
	 *       las parejas.)
	 */
	public void reajustarParejas()
	{
		ListaAlumnos listaHombres=this.generarListaSoloHombres();
		if(listaHombres!=null)
		{
			
		}
	}

	private ListaAlumnos generarListaSoloHombres()
	{
		ListaAlumnosCurso listaCurso=ListaAlumnosCurso.getListaAlumnosCurso();
		return listaCurso.getsoloHombres();
	}

	public void resetear()
	{
		this.lista=new ArrayList<Pareja>();
	}
}

