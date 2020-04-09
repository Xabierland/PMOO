package packlaboratorio6;

public class ConceptoRetencionExtra extends ConceptoRetencion 
{
	//atributos
	
	//constructora
	public ConceptoRetencionExtra()
	{
		
	}
	//metodos
	public double calcularConcepto(double pCantidadBruta, int pNumeroDeHoras)
	{
		pCantidadBruta=pCantidadBruta - (pCantidadBruta*0.1);
		return super.calcularConcepto(pCantidadBruta, pNumeroDeHoras);
	}
}
