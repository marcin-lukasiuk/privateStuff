/* 
 * Created on 21:37:19 by mlukasiu
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

import java.util.List;

public class BubbleSort {

	public List<Integer> sort(List<Integer> in) {
		int numberOfIterations = 0;
		boolean somethingChanged = true;
		while (somethingChanged) {
			somethingChanged = false;
			for (int i = 0; i < in.size() - numberOfIterations; i++) {
				if (hasNext(in, i)) {
					if (hasNextBigger(in, i)) {
						switchPlaces(in, i, i+1);
						somethingChanged = true;
					}
				}
			}
			numberOfIterations ++;
		}
		
		return in;
	}

	private boolean hasNextBigger(List<Integer> in, int i) {
		return in.get(i) > in.get(i+1);
	}

	private boolean hasNext(List<Integer> in, int i) {
		return in.size() > i+1;
	}

	private void switchPlaces(List<Integer> in, int i, int j) {
		Integer temp = in.get(i);
		in.set(i, in.get(j));
		in.set(j, temp);
	}

}
