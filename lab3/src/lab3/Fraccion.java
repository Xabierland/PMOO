package lab3;

public class Fraccion implements IFraccion
{
	//Atributos
	private int numerador;
	private int denominador;
	
	//Constructoras
	public Fraccion(int pNumerador, int pDenominador)
	{
		if (pDenominador!=0)
		{
			this.numerador=pNumerador;
			this.denominador=pDenominador;
		}
		else
		{
			System.out.println("No se puede crear una fraccion con denominador cero...");
		}
	}
	
	public int getNumerador()
	{
		return this.numerador;
	}

	public int getDenominador()
	{
		return this.denominador;
	}

 	private int mcd()
	{
 		int n=this.numerador;
 		int d=this.denominador;
 		int rest=1;
 		
 		while (rest!=0)
 		{
 			rest=n%d;
 	 		n=d;
 	 		d=rest;
 		}
 		
 		return n;
	}
	
	public void simplificar()
	{
		int mcd=this.mcd();
		this.numerador=this.numerador/mcd;
		this.denominador=this.denominador/mcd;
		
		if(this.denominador<0)
		{
			this.denominador=this.denominador*-1;
			this.numerador=this.numerador*-1;
		}
	}

	public Fraccion sumar(Fraccion pFraccion)
	{
		
		Fraccion suma = new Fraccion(0,0);
		suma.numerador=this.numerador*pFraccion.denominador + this.denominador*pFraccion.numerador;
		suma.denominador=this.denominador*pFraccion.denominador;
		suma.simplificar();
		
		//String r;
		//String strNum =String.format("%01d", suma.numerador);
		//String strDen =String.format("%01d", suma.denominador);
		//r = strNum + "/" + strDen;
		//System.out.println(r);
		
		return suma;
	}

	public Fraccion restar(Fraccion pFraccion)
	{
		Fraccion resta = new Fraccion(0,0);
		resta.numerador=this.numerador*pFraccion.denominador - this.denominador*pFraccion.numerador;
		resta.denominador=this.denominador*pFraccion.denominador;
		resta.simplificar();
		
		String r;
		String strNum =String.format("%01d", resta.numerador);
		String strDen =String.format("%01d", resta.denominador);
		r = strNum + "/" + strDen;
		System.out.println(r);
		
		return resta;
	}

	public Fraccion multiplicar(Fraccion pFraccion)
	{
		Fraccion multi = new Fraccion(0,0);
		multi.numerador=this.numerador*pFraccion.numerador;
		multi.denominador=this.denominador*pFraccion.denominador;
		multi.simplificar();
		return multi;
	}

	public Fraccion dividir(Fraccion pFraccion)
	{
		Fraccion div = new Fraccion(0,0);
		div.numerador=this.numerador*pFraccion.denominador;
		div.denominador=this.denominador*pFraccion.numerador;
		div.simplificar();
		return div;
	}

	public boolean esIgualQue(Fraccion pFraccion)
	{
		boolean igual=false;
		int a1=this.numerador;
		int b1=pFraccion.numerador;
		int a2=this.denominador;
		int b2=pFraccion.denominador;
		if (a1==b1 && a2==b2)
		{
			igual=true;
		}
		return igual;
	}

	public boolean esMayorQue(Fraccion pFraccion)
	{
		boolean mayor=false;
		double a=this.numerador/this.denominador;
		double b=pFraccion.numerador/pFraccion.denominador;
		if (a>b)
		{
			mayor=true;
		}
		return mayor;
	}

	public boolean esMenorQue(Fraccion pFraccion)
	{
		boolean mayor=false;
		double a=this.numerador/this.denominador;
		double b=pFraccion.numerador/pFraccion.denominador;
		if (a<b)
		{
			mayor=true;
		}
		return mayor;
	}
}
