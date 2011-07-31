package pl.marcinlukasiuk.gameOfLife;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;


public class GameBoardTest {

	private static final int x = 1;
	private static final int y = 1;
	
	private GameBoard gameBoard;
	
	
	@Before
	public void setUp() {
		gameBoard = new GameBoard(3, 3);
	}
	
	@Test
	public void shouldCreateGameBoardOfGivenSize() throws Exception {

		//when
		GameBoard gameBoard = new GameBoard(3, 4);

		//then
		assertThat(gameBoard.getBoard()).hasSize(3);
		assertThat(gameBoard.getBoard()[0]).hasSize(4);
	}
	
	
	@Test
	public void shouldCreateGameBoardWithDeadCells() throws Exception {

		//then
		for (int i = 0; i < gameBoard.getBoard().length; i++) {
			for (int j = 0; j < gameBoard.getBoard()[i].length; j++) {
				assertThat(gameBoard.getBoard()[i][j].isDead()).isTrue();
			}
		}
	}
	
	
	@Test
	public void shouldGetCell() throws Exception {

		//given
		Cell expected = gameBoard.getBoard()[x][y];
		
		//when
		Cell result = gameBoard.getCell(x, y);
		//then
		assertThat(result).isSameAs(expected);
	}
	
	@Test
	public void shouldGetDeadCellWhenCoordinatesOutsideTheBoard() throws Exception {
		
		//when
		Cell result1 = gameBoard.getCell(-1, 0);
		Cell result2 = gameBoard.getCell(3, 0);
		Cell result3 = gameBoard.getCell(0, -1);
		Cell result4 = gameBoard.getCell(0, 3);
		//then
		assertThat(result1).isInstanceOf(DeadCell.class);
		assertThat(result2).isInstanceOf(DeadCell.class);
		assertThat(result3).isInstanceOf(DeadCell.class);
		assertThat(result4).isInstanceOf(DeadCell.class);
	}
	
	@Test
	public void shouldGetNeighbourCellCell() throws Exception {

		//given
		Cell expected = gameBoard.getBoard()[x][y-1];
		
		//when
		Cell result = gameBoard.getNeighbourCell(NeighbourDirection.LEFT, x, y);
		//then
		assertThat(result).isSameAs(expected);
	}
	
	
	@Test
	public void shouldBornCell() throws Exception {

		//when
		gameBoard.bornCell(x, y);
		//then
		assertThat(gameBoard.getBoard()[x][y].isAlive()).isTrue();
	}
	
	
	@Test
	public void shouldKillCell() throws Exception {

		//given
		gameBoard.getCell(x, y).die();
		//when
		gameBoard.killCell(x, y);
		//then
		assertThat(gameBoard.getBoard()[x][y].isAlive()).isFalse();
	}
	
	
	@Test
	public void shouldCellHaveNoNeighbours() throws Exception {

		//when
		int result = gameBoard.numberOfNeighbours(x, y);
		//then
		assertThat(result).isEqualTo(0);
	}
	
	
	@Test
	public void shouldCellHaveOneNeighbourOnTheRight() throws Exception {

		//given
		bornNeighbourCell(NeighbourDirection.RIGHT, x, y, gameBoard);
		
		//when
		int result = gameBoard.numberOfNeighbours(x, y);
		//then
		assertThat(result).isEqualTo(1);
	}
	
	
	@Test
	public void shouldCellHaveOneNeighbourOnTheLeft() throws Exception {

		//given
		bornNeighbourCell(NeighbourDirection.LEFT, x, y, gameBoard);
		
		//when
		int result = gameBoard.numberOfNeighbours(x, y);
		//then
		assertThat(result).isEqualTo(1);
	}
	
	
	@Test
	public void shouldCellHaveTwoNeighboursVertically() throws Exception {

		//given
		bornNeighbourCell(NeighbourDirection.LEFT, x, y, gameBoard);
		bornNeighbourCell(NeighbourDirection.RIGHT, x, y, gameBoard);
		
		//when
		int result = gameBoard.numberOfNeighbours(x, y);
		//then
		assertThat(result).isEqualTo(2);
	}
	
	
	@Test
	public void shouldCellHaveOneNeighbourOnTop() throws Exception {

		//given
		bornNeighbourCell(NeighbourDirection.TOP, x, y, gameBoard);
		
		//when
		int result = gameBoard.numberOfNeighbours(x, y);
		//then
		assertThat(result).isEqualTo(1);
	}
	
	
	@Test
	public void shouldCellHaveOneNeighbourOnBottom() throws Exception {

		bornNeighbourCell(NeighbourDirection.BOTTOM, x, y, gameBoard);	
		
		//when
		int result = gameBoard.numberOfNeighbours(x, y);
		//then
		assertThat(result).isEqualTo(1);
	}
	
	
	@Test
	public void shouldCellHaveFourNeighboursHorizontallyAndVertically() throws Exception {

		//given	
		bornNeighbourCell(NeighbourDirection.LEFT, x, y, gameBoard);
		bornNeighbourCell(NeighbourDirection.RIGHT, x, y, gameBoard);
		bornNeighbourCell(NeighbourDirection.TOP, x, y, gameBoard);
		bornNeighbourCell(NeighbourDirection.BOTTOM, x, y, gameBoard);	
		
		//when
		int result = gameBoard.numberOfNeighbours(x, y);
		//then
		assertThat(result).isEqualTo(4);
	}
	
	@Test
	public void shouldCellHaveFourNeighboursDiagonally() throws Exception {

		//given
		bornNeighbourCell(NeighbourDirection.TOP_LEFT, x, y, gameBoard);
		bornNeighbourCell(NeighbourDirection.TOP_RIGHT, x, y, gameBoard);
		bornNeighbourCell(NeighbourDirection.BOTTOM_LEFT, x, y, gameBoard);
		bornNeighbourCell(NeighbourDirection.BOTTOM_RIGHT, x, y, gameBoard);		
		//when
		int result = gameBoard.numberOfNeighbours(x, y);
		//then
		assertThat(result).isEqualTo(4);
	}


	private void bornNeighbourCell(NeighbourDirection direction, int x, int y, GameBoard gameBoard) {
		gameBoard.getNeighbourCell(direction, x, y).born();
	}

}
