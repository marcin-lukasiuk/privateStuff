package pl.marcinlukasiuk.fizzBuzz;

import static org.fest.assertions.Assertions.assertThat;
import static pl.marcinlukasiuk.fizzBuzz.FizzBuzz.BUZZ;
import static pl.marcinlukasiuk.fizzBuzz.FizzBuzz.FIZZ;
import static pl.marcinlukasiuk.fizzBuzz.FizzBuzz.FIZZBUZZ;

import org.junit.Test;


public class FizzBuzzTest {

	@Test
	public void oneShouldGiveOne() throws Exception {

		assertThat(FizzBuzz.fizzBuzz(1)).isEqualTo("1");
	}

	@Test
	public void twoShouldGiveTwo() throws Exception {

		assertThat(FizzBuzz.fizzBuzz(2)).isEqualTo("2");
	}

	@Test
	public void threeShouldGiveFizz() throws Exception {

		assertThat(FizzBuzz.fizzBuzz(3)).isEqualTo(FIZZ);
	}

	@Test
	public void fiveShouldGiveBuzz() throws Exception {

		assertThat(FizzBuzz.fizzBuzz(5)).isEqualTo(BUZZ);
	}

	@Test
	public void thirteenShouldGiveThirteen() throws Exception {

		assertThat(FizzBuzz.fizzBuzz(13)).isEqualTo("13");
	}

	@Test
	public void nineShouldGiveFizz() throws Exception {

		assertThat(FizzBuzz.fizzBuzz(9)).isEqualTo(FIZZ);
	}

	@Test
	public void tenShouldGiveBuzz() throws Exception {

		assertThat(FizzBuzz.fizzBuzz(10)).isEqualTo(BUZZ);
	}

	@Test
	public void fifteenShouldGiveFizzBuzz() throws Exception {

		assertThat(FizzBuzz.fizzBuzz(15)).isEqualTo(FIZZBUZZ);
	}

	@Test
	public void ninetyShouldGiveFizzBuzz() throws Exception {

		assertThat(FizzBuzz.fizzBuzz(90)).isEqualTo(FIZZBUZZ);
	}
}
