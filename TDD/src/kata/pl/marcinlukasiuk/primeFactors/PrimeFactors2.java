package pl.marcinlukasiuk.primeFactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors2 {

	public static List<Integer> generate(int number) {
		
		List<Integer> factors = new ArrayList<Integer>();
		
		int i = 2;
		while (number > 1) {
			if (number%i == 0) {
				factors.add(i);
				number /= i;
			}
			else {
				i++;
			}
		}
		return factors;
	}
}