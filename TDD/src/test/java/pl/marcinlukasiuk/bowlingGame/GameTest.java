package pl.marcinlukasiuk.bowlingGame;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
	@Before
	public void setUp() {
		game = new Game();
	}
	
	@Test
	public void shouldZeroPinsRollesScoresGiveFinalScoreEqualToZero() throws Exception {

		//given
		rollMany(20, 0);

		//when
		int result = game.score();

		//then
		assertThat(result).isEqualTo(0);
	}
	
	@Test
	public void shouldOnePinsRollesGiveFinalScoreEqualToNumberOfRolls() throws Exception {

		//given
		rollMany(20, 1);

		//when
		int result = game.score();

		//then
		assertThat(result).isEqualTo(20);
	}
	
	
	@Test
	public void shouldDoubleNextFrameAfterSpare() throws Exception {

		//given
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		
		//when
		int result = game.score(); 
		
		//then
		assertThat(result).isEqualTo(10 + 6);
	}
	
	
	@Test
	public void shouldDoubleNextToFramesAfterStrike() throws Exception {

		//given
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		
		//when
		int result = game.score();

		//then
		assertThat(result).isEqualTo(10 + 6 + 8);
	}
	
	@Test
	public void shouldCalculatePerfectGame() throws Exception {

		//given
		rollMany(12, 10);

		//when
		int result = game.score();

		//then
		assertThat(result).isEqualTo(300);
	}

	private void rollStrike() {
		game.roll(10);
	}

	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}
	
	
	private void rollMany(int numberOfRolls, int pins) {
		
		for (int i = 0; i < numberOfRolls; i++) {
			game.roll(pins);
		}
	}
}
