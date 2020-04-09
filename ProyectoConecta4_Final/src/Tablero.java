public class Tablero {
	private int anchura;
	private int altura;
	private Casilla[][] tab;
	private static Tablero miTablero;
	
	/**
	 * Constructor del tablero
	 * @param pAnchura Anchura del tablero
	 * @param pAltura Altura del tablero
	 */
	private Tablero(int pAnchura, int pAltura) {
		anchura=pAnchura;
		altura=pAltura;
		tab = new Casilla[altura][anchura];
		for (int i = 0; i < altura; i++) {
			for (int k = 0; k < anchura; k++) {
				tab[i][k] = new Casilla();
			}
		}
	}
	/**
	 * Patrón Singleton del tablero
	 * @return Tablero
	 */
	public static Tablero getTablero() {
		if(miTablero==null) {
			miTablero=new Tablero(10,10);
		}
		return miTablero;
	}
	
	/**
	 * Determina si una casilla está o no ocupada
	 * @return True si está ocupada, False en caso contrario
	 */
	public boolean ocupado() {
		int i=0;
		int y=0;
		boolean salir=false;
		while(i<altura && !salir) {
			while(y<anchura && !salir) {
				if(tab[i][y].getFicha()!='*') {
					salir=true;
				}else {
					y++;
				}
			}
			i++;
		}
		return salir;
	}
	
	/**
	 * Muestra el tablero por pantalla
	 */
	public void imprimirTablero() {
		// Imprime el tablero en la terminal
		int ty = altura;
		int tx = anchura;
		for (int i = 0; i < ty; i++) {
			System.out.print("\n");
			for (int k = 0; k < tx; k++) {
				System.out.print(tab[i][k].getFicha());
			}
		}

	}
	
	/**
	 * Determina si en una posición del tablero existe ficha
	 * @param pX Fila
	 * @param pY Columna
	 * @return True si existe una ficha, False en caso contrario
	 */
	public boolean existeFicha(int pX,int pY) {
		if(tab[pX][pY].tieneFicha()) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * Dado unas coordenadas, determina de qué jugador es la ficha
	 * @param pX Fila
	 * @param pY Columna
	 * @return Jugador que tiene la ficha
	 */
	private Jugador getJugador(int pX,int pY) {
		if(tab[pX][pY].tieneFicha()) {
			return tab[pX][pY].casillaJugador();
		}else {
			return null;
		}
	}
	
	/**
	 * Dadas unas coordenadas, determina si el jugador tiene casillas adyacentes
	 * @param pX Fila
	 * @param pY Columna
	 * @return True si existen casillas adyacentes a la coordenada dada. False en caso contrario
	 */
	public boolean casillasAdyacentes(int pX,int pY) {
		Jugador j1=this.getJugador(pX, pY);
		if(j1!=null) {
			Jugador j11=tab[pX+1][pY].casillaJugador();
			Jugador j12=tab[pX][pY+1].casillaJugador();
			Jugador j13=tab[pX-1][pY].casillaJugador();
			Jugador j14=tab[pX][pY-1].casillaJugador();
			if(j11==j1 && j12==j1 && j13==j1 && j14==j1){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}

	}
	/**
	 * Dada una posición y un jugador, ocupa la casilla especificada
	 * @param pJug Jugador
	 * @param pX Fila
	 * @param pY Columna
	 */
	public void ocuparCasilla(Jugador pJug,int pY) {
		int f=buscarFila(pY);
		if(posCorrecta(f , pY-1)) {
			if (!existeFicha(f , pY - 1)) 
			{
				tab[f][pY - 1].setCasilla(pJug);
			} 
			else 
			{
				System.out.println("UPSS! Ficha ocupada...");
			}
		}
	}
	/**
	 * Determina si un jugador ha insertado las 4 fichas adyacentes
	 * @return True si el jugador ha insertado las fichas de forma correcta. False en caso contrario
	 */
	public boolean hayGanador() {
		if (buscarGanadorDiagonal() || buscarGanadorHorizontal() || buscarGanadorVertical())
			return true;
		else
			return false;
	}
	/**
	 * Determina si hay 4 fichas adyacentes en forma horizontal.
	 * @return True si hay 4 fichas adyacentes en forma horizontal. False en caso contrario
	 */
	public boolean buscarGanadorHorizontal() {
		boolean ganar=false;
		boolean salir1;
		boolean salir2;
		int f=0;
		int c;
		while(f<tab[0].length && !ganar ){
			salir1=false;
			salir2=false;
			c=0;
			while(c<tab.length && !ganar){
				salir1=false;
				salir2=false;
				if(tab[f][c].casillaJugador()!=null){
					Jugador act=tab[f][c].casillaJugador();
					int y=0;
					int cont=0;
					while(y<4 && !ganar && (!salir1 || !salir2)){
						if(posCorrecta(f,c+y) && tab[f][c].casillaJugador()==tab[f][c+y].casillaJugador() && c+y!=c){
							cont++;
						}else if(c+y!=c){
							salir1=true;
						}
						if(posCorrecta(f,c-y) && tab[f][c].casillaJugador()==tab[f][c-y].casillaJugador()  && c-y!=c){
							cont++;
						}else if (c-y!=c){
							salir2=true;
						}
						if(cont==3){
							ganar=true;
						}
						y++;
					}
				}
				c++;
			}
			f++;
		}
		if(ganar){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * Determina si hay 4 fichas adyacentes en forma vertical
	 * @return True si hay 4 fichas adyacentes verticalmente. False en caso contrario
	 */
	public boolean buscarGanadorVertical() {
		boolean ganar=false;
		int f=0;
		int c;
		boolean salir1;
		boolean salir2;
		while(f<tab[0].length && !ganar){
			salir1=false;
			salir2=false;
			c=0;
			while(c<tab.length && !ganar){
				salir1=false;
				salir2=false;
				if(tab[f][c].casillaJugador()!=null){
					Jugador act=tab[f][c].casillaJugador();
					int y=0;
					int cont=0;
					while(y<4 && !ganar && (!salir1 || !salir2)){
						if(posCorrecta(f+y,c) && tab[f][c].casillaJugador()==tab[f+y][c].casillaJugador() && f+y!=f){
							cont++;
						}else if(f+y!=f){
							salir1=true;
						}
						if(posCorrecta(f-y,c) && tab[f][c].casillaJugador()==tab[f-y][c].casillaJugador() && f-y!=f){
							cont++;
						}else if(f-y!=f){
							salir2=true;
						}
						if(cont==3){
							ganar=true;
						}
						y++;
					}
				}
				c++;
			}
			f++;
		}
		if(ganar){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * Determina si hay 4 fichas adyacentes en forma vertical
	 * @return True si hay 4 fichas adyacentes verticalmente. False en caso contrario
	 */
	public boolean buscarGanadorDiagonal() {
		boolean ganar=false;
		int f=0;
		int c=0;
		while(f<tab[0].length && !ganar){
			c=0;
			while(c<tab.length && !ganar){
				if(tab[f][c].casillaJugador()!=null){
					Jugador act=tab[f][c].casillaJugador();
					int y=0;
					int contArribIzq=0;
					int contArribDer=0;
					int contAbajoIzq=0;
					int contAbajoDer=0;
					while(y<4 && !ganar){
						if(posCorrecta(f+y,c+y) && tab[f][c].casillaJugador()==tab[f+y][c+y].casillaJugador() && f+y!=f && c+y!=c){
							contArribDer++;
						}
						if(posCorrecta(f-y,c+y) && tab[f][c].casillaJugador()==tab[f-y][c+y].casillaJugador() && f-y!=f && c+y!=c){
							contAbajoDer++;
						}
						if(posCorrecta(f-y,c-y) && tab[f][c].casillaJugador()==tab[f-y][c-y].casillaJugador() && f-y!=f && c-y!=c){
							contAbajoIzq++;
						}
						if(posCorrecta(f+y,c-y) && tab[f][c].casillaJugador()==tab[f+y][c-y].casillaJugador() && f+y!=f && c-y!=c){
							contArribIzq++;
						}
						if(contArribIzq==3 || contArribDer==3 || contAbajoIzq==3 || contAbajoDer==3){
							ganar=true;
						}
						y++;
					}
				}
				c++;
			}
			f++;
		}
		if(ganar){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * Vacía la tabla
	 */
	public void resetear(){
		tab = new Casilla[altura][anchura];
		for (int i = 0; i < altura; i++) {
			for (int k = 0; k < anchura; k++) {
				tab[i][k] = new Casilla();
			}
		}
	}
	
	/**
	 * Determina si la posición donde se inserta la ficha es correcta
	 * @param i Fila
	 * @param j Columna
	 * @return True si la posición es correcta. False en caso contrario
	 */
	private Boolean posCorrecta(int i, int j) {
		if (i < tab.length && j < tab[0].length && i >= 0 & j >= 0)
			return true;
		else
			return false;

	}
	
	/**
	 * Determina dada la columna en qué fila se debe colocar la ficha
	 * @param pY Columna
	 * @return Fila
	 */
	private int buscarFila(int pY){
		boolean salir=false;
		int i=tab[0].length-1;
		while(!salir && i>=0){
			if(!tab[i][pY-1].tieneFicha()){
				salir=true;
			}else{
				i--;
			}
		}
		if(!salir){
			System.out.println("Columna llena");
			i=-1;
		}
		return i;
	}
}
