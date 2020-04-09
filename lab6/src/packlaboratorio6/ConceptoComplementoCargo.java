package packlaboratorio6;

public class ConceptoComplementoCargo extends ConceptoComplemento 
{
	//atributos
	
	//constructora
	public ConceptoComplementoCargo()
	{
		
	}
	//metodos
	public double calcularConcepto(double pCantidadBruta, int pNumeroDeHoras, int pAnosTrabajados)
	{
		pCantidadBruta=pCantidadBruta - (pCantidadBruta*0.05);
		pCantidadBruta=pCantidadBruta - 20;
		return super.calcularConcepto(pCantidadBruta, pNumeroDeHoras, int pAnosTrabajados);
	}
}
