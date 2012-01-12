package pl.marcinlukasiuk.harrypotter;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;
import static pl.marcinlukasiuk.harrypotter.KataPotter.price;

import java.util.List;

import org.junit.Test;


public class KataPotterTest {

	@Test
	public void priceShouldBe8ForSingleBook() throws Exception {
		assertThat(price(forBooks(1))).isEqualTo(8);
		assertThat(price(forBooks(2))).isEqualTo(8);
		assertThat(price(forBooks(3))).isEqualTo(8);
		assertThat(price(forBooks(4))).isEqualTo(8);
		assertThat(price(forBooks(5))).isEqualTo(8);
	}

	@Test
	public void priceOfXBooksSameKindShouldBeXmultipledBy8() throws Exception {
		assertThat(price(forBooks(1, 1))).isEqualTo(16);
		assertThat(price(forBooks(1, 1, 1))).isEqualTo(24);
		assertThat(price(forBooks(1, 1, 1, 1, 1))).isEqualTo(40);
	}

	@Test
	public void priceOfTwoDifferentBooksShouldBeDiscountedBy5Percent() throws Exception {
		assertThat(price(forBooks(1, 2))).isEqualTo(16.0 - 0.8);
	}

	@Test
	public void priceOfThreeDifferentBooksShouldBeDiscountedBy10Percent() throws Exception {
		assertThat(price(forBooks(1, 2, 3))).isEqualTo(24.0 - 2.4);
	}

	@Test
	public void priceOfFourDifferentBooksShouldBeDiscountedBy20Percent() throws Exception {
		assertThat(price(forBooks(1, 2, 3, 4))).isEqualTo(32.0 - 6.4);
	}

	@Test
	public void priceOfFiveDifferentBooksShouldBeDiscountedBy25Percent() throws Exception {
		assertThat(price(forBooks(1, 2, 3, 4, 5))).isEqualTo(40.0 - 10.0);
	}

	@Test
	public void priceOfFourDifferentBooksAndOneRepeatedShouldBeDiscountedBy20PercentOnFourBooks() throws Exception {
		assertThat(price(forBooks(1, 2, 3, 4, 4))).isEqualTo(40.0 - 6.4);
	}

	@Test
	public void priceOfSetOfFourBooksAndTwoBooksAlreadyInSetShouldBeDiscountedBy20PercentOnSet() throws Exception {
		assertThat(price(forBooks(1, 2, 3, 4, 4, 4))).isEqualTo(48.0 - 6.4);
	}

	@Test
	public void priceOfTwoSetsOfTwoBooksShouldBeDiscountedBy5PercentOnBothSets() throws Exception {
		assertThat(price(forBooks(1, 1, 2, 2))).isEqualTo(32 - (0.8 + 0.8));
	}
	
	@Test
	public void priceShouldBeDiscountedBy10PercentOnSetOf3BooksAnd5PercentOnSetOfTwoBooks() throws Exception {
		assertThat(price(forBooks(1, 1, 2, 2, 3))).isEqualTo(40.0 - (2.4 + 0.8));
	}
	
	@Test
	public void should() throws Exception {
		assertThat(price(forBooks(1, 1, 2, 2, 3, 3, 4, 5))).isEqualTo(64.0 - (6.4 + 6.4));
	}

	private List<Integer> forBooks(Integer... books) {
		return newArrayList(books);
	}
}
