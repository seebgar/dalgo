import java.util.Scanner;

/**
 * Proyecto DAlgo 201820
 * Profesor: Nelson Sanchez
 * 
 * Inversión en bolsa
 * 
 * @author Sebastian Garcia 201630047
 * @author Nicolas Sotelo 201623026
 *
 */

public class ProblemaB {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int c = scan.nextInt();
		String ans = "";

		while (n != 0) {
			int[] rA = new int[n];
			int[] rB = new int[n];

			for (int i = 0; i < n; i++) 
				rA[i] = scan.nextInt();

			for (int i = 0; i < n; i++) 
				rB[i] = scan.nextInt();

			ans += capital(n, rA, rB, c) + "\n";

			n = scan.nextInt();
			c = scan.nextInt();
		}

		System.out.println(ans);
		scan.close();
	}

	/**
	 * Calcula el capital que se podria obtener por bolsa
	 * para de esta forma obtener el maximo capital posible
	 * en n tiempo.
	 * 
	 * @pre La posicion inicial i deberia ser 0. Las prediciones de las bolsas A y B deben estar en 
	 * orden y del mismo tamano.
	 * @post Se hace una recursión para obtener el maximo capital posible teniendo en cuenta cada prediccion.
	 * @param n tiempo y tamano de los arreglos que contienen las prediciones
	 * @param i posicion inicial para empezar en el primer tiempo y tener en cuenta las predicciones en orden.
	 * @param rA predicciones de inversion en la bolsa A
	 * @param rB predicciones de inversion en la bolsa B
	 * @param c capital de inversion
	 * @param bool Para tener en cuenta o no las inversiones en la Bolsa contraria
	 * @return el capital maximo posible en n tiempo.
	 */
	public static int aux(int n, int i, int[] rA, int[] rB, int c, boolean bool) {
		if (i == n) return c;

		int a =  (int) Math.floor(c * (1 + ((rA[i]*1.00)/100)));
		int b = (int) Math.floor(c * (1 + ((rB[i]*1.00)/100)));

		if(bool)
			return Math.max(aux(n, i+1, rA, rB, b, !bool), aux(n, i+1, rA, rB, c, !bool));
		else
			return Math.max(aux(n, i+1, rA, rB, a, !bool),Math.max( aux(n, i+1, rA, rB, b, bool), aux(n, i+1, rA, rB, c, bool)));

	}
	
	/**
	 * Retorna el maximo capotal que se podria esperar en el tiempo n.
	 * 
	 * @pre las predicciones en las bolsas (rA, rB) deben tener el mismo tamano. El capital inicial debe
	 * ser mayor a cero. La cantidad de tiempo n debe concordar con la cantidad de prediciones de las 
	 * bolsas A y B (rA, rB respectivamente).
	 * @post Se retorna un entero que representa el capital maximo posible
	 * @param n cantidad de tiempo (tamano de los arreglos que contienen las prediciones en orden)
	 * @param rA predicciones de inversion en la bolsa A
	 * @param rB predicciones de inversion en la bolsa B
	 * @param c capital de inversion inicial
	 * @return maximo capital posible
	 */
	public static int capital(int n, int[] rA, int[] rB, int c) {
		if ( n <= 1 ) return c;
		return Math.max(capital(n-1, rA, rB, c), aux(n, 0, rA, rB, c, false));
	}

}