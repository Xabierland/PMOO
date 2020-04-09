package packlaboratorio6;

public class ConceptoComplementoDestino extends ConceptoComplemento 
{
	//atributos
	
	//constructora
	public ConceptoComplementoDestino()
	{
		
	}
	//metodos
	public double calcularConcepto(double pCantidadBruta, int pNumeroDeHoras, int pAnosTrabajados)
	{
		pCantidadBruta=pCantidadBruta - (pCantidadBruta*0.05);
		pCantidadBruta=pCantidadBruta - 50;
		return super.calcularConcepto(pCantidadBruta, pNumeroDeHoras, int pAnosTrabajados);
	}
}
