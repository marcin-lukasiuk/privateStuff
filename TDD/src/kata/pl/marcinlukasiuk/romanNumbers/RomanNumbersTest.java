package pl.marcinlukasiuk.romanNumbers;

import static org.fest.assertions.Assertions.assertThat;
import static pl.marcinlukasiuk.romanNumbers.RomanNumbers.romanToInt;

import org.fest.assertions.Fail;
import org.junit.Test;


public class RomanNumbersTest {

	
	
	@Test
	public void shouldConvertRomanNumbersToInt() throws Exception {

		assertThat(romanToInt("I")).isEqualTo(1);
		assertThat(romanToInt("II")).isEqualTo(2);
		assertThat(romanToInt("III")).isEqualTo(3);
		assertThat(romanToInt("V")).isEqualTo(5);
		assertThat(romanToInt("IV")).isEqualTo(4);
		assertThat(romanToInt("VI")).isEqualTo(6);
		assertThat(romanToInt("X")).isEqualTo(10);
		assertThat(romanToInt("IX")).isEqualTo(9);
		assertThat(romanToInt("XVIII")).isEqualTo(18);
		assertThat(romanToInt("XIX")).isEqualTo(19);
		assertThat(romanToInt("L")).isEqualTo(50);
		assertThat(romanToInt("C")).isEqualTo(100);
		assertThat(romanToInt("D")).isEqualTo(500);
		assertThat(romanToInt("M")).isEqualTo(1000);
		assertThat(romanToInt("XD")).isEqualTo(490);
		assertThat(romanToInt("MCMXLIV")).isEqualTo(1944);
		assertThat(romanToInt("MDCIV")).isEqualTo(1604);
	}
	
	
	@Test
	public void shouldThrowIllegalArgumentExceptionWhenGivenInvalidRomanSymbol() throws Exception {

		//given
		String invalidRomanNumber = "MDCU";

		try {
			//when
			RomanNumbers.romanToInt(invalidRomanNumber);
			//then
			Fail.fail("Exception should be thrown");
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}

	}
}
