import java.util.*;

/**
 * Proyecto DAlgo 201820
 * Profesor: Nelson Sanchez
 * 
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
			Pair<Integer, Integer>[] tuples = new Pair[n];

			for (int i = 0; i < n; i++) {
				Pair<Integer, Integer> t = new Pair<Integer, Integer>(scan.nextInt(), scan.nextInt());
				tuples[i] = t;
			}

			ans += aux(n, tuples) + "\n";
			n = scan.nextInt();
		}

		System.out.println(ans);
		scan.close();
	}


	
	/**
	 * A partir de parejas de estimaciones, se calculan primero los valores que se interceptan. 
	 * Luego se obtienen los valores minimos que pertenecen a intercepciones y se obtienen el minimo
	 * entre estos para obtener la velocidad observable estimada a partir de intercepciones.
	 * En el caso en el que no hay intercepciones entre las estimaciones, se obtiene el promedio
	 * de las estimacion menor entre las estimaciones.
	 * 
	 * @pre el arreglo de estimaciones no esta vacio y solo contiene parejas cuyos valores x y son 
	 * el valor de velocidad minima y maxima para una estimacion.
	 * @post se obtiene la velocidad observable estimada
	 * @param n cantidad de estimaciones
	 * @param tuples arreglo de estimaciones 
	 * @return la velocidad observable estimada
	 */
	public static int aux(int n, Pair<Integer, Integer>[] tuples) {

		ArrayList<Integer> interceptos_x = new ArrayList<>();
		ArrayList<Integer> interceptos_y = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			Pair<Integer, Integer> actual = tuples[i];
			for (int j = 1; j < n; j++) {
				if ( j != i) {
					Pair<Integer, Integer> next = tuples[j];

					if ( (int) next.get_x() >= (int) actual.get_x() && (int) next.get_x() <= (int) actual.get_y()  ) 
						interceptos_x.add((int) next.get_x());

					if ( (int) next.get_y() >= (int) actual.get_x() && (int) next.get_y() <= (int) actual.get_y()  ) 
						interceptos_y.add((int) next.get_y());
				}
			}
		}

		int minx = -1, miny = -1;

		if ( interceptos_x.size() > 0 ) {
			minx = interceptos_x.get(0);
			for( int x : interceptos_x ) 
				if ( x < minx) 
					minx = x;
		}

		if ( interceptos_y.size() > 0 ) {
			miny = interceptos_y.get(0);
			for( int y : interceptos_y ) 
				if ( y < miny) 
					miny = y;
		}

		if ( minx != -1 || miny != -1 ) 
			return Math.min(minx, miny);
		else  {
			Pair<Integer, Integer> min = tuples[0];
			for (Pair<Integer, Integer> p : tuples) 
				if ( (int) p.get_x() < (int) min.get_x() && (int) p.get_y() < (int) min.get_y() )
					min = p;
			
			return (int) Math.floor( ((int) min.get_x() + (int) min.get_y()) / 2 );
		}

	}
	
	
	/**
	 * Clase que represneta una Pareja de valores 
	 * 
	 * @param <S>
	 * @param <T>
	 */
	public static class Pair <S, T> {
		private final S x;
		private final T y;
		public Pair(S x, T y) {
			this.x = x;
			this.y = y;
		}
		public S get_x() {
			return this.x;
		}
		public T get_y() {
			return this.y;
		}
	}

}
