
import java.util.Scanner;

/**
 * Proyecto DAlgo 201820
 * Profesor: Nelson Sanchez
 * 
 * Subarreglo casi ascendente mas largo
 * 
 * @author Sebastian Garcia 201630047
 * @author Nicolas Sotelo 201623026
 *
 */

public class ProblemaA {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String ans = "";
		
		while (n != 0) {
			int[] array = new int[n];

			for (int i = 0; i < n; i++) 
				array[i] = scan.nextInt();

			ans += longest(n, array) + "\n";
			n = scan.nextInt();
		}
		
		System.out.println(ans);
		scan.close();
	}


	/**
	 * Metodo auxiliar que calcula la longitud del arreglo casi ascendente mas largo.
	 * 
	 * @pre el arreglo no esta vacio y solo contiene enteros. El error empieza con valor de 1.
	 * @post  Se hace una recursion sumando en una unidad si el el elemento del arreglo actual
	 * le permite al arreglo cumplir con la condicion de orden casi ascendente. Si se encuentra 
	 * un unico valor que hace que no se cumpla la anterior condicion, se tendra en cuenta.
	 * @param i posicion en el arreglo
	 * @param array arreglo sobre el cual se va a hacer la operacion
	 * @param error como es un orden casi ascendente, a lo sumo hay un elemento que no es ascendente
	 * @return la longitud del arreglo casi ascendente mas largo
	 */
	public static int aux(int i, int[] array, int error) {
		if (i == 1) return 1;
		else if (i > 1) {
			if (array[i-2] > array[i-1]) return 1;
			else error++;
			if (error == 2) return aux(i-1, array, 1) + 2;
			return aux(i-1, array, 1) + 1;
		}
		else return aux(i-1, array, error) + 1;
	}


	/**
	 * Metodo principal que retorna la longitud del subarreglo casi 
	 * ascendente mas lago.
	 * 
	 * @pre el arreglo no esta vacio y solo contiene enteros.
	 * @post se retorna un entero, sin modificar el arreglo original.
	 * @param i tamano del arreglo a calcular.
	 * @param array arreglo sobre el cual se van a calcular los sibarreglos.
	 * @return cantidad de elementos pertenecientes al subarreglo casi ascendente mas largo
	 */
	public static int longest(int i, int[] array) {
		if (i == 1) return 1;
		else return Math.max(aux(i, array, 1), longest(i-1, array));
	}


}
