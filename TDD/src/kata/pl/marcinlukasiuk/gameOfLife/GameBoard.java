package pl.marcinlukasiuk.gameOfLife;


/**
 * plansza gry w życie {@link GameOfLife}
 * 
 * @author marcin
 */
public class GameBoard {

	private Cell[][] board;
	
	public GameBoard(int i, int j) {
		board = new Cell[i][j];
		for (int k = 0; k < i; k++) {
			for (int l = 0; l < j; l++) {
				board[k][l] = new Cell();
			}
		}
	}

	public Cell getCell(int x, int y) {
		if (x < 0 || x >= board.length ) {
			return new DeadCell();
		}
		if (y < 0 || y >= board.length) {
			return new DeadCell();
		}
		return board[x][y];
	}
	
	public Cell getNeighbourCell(NeighourDirection direction, int x, int y) {
		return getCell(x + direction.getVerticalOffset(), y + direction.getHorizontalOffset());
	}
	
	public int numberOfNeighbours(int x, int y) {
		
		int neighBours = 0;
		
		for (int i = 0; i < NeighourDirection.values().length; i++) {
			if (hasNeighbour(NeighourDirection.values()[i], x, y)) {
				neighBours ++;
			}
		}
		
		return neighBours;
	}

	private boolean hasNeighbour(NeighourDirection direction, int x, int y) {
		return getNeighbourCell(direction, x, y).isAlive();
	}

	public void bornCell(int x, int y) {
		getCell(x, y).born();
	}
	
	public void killCell(int x, int y) {
		getCell(x, y).die();
	}
	
	public Cell[][] getBoard() {
		return board;
	}
}
