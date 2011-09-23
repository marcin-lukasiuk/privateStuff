/* 
 * Created on 21:37:32 by mlukasiu
 * 
 * Copyright (c) 2001-2010 Contium S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Contium S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie 
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Contium S.A. 
 */

package pl.marcinlukasiuk.sort;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;


import org.junit.Test;

import com.google.common.collect.Lists;


public class BubbleSortTest {

	
	
	@Test
	public void shouldReturnEmptyListWhenGivenEmptyListToSort() throws Exception {

		//given
		BubbleSort sort = new BubbleSort();
		
		List<Integer> in = Lists.newArrayList();

		//when
		List<Integer> result = sort.sort(in);

		//then
		assertThat(result).isNotNull()
						  .isEmpty();
	}
	
	
	@Test
	public void shouldReturnOneElementListWhenGivenOneElementList() throws Exception {

		//given
		BubbleSort sort = new BubbleSort();
		
		List<Integer> in = Lists.newArrayList(1);

		//when
		List<Integer> result = sort.sort(in);

		//then
		assertThat(result).containsExactly(1);
	}
	
	@Test
	public void shouldSortTwoElementList() throws Exception {

		//given
		BubbleSort sort = new BubbleSort();
		
		List<Integer> in = Lists.newArrayList(2, 1);

		//when
		List<Integer> result = sort.sort(in);

		//then
		assertThat(result).containsExactly(1, 2);
	}
	
	@Test
	public void shouldSortThreeElementList() throws Exception {

		//given
		BubbleSort sort = new BubbleSort();
		
		List<Integer> in = Lists.newArrayList(3, 2, 1);

		//when
		List<Integer> result = sort.sort(in);

		//then
		assertThat(result).containsExactly(1, 2, 3);
	}
	
	@Test
	public void shouldSortTenElementList() throws Exception {

		//given
		BubbleSort sort = new BubbleSort();
		
		List<Integer> in = Lists.newArrayList(3, 2, 1, 7, 8, 0, 9, 4, 2, 5);

		//when
		List<Integer> result = sort.sort(in);

		//then
		assertThat(result).containsExactly(0, 1, 2, 2, 3, 4, 5, 7, 8, 9);
	}
}
