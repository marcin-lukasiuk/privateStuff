package pl.marcinlukasiuk.bowlingGame2;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import pl.marcinlukasiuk.bowlingGame2.BowlingGame;


public class BowlingGameTest {

	
	private BowlingGame game;
	
	@Before
	public void setUp() {
		game = new BowlingGame();
	}
	
	@Test
	public void shouldCalculateAllZerosGame() throws Exception {

		//given
		rollMany(20, 0);
		
		//when
		int result = game.score();

		//then
		assertThat(result).isEqualTo(0);
	}
	
	
	@Test
	public void shouldCalculateAllOnesGame() throws Exception {

		//given
		rollMany(20, 1);
		
		//when
		int result = game.score();

		//then
		assertThat(result).isEqualTo(20);
	}
	
	
	@Test
	public void shouldCalcultaeGameAllTwos() throws Exception {

		//given
		rollMany(20, 2);
		
		//when
		int result = game.score();

		//then
		assertThat(result).isEqualTo(40);
	}
	
	
	@Test
	public void shouldCalcultaeGameWithSpare() throws Exception {

		//given
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		
		//when
		int result = game.score();

		//then
		assertThat(result).isEqualTo(16);
	}
	
	@Test
	public void shouldCalcultaeGameWithStrike() throws Exception {

		//given
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		
		//when
		int result = game.score();

		//then
		assertThat(result).isEqualTo(24);
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
	
	
	private void rollMany(int numberOfRolls, int points) {
		
		for (int i = 0; i < numberOfRolls; i++) {
			game.roll(points);
		}
	}
}
