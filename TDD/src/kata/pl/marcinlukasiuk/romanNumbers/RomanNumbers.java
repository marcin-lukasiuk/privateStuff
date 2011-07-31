package pl.marcinlukasiuk.romanNumbers;

import com.google.common.base.Enums;


/**
 * Liczby rzymskie
 * @author marcin
 */
public class RomanNumbers {

	public static int romanToInt(String romanString) {
		
		int result = 0;
		
		RomanSymbol[] romanSymbols = toRomanSymbolArray(romanString);
		
		for (int i = 0; i < romanSymbols.length; i++) {
			
			if (hasNextSymbol(romanSymbols, i) && nextSymbolIsBigger(romanSymbols, i)) {
				result -= romanSymbols[i].getIntValue(); 
			}
			else {
				result += romanSymbols[i].getIntValue(); 
			}
		}
		
		return result;
	}

	private static boolean nextSymbolIsBigger(RomanSymbol[] romanSymbols, int i) {
		return romanSymbols[i+1].getIntValue() > romanSymbols[i].getIntValue();
	}

	private static boolean hasNextSymbol(RomanSymbol[] romanSymbols, int i) {
		return i+1 < romanSymbols.length;
	}

	private static RomanSymbol[] toRomanSymbolArray(String romanString) {
		char[] chars = romanString.toCharArray();
		RomanSymbol[] romanSymbols = new RomanSymbol[chars.length];
		
		for (int i = 0; i < chars.length; i++) {
			romanSymbols[i] = Enums.valueOfFunction(RomanSymbol.class).apply(chars[i] + "");
			
			if (romanSymbols[i] == null) {
				throw new IllegalArgumentException("Illegal symbols in given string: " + romanString);
			}
		}
		return romanSymbols;
	}

}
