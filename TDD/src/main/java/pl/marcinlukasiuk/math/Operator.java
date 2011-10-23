package pl.marcinlukasiuk.math;

public enum Operator {

	ADDITION('+', 3),
	SUBTRACKTION('-', 3),
	MULTIPLICATION('*', 2),
	DIVISION('/', 2);
	
	private Operator(char symbol, int precedence) {
		this.symbol = symbol;
		this.precedence = precedence;
	}
	
	private final char symbol;
	private final int precedence;
	
	
	public static Operator getBySymbol(char symbol) {
		for (int i = 0; i < values().length; i++) {
			if (values()[i].getSymbol() == symbol) {
				return values()[i];
			}
		}
		return null;
	}
	
	public boolean hasPrecedenceOver(Operator operator) {
		return this.precedence <= operator.getPrecedence();
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public int getPrecedence() {
		return precedence;
	}
}
