package pl.marcinlukasiuk.gameOfLife;

/**
 * położenie sąsiada komórki {@link Cell}
 * 
 * @author marcin
 */
public enum NeighourDirection {
	
	LEFT         ( 0, -1),
	RIGHT        ( 0,  1),
	TOP          (-1,  0),
	BOTTOM       ( 1,  0),
	TOP_LEFT     (-1, -1),
	TOP_RIGHT    (-1,  1),
	BOTTOM_LEFT  ( 1, -1),
	BOTTOM_RIGHT ( 1,  1);
	
	private NeighourDirection(int verticalOffset, int horizontalOffset) {
		this.verticalOffset = verticalOffset;
		this.horizontalOffset = horizontalOffset;
	}
	
	private int verticalOffset;
	private int horizontalOffset;
	
	
	public int getVerticalOffset() {
		return verticalOffset;
	}
	public int getHorizontalOffset() {
		return horizontalOffset;
	}
}
