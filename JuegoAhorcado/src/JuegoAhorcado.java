import java.io.*;
import java.util.*;
public class JuegoAhorcado {
	public static void main(String[] args){
		Scanner lector = new Scanner(System.in);
		int n_palabras=0, i=0, j=0;
		String[] palabras=null;

		/*ALBA*/
		char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		/*ALBA*/

		/*jordi
		 * Lee las palabras i las guarda en un string
		 * es el apartado c i d */
		palabras=leer_fichero();
		n_palabras = palabras.length;

		/*FRAN*/
		String palabra_buena;
		int tam=0,contador=0,ok=0,intento=0;
		char[] array_resultado;
		boolean correcto = false;
		String letra;
		palabra_buena = palabras[(int) (Math.random() * n_palabras)]; //Selecciona de forma aleatoria una de las 10 palabras.
		tam = palabra_buena.length(); // Se calcula la longitud de la palabra para dibujar '-' aqui da error.
		array_resultado = new char[tam];
		for (i = 0; i<tam; i++) {
			array_resultado[i] = '-';
		}

		System.out.println("JUEGO DEL AHORCADO");
		dibujar(intento);
		System.out.print("palabra: ");
		System.out.println(array_resultado);
		System.out.println(letras);
		System.out.println("Elige letra:");

		do{
			letra=lector.next();
			i=tachar_letras(letras, letra);
			if (i==-1) System.out.println("Esta letra ya está dicha.");
			else if(i==-2){
				System.out.println("Tiene que ser una letra de la 'A' a la 'Z'.");
				dibujar(intento);
			}
			else if (i==0){
				ok = adivina(palabra_buena,array_resultado,letra,tam); // La funciÃ³n nos devuelve 0 si encuentra la letra y -1 si no la encuentra.
				if (ok==-1){ // Si no la encuentra '-1' contarÃ¡ como un intento
					intento++;
					dibujar(intento);//*Cesar* dibuja la siguiente figura despues de fallar
				}else dibujar(intento);
			}
			if (intento<6){
				System.out.print("palabra: ");
				System.out.println(array_resultado); // Dibuja de nuevo la palabra mostrando las letras acertadas
				System.out.println(letras);
				System.out.println("Elige letra:");
			}
			String result= String.copyValueOf(array_resultado);
			if(result.equals(palabra_buena))correcto=true;
			
		}while(intento<6 && !correcto); // El número de intentos es 6
		if (correcto)System.out.print("HAS GANADO!!");
		else System.out.println("Has perdido!!");
		/*FRAN*/
	}

	/*FRAN*/
	/*Función para comprobar si la letra introducida estÃ¡ dentro de alguna de la palabra a adivinar*/
	static int adivina(String palabra_buena,char[] array_resultado,String letra,int tam){
		if (palabra_buena.contains(letra)) {
			for (int i = 0; i<tam; i++) {
				if (palabra_buena.charAt(i) == letra.charAt(0)) {
					array_resultado[i] = letra.charAt(0);
				}
			}
			return 0;
		}else return -1;
	}
	/*FRAN*/

	/*jordi
	 * Lee las palabras i las guarda en un string
	 * es el apartado c i d */
	public static String[] leer_fichero(){
		int n=0, n_palabras=0;
		String[] palabras = null;
		try{
			Scanner in = new Scanner( new File("palabra.txt"));
			if(in.hasNext()){
				String num_palabras=in.next();//lee el numero de palabras que tiene el fichero
				n_palabras=Integer.parseInt(num_palabras);
				palabras= new String[n_palabras];
				
				while(in.hasNext()){ //lee las palabras
					String palabra=in.next();
					palabras[n++] = palabra;
				}
			}
		}catch (FileNotFoundException e){
			System.out.println("Error, no se encuntra el fichero");
		}
		return palabras;

	}

	/*ALBA*/
	//Tacha la letra que le pases y lo muetra por pantalla. Devuelve: -2 Si no es una letra(A-Z), -1 si ya estaba tachada, 0 si correcto.
	public static int tachar_letras(char[] letras, String letra){	
		int i=0;
		char letra2 = letra.charAt(0);
		char letraUP;

		letraUP=Character.toUpperCase(letra2);  //Pasamos la letra a mayÃºscula por si acaso.

		if(!Character.isLetter(letraUP))return -2;  
		while(letras[i]!=(letraUP) && i<26){ //Son 27 letras, pero java empieza a contar desde 0.
			i++;			     // Si poniamos 27, daba una vulelta de mÃ¡s.
		}
		if(letras[i]!=(letraUP))return -1;	
		else {
			letras[i]='-';
			return 0;
		}

	}
	
	/*Cesar*/
	//Se le introduce los intentos y asi va cambiando el dibujo teniendo 6 intentos. 
	private static void dibujar(int i) {

		switch (i) {

		case 0:

			System.out.println(" ________");
			System.out.println(" |       |");
			System.out.println(" |       ");
			System.out.println(" | ");
			System.out.println(" | ");
			System.out.println(" | ");
			System.out.println("_|_");

			break;

		case 1:

			System.out.println(" ________");
			System.out.println(" |       |");
			System.out.println(" |       O");
			System.out.println(" | ");
			System.out.println(" | ");
			System.out.println(" | ");
			System.out.println("_|_");

			break;

		case 2:

			System.out.println(" ________");
			System.out.println(" |       |");
			System.out.println(" |       O");
			System.out.println(" |       |");
			System.out.println(" | ");
			System.out.println(" | ");
			System.out.println("_|_");

			break;

		case 3:

			System.out.println(" ________");
			System.out.println(" |       |");
			System.out.println(" |       O");
			System.out.println(" |       |\\");
			System.out.println(" | ");
			System.out.println(" | ");
			System.out.println("_|_");

			break;

		case 4:

			System.out.println(" ________");
			System.out.println(" |       |");
			System.out.println(" |       O");
			System.out.println(" |      /|\\");
			System.out.println(" |       ");
			System.out.println(" | ");
			System.out.println("_|_");

			break;

		case 5:

			System.out.println(" ________");
			System.out.println(" |       |");
			System.out.println(" |       O");
			System.out.println(" |      /|\\");
			System.out.println(" |      / ");
			System.out.println(" | ");
			System.out.println("_|_");

			break;

		case 6:

			System.out.println(" ________");
			System.out.println(" |       |");
			System.out.println(" |       O");
			System.out.println(" |      /|\\");
			System.out.println(" |      / \\");
			System.out.println(" | ");
			System.out.println("_|_");

			break;

		}

	}
}
