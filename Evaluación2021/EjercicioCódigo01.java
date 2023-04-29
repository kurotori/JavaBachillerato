import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String[] usuarios = new String[5];
		int[] puntajes = new int[5];

		for (int posicion = 0; posicion < usuarios.length; posicion++) {
			System.out.println("Escriba el nombre del jugador " + (posicion + 1) + ":");
			usuarios[posicion] = teclado.nextLine();
			puntajes[posicion] = 0;
		}

		teclado.close();

		for (int posicion = 0; posicion < usuarios.length; posicion++) {
			System.out.println("Jugador:" + usuarios[posicion]);
			System.out.println("Puntaje:" + puntajes[posicion]);
		}
	}
}
