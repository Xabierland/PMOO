package packlaboratorio6;

public class ConceptoComplementoAsociado extends ConceptoComplemento 
{
	//atributos
	
	//constructora
	public ConceptoComplementoAsociado()
	{
		
	}
	//metodos
	public double calcularConcepto(double pCantidadBruta, int pNumeroDeHoras, int pAnosTrabajados)
	{
		pCantidadBruta=pCantidadBruta - (pCantidadBruta*0.05);
		pCantidadBruta=pCantidadBruta - 10;
		pCantidadBruta=pCantidadBruta*(pAnosTrabajados/10);
		return super.calcularConcepto(pCantidadBruta, pNumeroDeHoras, int pAnosTrabajados);
	}
}
