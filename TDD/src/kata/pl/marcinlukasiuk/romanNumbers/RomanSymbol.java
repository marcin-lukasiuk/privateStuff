package pl.marcinlukasiuk.romanNumbers;

/**
 * Symbole rzymskich liczb
 * @author marcin
 */
public enum RomanSymbol {

	I(1),
	V(5),
	X(10),
	L(50),
	C(100),
	D(500),
	M(1000);
	
	private RomanSymbol(int intValue) {
		this.intValue = intValue;
	}
	
	private int intValue;
	
	public int getIntValue() {
		return intValue;
	}
}
