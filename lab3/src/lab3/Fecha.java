package packlaboratorio3;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha implements IFecha
{
	//atributos
	private int dia;
	private int mes;
	private int annio;
	
	
	//constructoras
	public Fecha(int pDia, int pMes, int pAnnio)
	{
		this.dia = pDia;
		this.mes = pMes;
		this.annio = pAnnio;
		
		if (!this.esCorrecta())
		{
			Calendar c = new GregorianCalendar();
			this.dia = c.get(Calendar.DATE);     // los dias empiezan a contar desde uno, pero
			this.mes = c.get(Calendar.MONTH) +1; // los meses empiezan a contar desde cero
			this.annio = c.get(Calendar.YEAR);			
		}
		
	}
		
	//otros métodos

	@Override
	public String toString()
	{
		String strDia = String.format("%02d", this.dia); 
		String strMes = String.format("%02d", this.mes);
		String strAnnio = String.format("%04d", this.annio);
		
		return strDia + "/" + strMes + "/" + strAnnio;
	}
	
	
	private boolean esCorrecta()
	{
		boolean es=false;
		if ((this.annio>0)&&(this.mes<=12)&&(this.mes>=1)){
			if(((this.mes==1)||(this.mes==3)||(this.mes==5)||(this.mes==7)||(this.mes==8)||(this.mes==10)||(this.mes==12))&&(this.dia<=31)){
				es=true;
			}
			else if(((this.mes==4)||(this.mes==6)||(this.mes==9)||(this.mes==11))&&(this.dia<=30)){
				es=true;
			}
			else if(((this.annio % 4 == 0)&&((this.annio % 100 !=0)||(this.annio % 400 == 0)))&&(this.dia<=29)){
				es=true;
			}	
			else if(!((this.annio % 4 == 0)&&(this.annio % 100 !=0)||(this.annio % 400 == 0))&&(this.dia<=28)){
				es=true;
				}
			}
		return es;
		
	}

	@Override
	public void incrementar() {
		if(((this.mes==1)||(this.mes==3)||(this.mes==5)||(this.mes==7)||(this.mes==8)||(this.mes==10)||(this.mes==12))&&(this.dia<31)){
			this.dia=this.dia+1;
		}
		else if(((this.mes==1)||(this.mes==3)||(this.mes==5)||(this.mes==7)||(this.mes==8)||(this.mes==10))&&(this.dia==31)){
			this.dia=1;
			this.mes=this.mes+1;
		}
		else if((this.mes==12)&&(this.dia==31)){
			this.dia=1;
			this.mes=1;
			this.annio=this.annio+1;
		}
		else if(((this.mes==4)||(this.mes==6)||(this.mes==9)||(this.mes==11))&&(this.dia<30)){	
			this.dia=this.dia+1;
		}
		else if(((this.mes==4)||(this.mes==6)||(this.mes==9)||(this.mes==11))&&(this.dia==30)){	
			this.dia=1;
			this.mes=this.mes+1;			
		}		
		else if(((this.mes==2)&&((this.annio % 4 == 0)&&((this.annio % 100 !=0)||(this.annio % 400 == 0))))&&(this.dia<29)){
			this.dia=this.dia+1;
		}
		else if(((this.mes==2)&&((this.annio % 4 == 0)&&((this.annio % 100 !=0)||(this.annio % 400 == 0))))&&(this.dia==29)){		
			this.dia=1;
			this.mes=3;			
		}
		else if(((this.mes==2)&&!((this.annio % 4 == 0)&&((this.annio % 100 !=0)||(this.annio % 400 == 0))))&&(this.dia<28)){
			this.dia=this.dia+1;
		}
		else {
			this.dia=1;
			this.mes=3;			
		}
		
	}
	
	@Override
	public void decrementar() {
		if(this.dia>1){
			this.dia=this.dia-1;			
		}
		else if((this.mes==1)&&(this.dia==1)){
			this.mes=12;
			this.dia=31;
			this.annio=this.annio-1;
		}
		 else if((this.dia==1)&&(this.mes==2||this.mes==4||this.mes==6||this.mes==8||this.mes==9||this.mes==11)){
			this.mes=this.mes-1;
			this.dia=31;
		}
		else if((this.dia==1)&&(this.mes==5||this.mes==7||this.mes==10||this.mes==12)){
			this.dia=30;
			this.mes=this.mes-1;
		} 
		else if((this.dia==1)&&(this.mes==3)&&(this.annio % 4 == 0)&&((this.annio % 100 !=0)||(this.annio % 400 == 0))){
			this.mes=2;
			this.dia=29;
		}
		else if((this.dia==1)&&(this.mes==3)&&(this.annio % 4 != 0)&&((this.annio % 100 !=0)||(this.annio % 400 == 0))){
			this.mes=this.mes-1;
			this.dia=28;
		}
	}
	}

