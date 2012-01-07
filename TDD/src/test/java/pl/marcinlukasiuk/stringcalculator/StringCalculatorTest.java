package pl.marcinlukasiuk.stringcalculator;

import static org.fest.assertions.Assertions.assertThat;

import org.fest.assertions.Fail;
import org.junit.Test;


public class StringCalculatorTest {

	
	@Test
	public void shouldReturnZeroWhenGivenEmptyOrNullString() throws Exception {

		assertThat(StringCalculator.add("")).isEqualTo(0);
		assertThat(StringCalculator.add(null)).isEqualTo(0);
	}
	
	@Test
	public void shouldReturnNumberWhenGivenSingleNumber() throws Exception {

		assertThat(StringCalculator.add("1")).isEqualTo(1);
		assertThat(StringCalculator.add("3")).isEqualTo(3);
	}
	
	
	@Test
	public void shouldCalculateSumOfNumbersSeparatedWithComma() throws Exception {

		assertThat(StringCalculator.add("1,2")).isEqualTo(3);
		assertThat(StringCalculator.add("3,1,2")).isEqualTo(6);
	}
	
	
	@Test
	public void shouldCalculateSumOfNumbersSeparatedWithNewLine() throws Exception {
		
		assertThat(StringCalculator.add("1\n2")).isEqualTo(3);
	}
	
	
	@Test
	public void shouldCalculateSumOfNumbersSeparatedWithCustomSeparator() throws Exception {

		assertThat(StringCalculator.add("//;\n1;2")).isEqualTo(3);
		assertThat(StringCalculator.add("//;\n3;1;2")).isEqualTo(6);
	}

	@Test
	public void shouldThrowExceptionWhenGivenNegative() throws Exception {

		try {
			StringCalculator.add("-1");
			Fail.fail("exception should be thrown");
		}
		catch (Exception e) {
			assertThat(e).hasMessage("negatives not allowed: -1");
		}
	}

	@Test
	public void shouldThrowExceptionWhenGivenFewNegatives() throws Exception {

		try {
			StringCalculator.add("//;\n-1;2;-3");
			Fail.fail("exception should be thrown");
		}
		catch (Exception e) {
			assertThat(e).hasMessage("negatives not allowed: -1,-3");
		}
	}

	@Test
	public void shouldIgnoreNumbersBiggerThen1000() throws Exception {

		assertThat(StringCalculator.add("2,1001")).isEqualTo(2);
		assertThat(StringCalculator.add("//@\n20003@2@1001")).isEqualTo(2);
	}

	@Test
	public void shouldNotIgnore1000() throws Exception {

		assertThat(StringCalculator.add("//;\n2;1000;3")).isEqualTo(1005);
	}
}
