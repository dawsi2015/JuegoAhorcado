
public class JuegoAhorcado {

	public static void main(String[] args) {
		System.out.println("Holaa");

	}

}
  /*
  package nou;

import java.util.Scanner;;

public class Controlarletras {
	public static void main (String[] args) {  //Solo lo he hecho para hacer pruebas, no sirve de nada.
		Scanner lector=new Scanner(System.in);
		char[] letras = {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I','J', 'K', 'L', 'M', 'N',
				'Ñ', 'O','P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
		
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
		}while(i!=-2 ); // Solo lo he hecho para hacer pruebas, no sirve de nada.
	}
 
	public static int tachar_letras(char[] letras, char letra){
		int i=0;
		char letraUP;
		
		letraUP=Character.toUpperCase(letra);  //Pasamos la letra a mayúscula por si acaso.
		   
		if(!Character.isLetter(letraUP))return -2;  //Comprobamos que sea una letra de la 'A' a la 'Z'
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
  
  
  */
