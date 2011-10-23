package pl.marcinlukasiuk.math;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class CalculatorTest {

	private Calculator calculator = new Calculator();
	
	
	
	@Test
	public void shouldConvertInfixToPostfixExpression() throws Exception {

		testInfixToPostfixConversion("", "");
		testInfixToPostfixConversion("1", "1");
		testInfixToPostfixConversion("1+2", "12+");
		testInfixToPostfixConversion("1+2+3", "12+3+");
		testInfixToPostfixConversion("1+2-3", "12+3-");
		testInfixToPostfixConversion("1+2*3", "123*+");
		testInfixToPostfixConversion("1*2+3", "12*3+");
		testInfixToPostfixConversion("1+2/3", "123/+");
		testInfixToPostfixConversion("1*2-3/4*5", "12*34/5*-");
		testInfixToPostfixConversion("1*2-3/4*5+6", "12*34/5*-6+");
	}
	
	private void testInfixToPostfixConversion(String infix, String postfix) {
		
		//when
		String actual = calculator.convertInfixToPostfixExpression(infix);

		//then
		assertThat(actual).isEqualTo(postfix);
	}
}
