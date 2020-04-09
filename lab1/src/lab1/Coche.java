package lab1;

public class Coche {
	//atributos
	private String matricula;
	private String marcaModelo;
	private Persona propietario;
	
	//contructora
	public Coche(String pMat,String pMarcaM)
	{
		this.matricula=pMat;
		this.marcaModelo=pMarcaM;
		this.propietario=null;
	}
	//metodo
	public void cambiarDePropietario(Persona pPersona)
	{
		this.propietario=pPersona;
	}
	
	public boolean esElPropietario(Persona pPersona)
	{
		boolean prop=false;
		if (this.propietario==pPersona)
		{
			prop=true;
		}
		return prop;
	}
}