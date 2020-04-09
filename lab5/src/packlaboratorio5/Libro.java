package packlaboratorio5;

public class Libro
{
	// atributos
	private String titulo;
	private String autor;
	private int idLibro;
	
	
	// constructora
	
	public Libro(String pTitulo, String pAutor, int pIdLibro)
	{
		this.titulo=pTitulo;
		this.autor=pAutor;
		this.idLibro=pIdLibro;
	} 

	// otros métodos
	
	public boolean tieneEsteId (int pIdLibro)
	{
		boolean igual=false;
		if(this.idLibro==pIdLibro)
		{
			igual=true;
			System.out.println("La ID recibida es igual que la del libro con el que se compara");
		}
		else
		{
			System.out.println("La ID recibida NO es igual que la del libro con el que se compara");
		}
		return igual;
	}
	
	public boolean tieneElMismoId (Libro pLibro)
	{
		boolean igual=false;
		if(this.idLibro==pLibro.idLibro)
		{
			igual=true;
			System.out.println("La ID del libro recibido es igual que la del libro con el que se compara");
		}
		else
		{
			System.out.println("La ID del libro recibido NO es igual que la del libro con el que se compara");
		}
		return igual;
	}
	
	public void imprimir()
	{
		String mens;
		mens=String.format("%s, escrito por %s", this.titulo, this.autor);
		System.out.println(mens);
	}
}
