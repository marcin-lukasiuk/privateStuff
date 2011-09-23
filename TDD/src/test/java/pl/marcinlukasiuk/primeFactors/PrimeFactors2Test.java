package pl.marcinlukasiuk.primeFactors;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;


public class PrimeFactors2Test {

	
	
	@Test
	public void shouldTestNumberOne() throws Exception {

		//when
		List<Integer> actual = PrimeFactors2.generate(1);
		//then
		assertThat(actual).isEmpty();
	}
	
	@Test
	public void shouldTestNumbers() throws Exception {
		testNumber(2, Lists.newArrayList(2));
		testNumber(3, Lists.newArrayList(3));
		testNumber(4, Lists.newArrayList(2,2));
		testNumber(5, Lists.newArrayList(5));
		testNumber(6, Lists.newArrayList(2,3));
		testNumber(7, Lists.newArrayList(7));
		testNumber(8, Lists.newArrayList(2,2,2));
		testNumber(9, Lists.newArrayList(3,3));
		testNumber(10, Lists.newArrayList(2,5));
		testNumber(11, Lists.newArrayList(11));
		testNumber(12, Lists.newArrayList(2,2,3));
	}
	
	private void testNumber(int number, List<Integer> expectedFactors) {
		//when
		List<Integer> actual = PrimeFactors2.generate(number);
		//then
		assertThat(actual).isEqualTo(expectedFactors);
	}
}
