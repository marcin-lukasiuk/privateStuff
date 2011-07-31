package pl.marcinlukasiuk.gameOfLife;

import java.util.Random;



/**
 * Gra w życie
 * 
 * @author marcin
 */
public class GameOfLife {

	public static final int DEAFAULT_SIZE = 10;
	
	private GameBoard gameBoard;
	
	public GameOfLife() {
		gameBoard = new GameBoard(DEAFAULT_SIZE, DEAFAULT_SIZE);
	}
	
	public void cycleOfLife() {
		
		for (int i = 0; i < gameBoard.getBoard().length; i++) {
			for (int j = 0; j < gameBoard.getBoard()[i].length; j++) {
				int numberOfNeighbours = gameBoard.numberOfNeighbours(i, j);
				if (numberOfNeighbours == 3) {
					gameBoard.getCell(i, j).setBornNextRound(true);
				}
				else if (numberOfNeighbours > 3) {
					gameBoard.getCell(i, j).setDieNextRound(true);
				}
				else if (numberOfNeighbours < 2) {
					gameBoard.getCell(i, j).setDieNextRound(true);
				}
			}
		}
		
		for (Cell[] cellRow : gameBoard.getBoard()) {
			for (Cell cell : cellRow) {
				if (cell.isBornNextRound()) {
					cell.born();
					cell.setBornNextRound(false);
				}
				else if (cell.isDieNextRound()) {
					cell.die();
					cell.setDieNextRound(false);
				}
			}
		}
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		GameOfLife gameOfLife = new GameOfLife();
		Random random = new Random();
		for (Cell[] cellRow : gameOfLife.getGameBoard().getBoard()) {
			for (Cell cell : cellRow) {
				if (random.nextDouble() > 0.7) {
					cell.born();
				}
			}
		}
		for (int i = 0; i < 30; i++) {
			System.out.print("- - - - - - - - - - -\n");
			for (Cell[] cellRow : gameOfLife.getGameBoard().getBoard()) {
				
				for (Cell cell : cellRow) {
					if (cell.isAlive()) {
						System.out.print("+");
					}
					else {
						System.out.print(" ");
					}
					System.out.print(" ");
				}
				System.out.print("|\n");
			}
			gameOfLife.cycleOfLife();
			Thread.sleep(1000);
		}
		
	}
}
