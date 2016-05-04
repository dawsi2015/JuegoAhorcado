import java.util.Scanner;

public class JuegoAhorcado {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
        String palabra_buena;
        int tam=0,contador=0,ok=0,intento=0;
        String[] palabras = new String[]{"tren", "coche", "repisa", "hola", "diez", "ordenador", "tomate", "monitor", "castillo", "ventana"};
        char[] array_resultado;
        String letra;
        palabra_buena = palabras[(int) (Math.random() * 6)];
        tam = palabra_buena.length();
        array_resultado = new char[tam];
        
        for (int i = 0; i<tam; i++) {
        	array_resultado[i] = '-';
        	
        }
        
        System.out.print("palabra: ");
        System.out.println(array_resultado);
        do{
        System.out.print("Elige letra:");
        letra=lector.next();
        ok = adivina(palabra_buena,array_resultado,letra,tam);
        if (ok==-1)intento++;
        System.out.print("palabra: ");
        System.out.println(array_resultado);
        }while(intento<6);
        
	}
	
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

}
