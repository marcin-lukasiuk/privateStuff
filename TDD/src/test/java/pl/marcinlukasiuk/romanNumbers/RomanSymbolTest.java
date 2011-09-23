package pl.marcinlukasiuk.romanNumbers;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class RomanSymbolTest {

	
	@Test
	public void shouldReturnRomunSymbolsOrderedByIntValueDesc() throws Exception {

		//given

		//when
		RomanSymbol[] result = RomanSymbol.valuesDesc();

		//then
		for (int i = 0; i < result.length - 1; i++) {
			assertThat(result[i].getIntValue()).isGreaterThan(result[i+1].getIntValue());
		}
	}
}
