package lab1;

public class Persona {
	//atributos
	private int idPersona;
	private String grupoSanguineo;
	private String nacionalidad;
	private String nombreCompleto;
	private int edad;
	
	//contructora
	public Persona(int pID, String pNac, String pGrupoSang, String pNomCom, int pEdad)
	{
		this.idPersona=pID;
		this.grupoSanguineo=pGrupoSang;
		this.nacionalidad=pNac;
		this.nombreCompleto=pNomCom;
		this.edad=pEdad;				
	}
	//metodos
	public boolean tieneMismaID(Persona pPersona)
	{
		boolean igual=false;
		if (this.idPersona==pPersona.idPersona)
		{
			igual=true;
		}
		return igual;
	}
	
	public boolean puedeConducir()
	{
		boolean mayoredad;
		mayoredad=false;
		if (this.nacionalidad=="Etiopia")
		{
			if (this.edad>=14)
			{
				mayoredad=true;
			}
		}
		else if (this.nacionalidad=="Australiana" || this.nacionalidad=="Estadounidense")
		{
			if (this.edad>=16)
			{
				mayoredad=true;
			}
		}
		else if (this.nacionalidad=="Britanico")
		{
			if (this.edad>=17)
			{
				mayoredad=true;
			}
		}
		else
		{
			if (this.edad>=18)
			{
				mayoredad=true;
			}
		}
		return mayoredad;
	}
	public char inicialNombre()
	{
		char inicial;
		inicial = this.nombreCompleto.charAt(0);
		return inicial;
	}
	public char inicialApellido()
	{
		char inicial;
		inicial=' ';
		int cont;
		cont=this.nombreCompleto.length()-1;
		boolean salir=false;

		while (!salir)
		{
			if (this.nombreCompleto.charAt(cont)==' ')
			{
				salir=true;
				cont=cont+1;
				inicial = this.nombreCompleto.charAt(cont);
			}
			else
			{
				cont=cont-1;
			}
		}
		return inicial;
	}
	
	public boolean puedeDonarleSangre(Persona pPersona)
	{
		boolean puede=false;
		int last=pPersona.grupoSanguineo.length()-1;
		
		if (this.grupoSanguineo=="0+")
		{
			if(pPersona.grupoSanguineo.charAt(last)=='+')
			{
				puede=true;
			}
		}
		
		if (this.grupoSanguineo=="0-")
		{
			puede=true;
		}
		
		if (this.grupoSanguineo=="A+")
		{
			if(pPersona.grupoSanguineo.charAt(0)=='A')
			{
				if(pPersona.grupoSanguineo.charAt(last)=='+')
				{
					puede=true;
				}
			}
		}
		
		if (this.grupoSanguineo=="A-")
		{
			if(pPersona.grupoSanguineo.charAt(0)=='A')
			{
				puede=true;
			}
		}
		
		if (this.grupoSanguineo=="B+")
		{
			if(pPersona.grupoSanguineo.charAt(0)=='B' || pPersona.grupoSanguineo.charAt(1)=='B')
			{
				if(pPersona.grupoSanguineo.charAt(last)=='+')
				{
					puede=true;
				}
			}
		}
		
		if (this.grupoSanguineo=="B-")
		{
			if(pPersona.grupoSanguineo.charAt(0)=='B' || pPersona.grupoSanguineo.charAt(1)=='B')
			{				
				puede=true;
			}
		}
		
		if (this.grupoSanguineo=="AB+")
		{
			if(pPersona.grupoSanguineo=="AB+")
			{
				puede=true;
			}
		}
		
		if (this.grupoSanguineo=="AB-")
		{
			if (pPersona.grupoSanguineo.charAt(0)=='A' && pPersona.grupoSanguineo.charAt(1)=='B')
			{
				puede=true;
			}
		}
			
		return puede;
	}
}
