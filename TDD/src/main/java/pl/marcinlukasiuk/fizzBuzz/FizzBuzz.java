package pl.marcinlukasiuk.fizzBuzz;

/**
 * Write a program that prints the numbers from 1 to 100. But for multiples of three print "Fizz" instead of the number and for the multiples of five print "Buzz". 
 * For numbers which are multiples of both three and five print "FizzBuzz". 
 * 
 * 
 * @author marcin
 *
 */
public class FizzBuzz {

	static final String FIZZ = "Fizz";
	static final String BUZZ = "Buzz";
	static final String FIZZBUZZ = FIZZ + BUZZ;


	public static String fizzBuzz(int number) {
		
		if (hasFactors(number, 3, 5)) {
			return FIZZBUZZ;
		}
		if (hasFactors(number, 3)) {
			return FIZZ;
		}
		else if (hasFactors(number, 5)) {
			return BUZZ;
		}
		return Integer.toString(number);
	}

	private static boolean hasFactors(int number, int... factors) {

		for (int i = 0; i < factors.length; i++) {
			if (number % factors[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
