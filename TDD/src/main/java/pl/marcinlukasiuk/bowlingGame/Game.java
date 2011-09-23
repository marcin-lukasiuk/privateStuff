package pl.marcinlukasiuk.bowlingGame;
/* 
 * Created on 16:24:22 by mlukasiu
 * 
 * Copyright (c) 2001-2010 Contium S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Contium S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie 
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Contium S.A. 
 */

public class Game {

	static final int NUMBER_OF_FRAMES = 10;
	static final int NUMBER_OF_PINS_PER_FRAME = 10;
	
	private int[] rolls = new int[21];
	private int currentRoll = 0;
	
	/**
	 * rzut
	 */
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	/**
	 * oblicza wynik
	 */
	public int score() {
		
		int score = 0;
		
		int frameIndex = 0;
		for (int frame = 0; frame < NUMBER_OF_FRAMES; frame++) {
			
			if (isStrike(frameIndex)) {
				score += NUMBER_OF_PINS_PER_FRAME + strikeBonus(frameIndex);
				frameIndex ++;
			}
			else if (isSpare(frameIndex)) {
				score += NUMBER_OF_PINS_PER_FRAME + spareBonus(frameIndex);
				frameIndex += 2;
			}
			else {
				score += sumInFrame(frameIndex);
				frameIndex += 2;
			}
		}
		return score;
	}


	private int sumInFrame(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex+1];
	}

	private int spareBonus(int frameIndex) {
		return rolls[frameIndex+2];
	}

	private int strikeBonus(int frameIndex) {
		return rolls[frameIndex+1] + spareBonus(frameIndex);
	}

	private boolean isSpare(int frameIndex) {
		return sumInFrame(frameIndex) == NUMBER_OF_PINS_PER_FRAME;
	}
	
	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == NUMBER_OF_PINS_PER_FRAME;
	}

}
