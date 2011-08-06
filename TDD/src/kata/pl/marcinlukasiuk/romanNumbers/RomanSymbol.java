package pl.marcinlukasiuk.romanNumbers;

import static com.google.common.collect.Lists.reverse;
import static java.util.Arrays.asList;

/**
 * Symbole rzymskich liczb
 * @author marcin
 */
public enum RomanSymbol {

	I(1, null),
	V(5, I),
	X(10, I),
	L(50, X),
	C(100, X),
	D(500, C),
	M(1000, C);
	
	private RomanSymbol(int intValue, RomanSymbol canBeSubstracted) {
		this.intValue = intValue;
		this.canBeSubstracted = canBeSubstracted;
	}
	
	public static RomanSymbol[] valuesDesc() {
		return reverse(asList(values())).toArray(new RomanSymbol[values().length]);
	}
	
	private int intValue;
	private RomanSymbol canBeSubstracted;
	
	
	public int getIntValue() {
		return intValue;
	}
	
	public RomanSymbol getCanBeSubstracted() {
		return canBeSubstracted;
	}
}
