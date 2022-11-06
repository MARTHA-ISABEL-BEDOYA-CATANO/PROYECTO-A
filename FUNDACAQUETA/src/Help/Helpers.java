/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author clockwork
 */
public class Helpers {
     public static String Codigo(){
        Random rnd = new Random(123L);
        return String.valueOf(rnd.nextInt(100));
    }
     
     public static ArrayList<Integer> generarAleatoriosNoRepetidos () {
         int cantidad = 1000000;
		ArrayList<Integer> respuesta = new ArrayList<>();
		for (int i = 0; i < cantidad; i++) {
			respuesta.add(gen(respuesta));
		}			
		return respuesta;
	}
	
	/**
	 * Metodo recursivo que crea un numero aleatorio, pero primero verifica si existe en el arreglo del parametro.
	 * Si el numero ya existe, el metodo se llama a si mismo para hacer otro intento y asi sucesivamente hasta
	 * encontrar un numero aleatorio que no exista en el arreglo
	 * @param a Arreglo de numeros aleatorios que previamente guarados
	 * @return numero que no existe en el arreglo a dado.
	 */
	private static int gen(ArrayList<Integer>a) {
		Random ra = new Random();	
		int numero = ra.nextInt(1000000);
		if (!a.contains(numero)) {
			return numero;
		}else {
			return gen(a);
		}
	}
	
    
    
}
