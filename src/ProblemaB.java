import java.util.Scanner;

/**
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

			ans += aux(n, 0, rA, rB, c) + "\n";
			
			n = scan.nextInt();
			c = scan.nextInt();
		}

		System.out.println(ans);
		scan.close();
	}

	public static int aux(int n, int i, int[] rA, int[] rB, int c) {
		if (i == n) return c;
		
		int a = (int) Math.floor(c * (1 + ((rA[i]*1.00)/100)));
		int b = (int) Math.floor(c * (1 + ((rB[i]*1.00)/100)));
				
		return aux(n, i+1, rA, rB, Math.max(a, b));		
	}

}