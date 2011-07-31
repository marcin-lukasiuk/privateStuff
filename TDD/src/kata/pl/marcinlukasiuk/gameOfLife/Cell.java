package pl.marcinlukasiuk.gameOfLife;

/**
 * Pojedyncza komórka
 *
 * @author mlukasiu
 */
public class Cell {
	
	public static final Cell DEAD_CELL= new DeadCell();

	boolean alive;
	boolean bornNextRound;
	boolean dieNextRound;
	
	
	
	public void born() {
		alive = true;
	}
	
	public void die() {
		alive = false;
	}
	
	public boolean isDead() {
		return !alive;
	}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isBornNextRound() {
		return bornNextRound;
	}

	public void setBornNextRound(boolean bornNextRound) {
		this.bornNextRound = bornNextRound;
	}

	public boolean isDieNextRound() {
		return dieNextRound;
	}

	public void setDieNextRound(boolean dieNextRound) {
		this.dieNextRound = dieNextRound;
	}
}
