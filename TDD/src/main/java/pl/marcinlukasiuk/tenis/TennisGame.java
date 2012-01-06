package pl.marcinlukasiuk.tenis;

/**
 * 1. A game is won by the first player to have won at least four points in
 * total and at least two points more than the opponent.
 * 
 * 2. The running score of each game is described in a manner peculiar to
 * tennis: scores from zero to three points are described as "love", "fifteen",
 * "thirty", and "forty" respectively.
 * 
 * 3. If at least three points have been scored by each player, and the scores
 * are equal, the score is "deuce".
 * 
 * 4. If at least three points have been scored by each side and a player has
 * one more point than his opponent, the score of the game is "advantage" for
 * the player in the lead.
 * 
 * @author marcin
 */
public class TennisGame {

	private static final String PLAYER_ONE_NAME = "Player One";
	private static final String PLAYER_TWO_NAME = "Player Two";
	
	private int playerOneScore;
	private int playerTwoScore;


	public void playerOneScores() {
		playerOneScore++;
	}

	public void playerTwoScores() {
		playerTwoScore++;
	}

	public String getScore() {

		if (isDeuce()) {
			return "Deuce";
		}
		if (playerOneWins()) {
			return PLAYER_ONE_NAME + " wins";
		}
		if (playerTwoWins()) {
			return PLAYER_TWO_NAME + " wins";
		}
		if (playerOneHasAdvantage()) {
			return "Advantage " + PLAYER_ONE_NAME;
		}
		if (playerTwoHasAdvantage()) {
			return "Advantage " + PLAYER_TWO_NAME;
		}
		if (bothPlayersHaveTheSameScore()) {
			return scoreName(playerOneScore) + " all";
		}
		else {
			return scoreName(playerOneScore) + "," + scoreName(playerTwoScore);
		}
	}

	private boolean playerOneHasAdvantage() {
		return bothPlayersHaveScoreThreeOrMore() && playerOneScore > playerTwoScore;
	}
	
	private boolean playerTwoHasAdvantage() {
		return bothPlayersHaveScoreThreeOrMore() && playerOneScore < playerTwoScore;
	}
	
	private boolean playerOneWins() {
		return playerOneScore >= 3  && (playerOneScore - 1 > playerTwoScore || playerTwoScore < 3);
	}
	
	private boolean playerTwoWins() {
		return playerTwoScore >= 3 && (playerOneScore < playerTwoScore - 1 || playerOneScore < 3);
	}

	private boolean isDeuce() {
		return bothPlayersHaveTheSameScore() && bothPlayersHaveScoreThreeOrMore();
	}
	
	private boolean bothPlayersHaveTheSameScore() {
		return playerOneScore == playerTwoScore;
	}
	
	private boolean bothPlayersHaveScoreThreeOrMore() {
		return playerOneScore >= 3 && playerTwoScore >= 3;
	}

	private String scoreName(int score) {

		switch (score) {
			case 0:
				return "Love";
			case 1:
				return "Fifteen";
			case 2:
				return "Thirty";
		}

		return "";
	}
}
