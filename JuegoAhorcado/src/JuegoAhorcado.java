import java.io.*;
import java.util.*;

public class JuegoAhorcado {



	public static void main(String[] args){
		Scanner lector = new Scanner(System.in);
		/*ALBA*/
		char[] letras = {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I','J', 'K', 'L', 'M', 'N',
	 			 'O','P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};/*ALBA*/
		/*jordi
		 * Lee las palabras i las guarga en un string
		 * es el apartado c i d */
		int n_palabras = 0;
		try{
			Scanner in = new Scanner(new File("palabra.txt"));
			String num_palabras=in.next();//lee el numero de palabras que tiene el fichero
			 n_palabras=Integer.parseInt(num_palabras);
			 System.out.println("hay "+n_palabras+" palapras");
		}catch (FileNotFoundException e){
			   System.out.println("error no se encuntra el fichero");
			       }
		int n=1;
		
		 	String[] palabras=new String[n_palabras];

			try{
				Scanner in=new Scanner( new File("palabra.txt"));
				while(in.hasNext()){
					 palabras[n++] =in.next();
					 in.close();
				}
				
			}catch (FileNotFoundException e){
				   System.out.println("error no se encuntra el fichero");
				       }
			for(n=1;n<n_palabras;n++)
				System.out.println(palabras[n]);
		/* ######################################### */
			/*FRAN*/
	        String palabra_buena;
	        int tam=0,contador=0,ok=0,intento=0;
	        char[] array_resultado;
	        String letra;
	        palabra_buena = palabras[(int) (Math.random() * n_palabras/*jordi change*/)]; //Selecciona de forma aleatoria una de las 10 palabras.
	        tam = palabra_buena.length(); // Se calcula la longitud de la palabra para dibujar '-'.
	        array_resultado = new char[tam];
	        for (int i = 0; i<tam; i++) {
	        	array_resultado[i] = '-';
	        }
	        
	        
	        System.out.print("palabra: ");
	        System.out.println(array_resultado);
	        do{
	        System.out.print("Elige letra:");
	        letra=lector.next();
	        ok = adivina(palabra_buena,array_resultado,letra,tam); // La función nos devuelve 0 si encuentra la letra y -1 si no la encuentra.
	        if (ok==-1)intento++; // Si no la encuentra '-1' contará como un intento
	        System.out.print("palabra: ");
	        System.out.println(array_resultado); // Dibuja de nuevo la palabra mostrando las letras acertadas
	        }while(intento<6);// El números de intentos es 6
	        /*FRAN*/
	        
	         /* ALBA
	        char letra = ' ';
		int i=0;
		String temp;
		do{
			System.out.print("Escribe una letra:");
			temp=lector.nextLine();
			if (temp.length() == 1) {
				letra = temp.charAt(0);
			}else System.out.println("Tienes que escribir solo una letra.");
			i = tachar_letras(letras, letra);
		 	if (i==-1) System.out.println("Esta letra ya está dicha.");
		 	else if(i==-2) System.out.println("Tiene que ser una letra de la 'A' a la 'Z'.");
		 	else System.out.println(letras);
		 }while(i!=-2 ); 
	        ALBA */   
	        
	        
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

	}
