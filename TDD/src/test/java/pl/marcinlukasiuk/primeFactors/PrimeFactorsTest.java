/* 
 * Created on 18:00:37 by mlukasiu
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

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class PrimeFactorsTest {

	
	@Test
	public void shouldTestNumberOne() throws Exception {

		//when
		List<Integer> result = PrimeFactors.generate(1);

		//then
		assertThat(result).isEmpty();
	}
	
	
	@Test
	public void shouldTestNumberTwo() throws Exception {

		//when
		List<Integer> result = PrimeFactors.generate(2);

		//then
		assertThat(result).containsExactly(2);
	}
	
	@Test
	public void shouldTestNumberThree() throws Exception {

		//when
		List<Integer> result = PrimeFactors.generate(3);

		//then
		assertThat(result).containsExactly(3);
	}
	
	@Test
	public void shouldTestNumberFour() throws Exception {

		//when
		List<Integer> result = PrimeFactors.generate(4);

		//then
		assertThat(result).containsExactly(2,2);
	}
	
	
	@Test
	public void shouldTestNumberSix() throws Exception {

		//when
		List<Integer> result = PrimeFactors.generate(6);

		//then
		assertThat(result).containsExactly(2,3);
	}
	
	@Test
	public void shouldTestNumberEight() throws Exception {

		//when
		List<Integer> result = PrimeFactors.generate(8);

		//then
		assertThat(result).containsExactly(2,2,2);
	}
	
	@Test
	public void shouldTestNumberNine() throws Exception {

		//when
		List<Integer> result = PrimeFactors.generate(9);

		//then
		assertThat(result).containsExactly(3,3);
	}
}
