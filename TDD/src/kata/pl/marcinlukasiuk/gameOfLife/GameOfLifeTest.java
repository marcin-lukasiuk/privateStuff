package pl.marcinlukasiuk.gameOfLife;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;


public class GameOfLifeTest {

	
	private GameOfLife gameOfLife;
	
	@Before
	public void setUp() {
		gameOfLife = new GameOfLife();
	}
	
	@Test
	public void shouldCreateGameOfLifeWithBoardOfDeafaultSize() throws Exception {

		//then
		assertThat(gameOfLife.getGameBoard().getBoard()).hasSize(GameOfLife.DEAFAULT_SIZE);
		assertThat(gameOfLife.getGameBoard().getBoard()[0]).hasSize(GameOfLife.DEAFAULT_SIZE);
	}
	
	
	@Test
	public void shouldBornDeadCellWithThreeNeighbours() throws Exception {

		bornCell(0, 1);
		bornCell(0, 0);
		bornCell(1, 2);
		killCell(1, 1);
		
		//when
		gameOfLife.cycleOfLife();

		//then
		assertThat(gameOfLife.getGameBoard().getCell(1, 1).isAlive()).isTrue();
	}
	
	@Test
	public void shouldKillAliveCellWithFourOrMoreNeighbours() throws Exception {

		//given
		bornCell(0, 1);
		bornCell(2, 1);
		bornCell(1, 0);
		bornCell(1, 2);
		bornCell(1, 1);
		
		//when
		gameOfLife.cycleOfLife();

		//then
		assertThat(gameOfLife.getGameBoard().getCell(1, 1).isDead()).isTrue();
	}
	
	@Test
	public void shouldKillAliveCellWithLessThenTwoNeighbours() throws Exception {

		//given
		bornCell(0, 1);
		bornCell(1, 1);
		
		//when
		gameOfLife.cycleOfLife();

		//then
		assertThat(gameOfLife.getGameBoard().getCell(1, 1).isDead()).isTrue();
	}
	
	@Test
	public void aliveCellWithTwoNeighboursShouldStayAlive() throws Exception {

		//given
		bornCell(0, 1);
		bornCell(2, 1);
		bornCell(1, 1);
		
		//when
		gameOfLife.cycleOfLife();

		//then
		assertThat(gameOfLife.getGameBoard().getCell(1, 1).isAlive()).isTrue();
	}
	
	@Test
	public void aliveCellWithThreeNeighboursShouldStayAlive() throws Exception {

		//given
		bornCell(0, 1);
		bornCell(2, 1);
		bornCell(0, -1);
		bornCell(1, 1);
		
		//when
		gameOfLife.cycleOfLife();

		//then
		assertThat(gameOfLife.getGameBoard().getCell(1, 1).isAlive()).isTrue();
	}


	private void bornCell(int x, int y) {
		gameOfLife.getGameBoard().bornCell(x, y);
	}
	
	private void killCell(int x, int y) {
		gameOfLife.getGameBoard().killCell(x, y);
	}
}
