
public class Conecta4 {
	private static Conecta4 miConecta4;
	private ControlJuego cj;
	/**
	 * Constructor
	 */
	private Conecta4() {
		//jugadores=new ListaJugadores();
		cj=new ControlJuego();
	}
	
	/**
	 * Máquina Abstracta de Estados (patrón Singleton)
	 * @return Partida
	 */
	public static Conecta4 getMiConecta4() {
		if(miConecta4==null) {
			miConecta4=new Conecta4();
		}
		return miConecta4;
	}
	
	/**
	 * Interfaz de jugada
	 */
	public void jugar() {
		
		boolean comenzarJuego=false;
		int intentos=4;
		int idJugador=1;
		System.out.println("");
		System.out.println("-------------------------------------");
		System.out.println("Bienvenido al Conecta4");
		System.out.println("-------------------------------------");
		while (!comenzarJuego && intentos!=0) {
			boolean seguir=false;
			if (cj.getNumParticipantes()<=2) {
				System.out.println("Pulsa 1 para anadir un jugador");
			}
			else {
				System.out.println("Ya hay dos jugadores, ï¿½Empieza a jugar!");
			}
			System.out.println("Pulsa 2 para comenzar el juego");
			String entrada="";
			entrada = Teclado.getTeclado().leerString();
			seguir=true;
			intentos=3;
			if (seguir==true) {
				if (entrada.equals("1") && cj.getNumParticipantes()<=2){
					Persona j1=(Persona) Teclado.getTeclado().escribirJugador(idJugador);
					cj.agregarParticipante(j1);
					idJugador++;
				}
				if (entrada.equals("2")) {
					if (cj.getNumParticipantes()==0) {
					System.out.println("No hay jugadores, insertalos a traves de la opcion 1");
					}else if(cj.getNumParticipantes()<2) {
						System.out.println("");
						System.out.println("Jugaras en el modo individual");
						comenzarJuego=true;
						cj.jugarIndividual();
					}
					else {
						System.out.println("");
						System.out.println("Jugareis un uno contra uno entre vosotros");
						comenzarJuego=true;
						cj.jugarDosPersonas();
					}
				}
			}
			
			
			
		} 
		
	}
}
