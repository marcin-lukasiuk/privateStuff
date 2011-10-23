package pl.marcinlukasiuk.math;

import java.util.Stack;

public class Calculator {

	public int calculatePostfixExpression(String expression) {
		return 0;
	}
	/**
	 * Konwersja wyrażenia w formie infix do postfix
	 * Algorytm:
	 * - Wczytuj znaki od lewej do prawej
	 * -- jeżeli znak jest liczbą przepisz do rezultatu
	 * -- w przeciwnym wypadku
	 * --- dopóki stos nie jest pusty i
	 * --- dopóki operator ze stosu ma większy priorytet niż odczytany
	 * ---- zdejmij element ze stosu i przepisz do rezultatu
	 * --- wrzuć odczytany operator na stos
	 * 
	 * - jeżeli nie ma już żadnego elelemntu do odczytania
	 * -- przepisz elementy ze stosu do rezultatu 
	 */
	public String convertInfixToPostfixExpression(String infix) {
		
		String postfix = "";
		
		Stack<Character> stack = new Stack<Character>();
		
		char[] elements = infix.toCharArray();
		
		for (char el : elements) {
			
			if (Character.isDigit(el)) {
				postfix += el;
			}
			else {
				Operator operator = Operator.getBySymbol(el);
				while (!stack.empty()) {
					Operator operatorFromStack = Operator.getBySymbol(stack.peek());
					if (operatorFromStack.hasPrecedenceOver(operator)) {						
						postfix += stack.pop();
					}
					else {
						break;
					}
				}
				stack.push(el);
			}
		}
		while (!stack.empty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}
}
