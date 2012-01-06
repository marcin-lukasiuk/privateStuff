package pl.marcinlukasiuk.bowlingGame;

public class BowlingGame {

	private int rollNumber = 0;
	private int[] rolls = new int[21];
	
	public int score() {
		
		int score = 0;
		
		int rollIndex = 0;
		for (int round = 0; round < 10; round++) {
			
			if (isStrike(rollIndex)) {
				score += 10 + strikeBonus(rollIndex);
				rollIndex++;
			}
			else if (isSpare(rollIndex)) {
				score += 10 + spareBonus(rollIndex);
				rollIndex += 2;
			}
			else {
				score += sumRound(rollIndex);
				rollIndex += 2;
			}
		}
		return score;
	}

	private int spareBonus(int rollIndex) {
		return rolls[rollIndex+2];
	}
	
	private int strikeBonus(int rollIndex) {
		return rolls[rollIndex+1] + spareBonus(rollIndex);
	}

	private boolean isStrike(int rollIndex) {
		return rolls[rollIndex] == 10;
	}

	private int sumRound(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex+1];
	}

	private boolean isSpare(int round) {
		return sumRound(round) == 10;
	}

	public void roll(int points) {

		rolls[rollNumber] = points;
		rollNumber++;
	}

}
