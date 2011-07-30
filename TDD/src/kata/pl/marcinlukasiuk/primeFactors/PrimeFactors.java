/* 
 * Created on 18:03:01 by mlukasiu
 * 
 * Copyright (c) 2001-2010 Contium S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Contium S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie 
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Contium S.A. 
 */

package pl.marcinlukasiuk.primeFactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static List<Integer> generate(int number) {

		List<Integer> primes = new ArrayList<Integer>();
		
		for (int candidate = 2; number > 1; candidate++) {
			for (; number % candidate == 0; number /= candidate) {
				primes.add(candidate);
			}
		}
		
		return primes;
	}

}
