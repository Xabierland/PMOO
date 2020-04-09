import java.util.Scanner;

public class Teclado {
	//Atributos
	private static Teclado miTeclado;
	private Scanner sc;
	//Constructora
	private Teclado() {
		sc = new Scanner (System.in);
	}
	//Metodos
	
	/**
	 * Obtiene el lector de datos por consola
	 * @return Lector de datos
	 */
	public static Teclado getTeclado() {
		if (miTeclado==null) {
			miTeclado=new Teclado();
		}
		return miTeclado;
	}
	
	/**
	 * Lee de consola una cadena de caracteres
	 * @return La cadena de caracteres leída
	 */
	public String leerString(){
		String entrada=sc.nextLine();
		if (entrada.equals("1") ||(entrada.equals("2"))){
			return entrada;
		}
		else {
			System.out.println("No has introducido ningun numero");
			return "";		
		}
	}
	
	/**
	 * Lee en la decisión del usuario de continuar o no la partida
	 * @return Decisión del usuario
	 */
	public String leer2Personas() {
		String numero=sc.nextLine();
		return numero;
	}
	
	public int leerEntero()
	{
		int numero=sc.nextInt();
		return numero;
	}
	
	/**
	 * Pide el nombre del jugador al usaurio
	 * @param id ID de jugador (orden)
	 * @return Nombre del jugador
	 */
	public Jugador escribirJugador(int id) {
		System.out.println("Escribe el nombre del jugador");
		Persona j1=null;
		String nombre=sc.nextLine();
		j1=new Persona(nombre);
		return j1;
	}
	
	/**
	 * Pide al usuario la columna en la que insertar la ficha
	 * @return Columna
	 */
	public String insertarFicha() {
			System.out.println("ï¿½En quï¿½ columna lo quieres aï¿½adir?");
			String entrada1=sc.nextLine();
			if (!(entrada1.equals("1") ||entrada1.equals("2") || entrada1.equals("3") || entrada1.equals("4") || entrada1.equals("5") ||entrada1.equals("6") || entrada1.equals("7") ||entrada1.equals("8") || entrada1.equals("9")) || entrada1.equals("10")){
				System.out.println("Escribe un numero correcto por favor");
				return "-1";
			}
			else{
				return entrada1;
			}
}}