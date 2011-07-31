package pl.marcinlukasiuk.gameOfLife;

/**
 * Sztuczna martwa komórka (Null object pattern)
 * 
 * @author marcin
 */
class DeadCell extends Cell {

	@Override
	public boolean isAlive() {
		return false;
	}
	
	@Override
	public boolean isDead() {
		return true;
	}
}
