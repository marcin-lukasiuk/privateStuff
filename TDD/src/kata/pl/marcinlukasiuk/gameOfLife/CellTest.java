package pl.marcinlukasiuk.gameOfLife;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class CellTest {

	
	@Test
	public void shouldBeDead() throws Exception {

		//given
		Cell cell = new Cell();
		cell.setAlive(false);

		//when
		boolean result = cell.isDead();
		//then
		assertThat(result).isTrue();
	}
	
	@Test
	public void shouldNotBeDead() throws Exception {

		//given
		Cell cell = new Cell();
		cell.setAlive(true);

		//when
		boolean result = cell.isDead();
		//then
		assertThat(result).isFalse();
	}
	
	
	@Test
	public void shouldBorn() throws Exception {

		//given
		Cell cell = new Cell();
		cell.setAlive(false);

		//when
		cell.born();
		//then
		assertThat(cell.isAlive()).isTrue();	
	}
	
	@Test
	public void shouldDie() throws Exception {

		//given
		Cell cell = new Cell();
		cell.setAlive(true);

		//when
		cell.die();
		//then
		assertThat(cell.isAlive()).isFalse();	
	}
}
