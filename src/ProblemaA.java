
import java.util.Scanner;

/**
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


	public static int longest(int i, int[] array) {
		if (i == 1) return 1;
		else return Math.max(aux(i, array, 1), longest(i-1, array));
	}


}
