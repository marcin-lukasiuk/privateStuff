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

	/**
	 * Despite the lack of standardization, modern textbooks and references often state additional rules, including the following:
     * The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. "D", "L", and "V" can never be repeated.
     * "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. 
     * "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted
     * Only one small-value symbol may be subtracted from any large-value symbol.
	 */
	public static String intToRoman(int number) {
		
		String romanNumber = "";
		RomanSymbol[] symbols = RomanSymbol.valuesDesc();
		
		while (number != 0) {
			for (int i = 0; i < symbols.length; i++) {
				
				RomanSymbol symbol = symbols[i];
				if (number >= symbol.getIntValue()) {
					romanNumber += symbol.name();
					number -= symbol.getIntValue();
					break;
				}
				else if(substractionPossible(number, symbol)) {
					romanNumber += symbol.getCanBeSubstracted().name() + symbol.name();
					number -= (symbol.getIntValue() - symbol.getCanBeSubstracted().getIntValue());
					break;
				}
			}
		}
		
		return romanNumber;
	}

	private static boolean substractionPossible(int number, RomanSymbol symbol) {
		return number >= symbol.getIntValue() - symbol.getCanBeSubstracted().getIntValue();
	}
}
