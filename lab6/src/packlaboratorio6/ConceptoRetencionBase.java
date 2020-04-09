package packlaboratorio6;

public class ConceptoRetencionBase extends ConceptoRetencion 
{
	//atributos
	
	//constructora
	public ConceptoRetencionBase()
	{
		
	}
	//metodos
	public double calcularConcepto(double pCantidadBruta, int pNumeroDeHoras)
	{
		pCantidadBruta=pCantidadBruta - (pCantidadBruta*0.05);
		return super.calcularConcepto(pCantidadBruta, pNumeroDeHoras);
	}
}
