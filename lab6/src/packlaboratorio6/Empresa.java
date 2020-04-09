package packlaboratorio6;

public class Empresa
{
	//atributo
	private ListaEmpleados lista;
	private static Empresa miEmpresa;
	
	//contructora
	private Empresa()
	{
		this.lista=new ListaEmpleados();
	}
	//metodos
	public static Empresa getEmpresa()
	{
		if (Empresa.miEmpresa==null)
		{
			Empresa.miEmpresa=new Empresa();
		}
		return Empresa.miEmpresa;
	}
	public double obtenerDiferenciaMáxima()
	{
		return this.lista.obtenerDiferenciaMáxima();
	}
}