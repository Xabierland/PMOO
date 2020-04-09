package packlaboratorio6;

public abstract class Concepto {

	//atributos
	
	//contructora
	public Concepto()
	{
		
	}
	//metodos
	public double calcularConcepto(double pCantidadBruta, int pNumeroDeHoras, int pAnosTrabajados)
	{
		double Concepto=0;
		Concepto=pCantidadBruta * pNumeroDeHoras;
		return Concepto;
	}
}
