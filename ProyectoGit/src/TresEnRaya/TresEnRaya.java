//Tres en Raya con POO
package TresEnRaya;

import java.util.Random;

public class TresEnRaya {
	//Atributos
	private int[][] tablero;
	
	
	//Método Constructor
	public TresEnRaya() {
		tablero=new int [3][3];
		iniciar();
	}
	
	//Métodos
	public void mueveJugador1(int pos) {
		if (pos>=1 && pos <=3 && movimientoValido(pos)) {
			tablero[pos-1][0]=1;
		}
		if (pos>=4 && pos <=6 && movimientoValido(pos)) {
			tablero[pos-4][1]=1;
		}
		if (pos>=7 && pos <=9 && movimientoValido(pos)) {
			tablero[pos-7][2]=1;
		}
	}
	
	public void mueveJugador2(int pos) {
		if (pos>=1 && pos <=3 && movimientoValido(pos)) {
			tablero[pos-1][0]=2;
		}
		if (pos>=4 && pos <=6 && movimientoValido(pos)) {
			tablero[pos-4][1]=2;
		}
		if (pos>=7 && pos <=9 && movimientoValido(pos)) {
			tablero[pos-7][2]=2;
		}
	}
	
	public boolean movimientoValido(int pos) {
		if (pos>=1 && pos <=3 ) {
			if (tablero[pos-1][0]==0) {
				return true;
			}
		}
		if (pos>=4 && pos <=6) {
			if (tablero[pos-4][1]==0) {
				return true;
			}
		}
		if (pos>=7 && pos <=9) {
			if (tablero[pos-7][2]==0) {
				return true;
			}
		}
		return false;
	}
	
	public void mueveOrdenador1() {
		Random random=new Random();
		int pos=random.nextInt(9)+1;
		while(!movimientoValido(pos)) {
			pos=random.nextInt(9)+1;
		}
		if (pos>=1 && pos <=3 && movimientoValido(pos)) {
			tablero[pos-1][0]=1;
		}
		if (pos>=4 && pos <=6 && movimientoValido(pos)) {
			tablero[pos-4][1]=1;
		}
		if (pos>=7 && pos <=9 && movimientoValido(pos)) {
			tablero[pos-7][2]=1;
		}
	}
	
	public void mueveOrdenador2() {
		Random random=new Random();
		int pos=random.nextInt(9)+1;
		while(!movimientoValido(pos)) {
			pos=random.nextInt(9)+1;
		}
		if (pos>=1 && pos <=3 && movimientoValido(pos)) {
			tablero[pos-1][0]=2;
		}
		if (pos>=4 && pos <=6 && movimientoValido(pos)) {
			tablero[pos-4][1]=2;
		}
		if (pos>=7 && pos <=9 && movimientoValido(pos)) {
			tablero[pos-7][2]=2;
		}
	}
	
	public void iniciar() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				tablero [i][j]=0;
			}
		}
	}
	
	public boolean quedanMovimientos() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if(tablero [i][j]==0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean ganaJugador1() {
		if (tablero[0][1]==1 && tablero[1][1]==1 && tablero[2][2]==1) {
			return true;
		}
		if (tablero[0][2]==1 && tablero[1][1]==1 && tablero[2][0]==1) {
			return true;
		}
		//Horizontal
		if (tablero[0][0]==1 && tablero[1][0]==1 && tablero[2][0]==1) {
			return true;
		}
		if (tablero[0][1]==1 && tablero[1][1]==1 && tablero[2][1]==1) {
			return true;
		}
		if (tablero[0][2]==1 && tablero[1][2]==1 && tablero[2][2]==1) {
			return true;
		}
		//vertical
		if (tablero[0][0]==1 && tablero[0][1]==1 && tablero[0][2]==1) {
			return true;
		}
		if (tablero[1][0]==1 && tablero[1][1]==1 && tablero[1][2]==1) {
			return true;
		}
		if (tablero[2][0]==1 && tablero[2][1]==1 && tablero[2][2]==1) {
			return true;
		}
		return false;
	}
	
	public boolean ganaJugador2() {
		if (tablero[0][1]==2 && tablero[1][1]==2 && tablero[2][2]==2) {
			return true;
		}
		if (tablero[0][2]==2 && tablero[1][1]==2 && tablero[2][0]==2) {
			return true;
		} 
		//Horizontal
		if (tablero[0][0]==2 && tablero[1][0]==2 && tablero[2][0]==2) {
			return true;
		}
		if (tablero[0][1]==2 && tablero[1][1]==2 && tablero[2][1]==2) {
			return true;
		}
		if (tablero[0][2]==2 && tablero[1][2]==2 && tablero[2][2]==2) {
			return true;
		}
		//vertical
		if (tablero[0][0]==2 && tablero[0][1]==2 && tablero[0][2]==2) {
			return true;
		}
		if (tablero[1][0]==2 && tablero[1][1]==2 && tablero[1][2]==2) {
			return true;
		}
		if (tablero[2][0]==2 && tablero[2][1]==2 && tablero[2][2]==2) {
			return true;
		}
		return false;
	}
	
	public void dibujaTablero() {
		System.out.println("	-------------");
		System.out.println("	| "+fichaJugador(0,0)+" | "+fichaJugador(1,0)+" | "+fichaJugador(2,0)+" |");
		System.out.println("	-------------");
		System.out.println("	| "+fichaJugador(0,1)+" | "+fichaJugador(1,1)+" | "+fichaJugador(2,1)+" |");
		System.out.println("	-------------");
		System.out.println("	| "+fichaJugador(0,2)+" | "+fichaJugador(1,2)+" | "+fichaJugador(2,2)+" |");
		System.out.println("	-------------");
	}
	
	//Muestra en cada posición, la ficha correspondiente al jugador
	private char fichaJugador(int a, int b) {
		if (tablero[a][b]==1) {
			return 'X';
		}
		if (tablero[a][b]==2) {
			return 'O';
		}
		return ' ';
	}
}