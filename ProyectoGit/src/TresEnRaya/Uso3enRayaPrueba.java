package TresEnRaya;
//El uso ya está perfecto, en este main se hará el recrear partida
import java.util.Random;
import java.util.Scanner;

public class Uso3enRayaPrueba {

	public static void main(String[] args) {
		TresEnRaya partida=new TresEnRaya();
		Scanner entrada=new Scanner(System.in);
		Random random=new Random();
		int opcion1;
		int opcion2;
		int pos=0;
		int ganaJ1=0;
		int ganaJ2=0;
		int ganaO1=0;
		int ganaO2=0;
		int empate=0;
		System.out.println("		BIENVENIDO AL 3 EN RAYA CON POO2");
		System.out.println("	-----------------------------------------------");
		System.out.println();
		System.out.println("¿Qué quieres hacer?\n"
				+ "    1.- Jugar una partida\n"
				+ "    2.- Ver Estadísticas\n"
				+ "    3.- Salir");
		opcion1=entrada.nextInt();
		while (opcion1<1 || opcion1 >3) {
			System.out.println("Introduce una de las opciones válidas");
			opcion1=entrada.nextInt();
		}
		do {
		if (opcion1==1) {
			partida.iniciar();
			System.out.println("Elige el modo que prefieras\n"
				+ "    1.- Jugador VS jugador. \n"
				+ "    2.- Jugador VS Máguina. \n"
				+ "    3.- Máquina VS Máquina. ");
			opcion2=entrada.nextInt();
			while (opcion2<1 || opcion2>3) {
				System.out.println("Introduce tu modo de juego, nuevamente");
				opcion2=entrada.nextInt();
			}
			switch (opcion2) {
			case 1: //Jugador VS Jugador
				while (partida.quedanMovimientos()==true && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
					System.out.println("  Jugador1- Introduce una posición");
					pos=entrada.nextInt();
					if (partida.movimientoValido(pos)==true && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
						partida.mueveJugador1(pos);
						partida.dibujaTablero();
					}
					else {
						while (partida.movimientoValido(pos)==false) {
							System.out.println("Ups! Casilla ocupada. \n Jugador 1 - Introduce una nueva posición");
							pos=entrada.nextInt();
						}
						partida.mueveJugador1(pos);
						partida.dibujaTablero();
					}
					if (partida.ganaJugador1()==true) {
						System.out.println("Felicidades Jugador1 - Has ganado!!");
						ganaJ1++;
					}
					else {
						if (partida.quedanMovimientos()==true ) {
							System.out.println("  Jugador2- Introduce una posición");
							pos=entrada.nextInt();
							if (partida.movimientoValido(pos)==true && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
								partida.mueveJugador2(pos);
								partida.dibujaTablero();
							}
							else {
								while (partida.movimientoValido(pos)==false) {
									System.out.println("Ups! Casilla ocupada. \n Jugador 2 - Introduce una nueva posición");
									pos=entrada.nextInt();
								}
								partida.mueveJugador2(pos);
								partida.dibujaTablero();
							}
							if (partida.ganaJugador2()==true) {
								System.out.println("Felicidades Jugador2 - Has ganado!!");
								ganaJ2++;
							}
						}	
					}
				}
				if (partida.quedanMovimientos()==false && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
					System.out.println("Vaya!  Parece que ha habido un empate!");
					empate++;
				}
				System.out.println("¿Qué quieres hacer?\n"
						+ "    1.- Jugar una partida\n"
						+ "    2.- Ver Estadísticas\n"
						+ "    3.- Salir");
				opcion1=entrada.nextInt();
			break;
			
			case 2: //Jugador VS Máquina
				int juega=random.nextInt(2);
				if(juega==0) {
					System.out.println("Inicia Jugador");
					while (partida.quedanMovimientos()==true && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
						System.out.println("  Jugador- Introduce una posición");
						pos=entrada.nextInt();
						if (partida.movimientoValido(pos)==true && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
							partida.mueveJugador1(pos);
							partida.dibujaTablero();
						}
						else {
							while (partida.movimientoValido(pos)==false) {
								System.out.println("Ups! Casilla ocupada. \n Jugador - Introduce una nueva posición");
								pos=entrada.nextInt();
							}
							partida.mueveJugador1(pos);
							partida.dibujaTablero();
						}
						if (partida.ganaJugador1()==true) {
							System.out.println("Felicidades Jugador - Has ganado!!");
							ganaJ1++;
						}
						else {
							if (partida.quedanMovimientos()==true ) {
								System.out.println("  Ordenador- Introduce una posición");
								partida.mueveOrdenador2();
								partida.dibujaTablero();
								if (partida.ganaJugador2()==true) {
									System.out.println("Felicidades Ordenador - Has ganado!!");
									ganaO2++;
								}
							}
						}
					}
					if (partida.quedanMovimientos()==false && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
						System.out.println("Vaya!  Parece que ha habido un empate!");
						empate++;
					}
				}
				if(juega==1) {
					System.out.println("Inicia Ordenador");
					while (partida.quedanMovimientos()==true && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
						System.out.println("  Ordenador- Introduce una posición");
						partida.mueveOrdenador1();
						partida.dibujaTablero();
						if (partida.ganaJugador1()==true) {
							System.out.println("Felicidades Ordenador - Has ganado!!");
							ganaO1++;
						}
						else {
							if (partida.quedanMovimientos()==true && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
								System.out.println("  Jugador- Introduce una posición");
								pos=entrada.nextInt();
								if (partida.movimientoValido(pos)==true && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
									partida.mueveJugador2(pos);
									partida.dibujaTablero();
								}
								else {
									while (partida.movimientoValido(pos)==false) {
										System.out.println("Ups! Casilla ocupada. \n Jugador - Introduce una nueva posición");
										pos=entrada.nextInt();
									}
									partida.mueveJugador2(pos);
									partida.dibujaTablero();
								}
								if (partida.ganaJugador2()==true) {
									System.out.println("Felicidades Jugador - Has ganado!!");
									ganaJ2++;
								}
							}
						}
					}
					if (partida.quedanMovimientos()==false && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
						System.out.println("Vaya!  Parece que ha habido un empate!");
						empate++;
					}
				}
				System.out.println("¿Qué quieres hacer?\n"
						+ "    1.- Jugar una partida\n"
						+ "    2.- Ver Estadísticas\n"
						+ "    3.- Salir");
				opcion1=entrada.nextInt();
			break;
			
			case 3: //Máquina vS Máquina
				while (partida.quedanMovimientos()==true && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
					System.out.println("  Ordenador1- Introduce una posición");
					partida.mueveOrdenador1();
					partida.dibujaTablero();
					if (partida.ganaJugador1()==true) {
						System.out.println("Felicidades Ordenador1 - Has ganado!!");
						ganaJ1++;
					}
					else {
						if (partida.quedanMovimientos()==true && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
							System.out.println("  Odenador2- Introduce una posición");
							partida.mueveOrdenador2();
							partida.dibujaTablero();
							}
							if (partida.ganaJugador2()==true) {
								System.out.println("Felicidades Ordenador2 - Has ganado!!");
								ganaJ2++;
							}
						}	
					}
				if (partida.quedanMovimientos()==false && partida.ganaJugador1()==false && partida.ganaJugador2()==false) {
					System.out.println("Vaya!  Parece que ha habido un empate!");
					empate++;
				}
				System.out.println("¿Qué quieres hacer?\n"
						+ "    1.- Jugar una partida\n"
						+ "    2.- Ver Estadísticas\n"
						+ "    3.- Salir");
				opcion1=entrada.nextInt();
			}//Switch modo juego
		}//if juego
		if (opcion1==2) {
			System.out.println("--Estadísticas del Juego--");
			System.out.println("    · Jugador 1:"+ganaJ1+".\n"
						   	 + "    · Jugador 2:"+ganaJ2+".\n"
						   	 + "    · Ordenador 1:"+ganaO1+".\n"
						   	 + "    · Ordenador 2:"+ganaO1+".\n"
						   	 + "    · Empates ");
			System.out.println("");
			System.out.println("¿Qué quieres hacer?\n"
					+ "    1.- Jugar una partida\n"
					+ "    2.- Ver Estadísticas\n"
					+ "    3.- Salir");
			opcion1=entrada.nextInt();
		}
		if (opcion1==3) {
			System.out.println("Hasta luego!!");
		}
		}while (opcion1!=3);
	}//main
}//clase
