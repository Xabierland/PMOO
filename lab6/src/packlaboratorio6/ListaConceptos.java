package packlaboratorio6;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaConceptos
{
	//atributos
	private ArrayList<Concepto> lista;
	
	//constructora
	public ListaConceptos()
	{
		this.lista=new ArrayList<Concepto>();
	}
	//metodos
	private Iterator<Concepto> getIterator()
	{
		return this.lista.iterator();
	}
	
	public void anadirConcepto(Concepto pConcep)
	{
		this.lista.add(pConcep);
	}
	
	public void eliminarConcepto(Concepto pConcep)
	{
		this.lista.remove(pConcep);
	}
	
	public int sumaConceptos(int pCantidadBruta, int NumeroDeHoras)
	{
		int acum=0;
		
		Iterator<Concepto> itr= this.getIterator();
		while(itr.hasNext())
		{
			
		}
		return acum;
	}
}