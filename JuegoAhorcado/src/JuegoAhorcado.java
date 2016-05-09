import java.io.*;
import java.util.*;

public class JuegoAhorcado {



public static void main(String[] args){
		Scanner lector = new Scanner(System.in);
		int n_palabras=0;
		String[] palabras=new String[];

		/*ALBA*/
		char[] letras = {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I','J', 'K', 'L', 'M', 'N',
				'O','P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
		/*ALBA*/

		/*jordi
		 * Lee las palabras i las guarda en un string
		 * es el apartado c i d */
			n_palabras=leer_fichero(n_palabras, palabras);


			/* ######################################### */
			/*FRAN*/
			String palabra_buena;
			int tam=0,contador=0,ok=0,intento=0;
			char[] array_resultado;
			String letra;
			palabra_buena = palabras[(int) (Math.random() * n_palabras/*jordi change*/)]; //Selecciona de forma aleatoria una de las 10 palabras.
			tam = palabra_buena.length(); // Se calcula la longitud de la palabra para dibujar '-' aqui da error.
			array_resultado = new char[tam];
			for (int i = 0; i<tam; i++) {
				array_resultado[i] = '-';
			}

			dibujar(intento); //dibuja la primera figura del ahorcado
			System.out.print("palabra: ");
			System.out.println(array_resultado);

			do{
				System.out.print("Elige letra:");
				letra=lector.next();
				ok = adivina(palabra_buena,array_resultado,letra,tam); // La función nos devuelve 0 si encuentra la letra y -1 si no la encuentra.
				if (ok==-1){ // Si no la encuentra '-1' contará como un intento
					intento++;
					dibujar(intento);//*Cesar* dibuja la siguiente figura despues de fallar
				}
				System.out.print("palabra: ");
				System.out.println(array_resultado); // Dibuja de nuevo la palabra mostrando las letras acertadas
			}while(intento<6); // El números de intentos es 6
			/*FRAN*/

			
			/* ALBA */ 
	        char letra1= ' ';
		int i=0;
		String temp;
		do{
			System.out.print("Escribe una letra:");
			temp=lector.nextLine();
			if (temp.length() == 1) {
				letra1 = temp.charAt(0);
			}else System.out.println("Tienes que escribir solo una letra.");
			i = tachar_letras(letras, letra1);
		 	if (i==-1) System.out.println("Esta letra ya está dicha.");
		 	else if(i==-2) System.out.println("Tiene que ser una letra de la 'A' a la 'Z'.");
		 	else System.out.println(letras);
		 }while(i!=-2 ); 
	       /* ALBA */   
		}
	

	/*FRAN*/
	/*Función para comprobar si la letra introducida está dentro de alguna de la palabra a adivinar*/
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
		public static int leer_fichero(int n_palabras, String[] palabras){
	try{
		Scanner in = new Scanner( new File("palabra.txt"));
		if(in.hasNext()){
			String num_palabras=in.next();//lee el numero de palabras que tiene el fichero
			n_palabras=Integer.parseInt(num_palabras);
			System.out.println("hay "+n_palabras+" palabras");			
			
			int n=0;
			while(in.hasNext()){ //lee las palabras
				String palabra=in.next();
				palabras[n++] = palabra;
				System.out.println(palabra);
			}
		}
	}catch (FileNotFoundException e){
		System.out.println("Error, no se encuntra el fichero");
	}
	return n_palabras;
	
	}
	}
		/* ######################################### */
	/*ALBA*/
	//Tacha la letra que le pases y lo muetra por pantalla. Devuelve: -2 Si no es una letra(A-Z), -1 si ya estaba tachada, 0 si correcto.
	public static int tachar_letras(char[] letras, char letra){	
		int i=0;
		char letraUP;

		letraUP=Character.toUpperCase(letra);  //Pasamos la letra a mayúscula por si acaso.

		if(!Character.isLetter(letraUP))return -2; 
		while(letras[i]!=(letraUP) && i<25){
			i++;
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
			System.out.println(" |      /|\\");
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

			//System.out.println("Has perdido");
			break;

		}

	}
	
}
