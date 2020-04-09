import java.util.ArrayList;
import java.util.Iterator;

public class ControlJuego {
	
	private Persona ganador;
	private ArrayList<Persona> participantes;
	
	/**
	 * Constructor principal
	 */
	public ControlJuego() {
		participantes=new ArrayList<Persona>();
	}
	
	/**
	 * Obtiene el número de participantes en la actual partida
	 * @return Número de participantes
	 */
	public int getNumParticipantes() {
		return this.participantes.size();
	}
	/**
	 * Configura el juego individual (Contra Inteligencia Artificial)
	 */
	public void jugarIndividual() {
		boolean finDelJuego=false;
		while (!finDelJuego) {
			int turno=1;
			Iterator<Persona> itr=this.getIterador();
			Jugador jugador1= itr.next();
			Persona juega1=(Persona)jugador1;
			IA juega2=new IA();
			int i=1;
			Persona ganador1= null;
			IA ganador2=null;
			while(turno < 41 && ganador1==null && ganador2==null) {
				Tablero.getTablero().imprimirTablero();
				if(turno==1){
					juega1.jugar();
					turno++;
					i=2;
				}else {
					if(i==1){
						juega1.jugar();
						i=2;
						turno++;
					}else{
						juega2.jugar();
						i=1;
						turno++;
					}
					if(Tablero.getTablero().hayGanador()) {
						if(i==1){
							ganador2=juega2;//IA gana
						}else{
							ganador1=juega1;
							this.ganador=juega1;
						}
					}
				}
			}
			if (ganador==null) {
				System.out.println("No hay ganador");
			}
			else {
				Tablero.getTablero().imprimirTablero();
				System.out.println("");
				if(ganador1!=null) {
					System.out.println("El ganador es el jugador: " + ganador1.escribirNombre());
				}else if(ganador2!=null){
					System.out.println("El ganador es el jugador: " + ganador2.escribirNombre());
				}else{
					System.out.println("Se acabo la partida! Se agotaron los turnos");
				}
				Ranking rk = Ranking.getMiRanking();
				if(rk.getJugador(ganador.escribirNombre())!=null) {
					Persona ganadorEnLista=(Persona)rk.getJugador(this.ganador.escribirNombre());
					Persona ganadorAgregar=new Persona(ganadorEnLista.escribirNombre());
					ganadorAgregar.setPuntuacion(ganadorEnLista.getPuntuacion()+1);
					rk.eliminarJugador(ganadorEnLista);
					rk.anadirJugador(ganadorAgregar);
				}else {
					ganador.setPuntuacion(1);
					rk.anadirJugador(this.ganador);
				}
			}
			
			System.out.println("----------------------------------------");
			System.out.println("ï¿½Quieres jugar otra partida?");
			System.out.println("Pulsa 1 para jugar otra partida");
			System.out.println("Pulsa 2 para volver al menu principal");
			System.out.println("Pulsa cualquier otro boton para salir del juego");
			String entrada=Teclado.getTeclado().leer2Personas();
			if (entrada.equals("1")) {
				Tablero.getTablero().resetear();
				
				System.out.println("----------------------------------------");
				System.out.println("Iniciando una nueva partida...");
				try {
					Thread.sleep(3*1000);
					
				} catch (Exception e) {
					System.out.println(e);
				}
				this.jugarIndividual();
				finDelJuego=true;
				System.out.println("----------------------------------------");
			}else if(entrada.equals("2")){
				finDelJuego=true;
				Tablero.getTablero().resetear();
				Conecta4.getMiConecta4().jugar();
			}
			else {
				System.out.println("Has salido del juego");
				finDelJuego=true;
			}
		}
	}
	
	/**
	 * Modo de juego multijugador
	 */
	public void jugarDosPersonas() {
		boolean finDelJuego=false;
		while (!finDelJuego) {
			int turno=1;
			Iterator<Persona> itr=this.getIterador();
			Persona jugador1= itr.next();
			Persona jugador2= itr.next();
			Persona juega=null;
			Persona ganador= null;
			juega=(Persona)jugador1;
			while(turno < 41 && ganador==null) {
				Tablero.getTablero().imprimirTablero();
				if(turno==1){
					((Persona) juega).jugar();
					turno++;
					juega=jugador2;
				}else {
					((Persona)juega).jugar();
					turno++;
					if(Tablero.getTablero().hayGanador()) {
						ganador=juega;
						this.ganador=(Persona)juega;
					}
					else if(juega==jugador1) {
						juega=jugador2;
					}else {
						juega=jugador1;
					}
				}
			}
			if (ganador==null) {
				System.out.println("Se acabo la partida! Se agotaron los turnos");
			}
			else {
				Tablero.getTablero().imprimirTablero();
				System.out.println("");
				System.out.println("El ganador es el jugador: "+ganador.escribirNombre());
				
				Ranking rk = Ranking.getMiRanking();
				if(rk.getJugador(this.ganador.escribirNombre())!=null) {
					
					Persona ganadorEnLista=(Persona)rk.getJugador(this.ganador.escribirNombre());
					Persona ganadorDefinitivo = new Persona(ganadorEnLista.escribirNombre());
					ganadorDefinitivo.setPuntuacion(ganadorEnLista.getPuntuacion()+1);
					rk.eliminarJugador(ganadorEnLista);
					rk.anadirJugador(ganadorDefinitivo);
				}else {
					Persona ganadorDef=new Persona(ganador.escribirNombre());
					ganadorDef.setPuntuacion(1);
					rk.anadirJugador(ganadorDef);
				}
			}
			System.out.println("----------------------------------------");
			System.out.println("ï¿½Quieres jugar otra partida?");
			System.out.println("Pulsa 1 para jugar otra partida");
			System.out.println("Pulsa 2 para volver al menu principal");
			System.out.println("Pulsa cualquier otro boton para salir del juego");
			String entrada=Teclado.getTeclado().leer2Personas();
			System.err.println("ENTRADA ES "+entrada);
			if (entrada.equals("1")) {
				Tablero.getTablero().resetear();
				
				System.out.println("----------------------------------------");
				System.out.println("Iniciando una nueva partida...");

				  try {
			            Thread.sleep(3*1000);
			         } catch (Exception e) {
			            System.out.println(e);
			         }
				  this.jugarDosPersonas();
				  finDelJuego=true;
				 System.out.println("----------------------------------------");
			}else if(entrada.equals("2")){
				finDelJuego=true;
				Tablero.getTablero().resetear();
				Conecta4.getMiConecta4().jugar();
			}
			else {
				System.out.println("Has salido del juego");
				finDelJuego=true;
			}
		}
	}

	/**
	 * Iterador de participantes
	 * @return Iterador
	 */
	private Iterator<Persona> getIterador() {
		// TODO Auto-generated method stub
		return this.participantes.iterator();
	}

	/**
	 * Agrega un jugador a la partida
	 * @param pParticipante Jugador agregado
	 */
	public void agregarParticipante(Persona pParticipante) {
		this.participantes.add(pParticipante);
	}
}
