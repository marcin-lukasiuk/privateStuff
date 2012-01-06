package pl.marcinlukasiuk.tenis;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;


public class TennisGameTest {

	private TennisGame tennisGame;


	@Before
	public void setUp() {
		tennisGame = new TennisGame();
	}

	@Test
	public void scoreShouldBeLoveAllOnGameStart() throws Exception {

		// given
		setScore(0, 0);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Love all");
	}

	@Test
	public void scoreShouldBeFifteenLoveWhenPlayerOneScores() throws Exception {

		// given
		setScore(1, 0);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Fifteen,Love");
	}

	@Test
	public void scoreShouldBeThirtyLoveWhenPlayerOneScoresTwice() throws Exception {

		// given
		setScore(2, 0);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Thirty,Love");
	}

	@Test
	public void scoreShouldBeFifteenAllWhenBothPlayersScoresOnce() throws Exception {

		// given
		setScore(1, 1);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Fifteen all");
	}

	@Test
	public void scoreShouldBeLoveThirtyWhenPlayerTwoScoresTwice() throws Exception {

		// given
		setScore(0, 2);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Love,Thirty");
	}

	@Test
	public void scoreShouldBeThirtyallWhenBothPlayersScoresTwice() throws Exception {

		// given
		setScore(2, 2);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Thirty all");
	}

	@Test
	public void scoreShouldBePlayerOneWinsWhenPlayerOneScoresThreeTimes() throws Exception {

		// given
		setScore(3, 0);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Player One wins");
	}

	@Test
	public void scoreShouldBePlayerTwoWinsWhenPlayerOneScoresTwiceAndPlayerTwoThreeTimes() throws Exception {

		// given
		setScore(2, 3);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Player Two wins");
	}

	@Test
	public void scoreShouldBeDeuceWhenBothPlayersScoresThreeTimes() throws Exception {

		// given
		setScore(3, 3);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Deuce");
	}
	
	@Test
	public void scoreShouldBeDeuceWhenBothPlayersScoresFourTimes() throws Exception {

		// given
		setScore(4, 4);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Deuce");
	}
	
	@Test
	public void scoreShouldBeAdvantagePlayerTwoWhenPlayerOneScoresThreeTimesAndPlayerTwoScoresFourTimes() throws Exception {

		// given
		setScore(3, 4);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Advantage Player Two");
	}
	
	@Test
	public void scoreShouldBeAdvantagePlayerOneWhenPlayerOneScoresSevenTimesAndPlayerTwoScoresSixTimes() throws Exception {

		// given
		setScore(7, 6);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Advantage Player One");
	}
	
	@Test
	public void scoreShouldBePlayerOneWinsWhenPlayerOneScoresSevenTimesAndPlayerTwoScoresFiveTimes() throws Exception {

		// given
		setScore(7, 5);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Player One wins");
	}
	
	@Test
	public void scoreShouldBePlayerTwoWinsWhenPlayerOneScoresThreeTimesAndPlayerTwoScoresFiveTimes() throws Exception {

		// given
		setScore(3, 5);
		// when
		String score = tennisGame.getScore();
		// then
		assertThat(score).isEqualTo("Player Two wins");
	}
	
	

	private void setScore(int playerOneScore, int playerTwoScore) {
		for (int i = 0; i < playerOneScore; i++) {
			tennisGame.playerOneScores();
		}
		for (int i = 0; i < playerTwoScore; i++) {
			tennisGame.playerTwoScores();
		}
	}
}
