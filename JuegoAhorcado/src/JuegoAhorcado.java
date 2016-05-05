import java.util.Scanner;

public class JuegoAhorcado {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
	char[] letras = {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I','J', 'K', 'L', 'M', 'N',
 			'Ñ', 'O','P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
        /*FRAN*/
        String palabra_buena;
        int tam=0,contador=0,ok=0,intento=0;
        String[] palabras = new String[]{"tren", "coche", "repisa", "hola", "diez", "ordenador", "tomate", "monitor", "castillo", "ventana"};
        char[] array_resultado;
        String letra;
        palabra_buena = palabras[(int) (Math.random() * 10)]; //Selecciona de forma aleatoria una de las 10 palabras.
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
        System.out.println(array_resultado); // Dibuja de nuevo la palabra con las letras acertadas
        }while(intento<6);// Números de intentos 6
        
        /*FRAN*/
        
         /*
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
        */
        
        
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
