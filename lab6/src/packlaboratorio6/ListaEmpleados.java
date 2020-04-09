package packlaboratorio6;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaEmpleados
{
	//atributos
	private ArrayList<Empleado> lista;
	//constructora
	public ListaEmpleados()
	{
		this.lista=new ArrayList<Empleado>();
	}
	//metodos
	private Iterator<Empleado> getIterator()
	{
		return this.lista.iterator();
	}
	public double obtenerDiferenciaMáxima()
	{
		double max,min;
		max=0;
		min=0;
		Iterator<Empleado> itr=this.getIterator();
		Empleado unEmpleado=null;
		while(itr.hasNext());
		{
			unEmpleado=itr.next();
			if(unEmpleado.calcularSueldo()>max)
			{
				max=unEmpleado.calcularSueldo();
			}
			if(unEmpleado.calcularSueldo()<min)
			{
				min=unEmpleado.calcularSueldo();
			}
		}
		return(max-min);
	}
}