import java.util.Scanner;

/**
 * Velocidad observada estimada
 * 
 * @author Sebastian Garcia 201630047
 * @author Nicolas Sotelo 201623026
 *
 */

public class ProblemaC {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String ans = "";

		while (n != 0) {
			int[] senA = new int[n];
			int[] senB = new int[n];

			for (int i = 0; i < n; i++) {
				senB[i] = scan.nextInt();
				senA[i] = scan.nextInt();
			}
				
			ans += aux(n, senA, senB) + "\n";

			n = scan.nextInt();
		}

		System.out.println(ans);
		scan.close();
	}

	public static int aux(int n, int[] senA, int[] senB) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			sum += (senA[j] + senB[j])/2;
		}
		
		return (int) Math.floor(sum/n);
	}

}
