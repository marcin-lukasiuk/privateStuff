package pl.marcinlukasiuk.harrypotter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * 	Once upon a time there was a series of 5 books about a very English hero called Harry. 
 *	(At least when this Kata was invented, there were only 5. Since then they have multiplied) 
 *	Children all over the world thought he was fantastic, and, of course, so did the publisher. 
 *	So in a gesture of immense generosity to mankind, (and to increase sales) they set up the following pricing model to take advantage of Harry's magical powers.
 *
 *	One copy of any of the five books costs 8 EUR. If, however, you buy two different books from the series, you get a 5% discount on those two books. 
 *	If you buy 3 different books, you get a 10% discount. With 4 different books, you get a 20% discount. 
 *	If you go the whole hog, and buy all 5, you get a huge 25% discount.
 *
 *	Note that if you buy, say, four books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, 
 *	but the fourth book still costs 8 EUR.
 *
 *	Potter mania is sweeping the country and parents of teenagers everywhere are queueing up with shopping baskets overflowing with Potter books. 
 *	Your mission is to write a piece of code to calculate the price of any conceivable shopping basket, giving as big a discount as possible.
 *
 *	For example, how much does this basket of books cost?
 * 
 *	2 copies of the first book
 *	2 copies of the second book
 *	2 copies of the third book
 *
 *	1 copy of the fourth book
 *	1 copy of the fifth book
 *
 *	(answer: 51.20 EUR) 
 * 
 * 
 * @author marcin
 *
 */
public class KataPotter {

	public static double price(List<Integer> books) {

		double priceBeforeDiscount = normalPriceFor(quantityOf(books));

		double discount = calculateDiscountFor(books);

		return discountedPrice(priceBeforeDiscount, discount);
	}

	private static double discountedPrice(double priceBeforeDiscount, double discount) {
		return priceBeforeDiscount - discount;
	}

	private static double calculateDiscountFor(List<Integer> books) {

		double discount = 0;

		int[] setOfBooks = optimizedSetOfBooks(books);

		for (int i = 0; i < setOfBooks.length; i++) {
			discount += normalPriceFor(setOfBooks[i]) * percentDiscountByQuantity(setOfBooks[i]);
		}
		return discount;
	}

	private static int[] optimizedSetOfBooks(List<Integer> books) {

		Integer[] quantieties = getSortedQuantieties(books);

		int[] sets = initializeEmptySets(quantieties);

		makeSetsEvenlyFromAllBooksExceptLastOne(quantieties, sets);
		
		int lastBookQuantity = quantieties[4];

		int lastBookQuantityLeft = addLastBookToSetsOfThreeBooks(sets, lastBookQuantity);

		addLastBookToSetsOfFourBooks(sets, lastBookQuantityLeft);

		return sets;
	}

	private static int[] initializeEmptySets(Integer[] quantieties) {
		
		int maxQuantity = quantieties[0];
		return new int[maxQuantity];
	}

	private static int addLastBookToSetsOfFourBooks(int[] sets, int lastBookQuantity) {
		
		for (int j = 0; j < sets.length && lastBookQuantity > 0; j++) {
			sets[j]++;
			lastBookQuantity--;
		}
		return lastBookQuantity;
	}

	private static int addLastBookToSetsOfThreeBooks(int[] sets, int lastBookQuantity) {
		
		for (int j = 0; j < sets.length && lastBookQuantity > 0; j++) {
			if (sets[j] == 3) {
				sets[j]++;
				lastBookQuantity--;
			}
		}
		return lastBookQuantity;
	}

	private static void makeSetsEvenlyFromAllBooksExceptLastOne(Integer[] quantieties, int[] sets) {
		
		for (int i = 0; i < quantieties.length - 1; i++) {
			for (int j = 0; j < sets.length && quantieties[i] > 0; j++) {
				sets[j]++;
				quantieties[i]--;
			}
		}
	}

	private static Integer[] getSortedQuantieties(List<Integer> books) {

		Integer quantieties[] = { 0, 0, 0, 0, 0 };

		for (Integer book : books) {
			quantieties[book - 1]++;
		}

		Arrays.sort(quantieties, Collections.reverseOrder());
		return quantieties;
	}

	private static double percentDiscountByQuantity(int booksQuantity) {

		switch (booksQuantity) {
			case 2:
				return 0.05;
			case 3:
				return 0.1;
			case 4:
				return 0.2;
			case 5:
				return 0.25;
			default:
				return 0;
		}
	}

	private static int quantityOf(Collection<Integer> books) {
		return books.size();
	}

	private static int normalPriceFor(int quantity) {
		return quantity * 8;
	}
}
