
/* Author: Jian Fang
 * 
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class GameOfLifeTest {
	@Test
	public void testConstructorAndGetters() {
		GameOfLife society = new GameOfLife(5, 8);
		assertEquals(5, society.numberOfRows());
		assertEquals(8, society.numberOfColumns());
		for (int r = 0; r < society.numberOfRows(); r++)
			for (int c = 0; c < society.numberOfColumns(); c++)
				assertFalse(society.cellAt(r, c));
	}

	@Test
	public void testGrowCellAtAndCellAt() {
		GameOfLife society = new GameOfLife(4, 4);
		society.growCellAt(1, 1);
		society.growCellAt(2, 2);
		society.growCellAt(3, 3);
		assertTrue(society.cellAt(1, 1));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(3, 3));
	}

	@Test
	public void testNeighborsWrapping() {
		GameOfLife society = new GameOfLife(10, 16);
		// ... many more assertions expected
		society.growCellAt(3, 3);
		society.growCellAt(3, 4);
		society.growCellAt(3, 5);
		society.growCellAt(0, 0);
		society.growCellAt(0, 1);
		society.growCellAt(0, 15);
		society.growCellAt(1, 0);
		society.growCellAt(1, 1);
		society.growCellAt(1, 15);
		society.growCellAt(9, 0);
		society.growCellAt(9, 1);
		society.growCellAt(9, 15);
		assertEquals(2, society.neighborCount(2, 1));
		assertEquals(2, society.neighborCount(2, 2));
		assertEquals(2, society.neighborCount(2, 3));
		assertEquals(3, society.neighborCount(2, 4));
		assertEquals(8, society.neighborCount(0, 0));
		assertEquals(5, society.neighborCount(0, 1));
		assertEquals(5, society.neighborCount(1, 0));
		assertEquals(3, society.neighborCount(2, 0));
		System.out.println(society.toString());
	}

	@Test
	public void testUpdate() {
		GameOfLife society = new GameOfLife(10, 16);
		society.growCellAt(3, 3);
		society.growCellAt(3, 4);
		society.growCellAt(3, 5);
		society.growCellAt(0, 0);
		society.growCellAt(0, 1);
		society.growCellAt(0, 15);
		society.growCellAt(1, 0);
		society.growCellAt(1, 1);
		society.growCellAt(1, 15);
		society.growCellAt(9, 0);
		society.growCellAt(9, 1);
		society.growCellAt(9, 15);
		society.growCellAt(3, 8);
		society.growCellAt(0, 2);
		society.growCellAt(1, 2);
		society.growCellAt(1, 4);
		society.growCellAt(2, 2);
		society.growCellAt(2, 3);
		society.growCellAt(2, 4);
		society.update();
		System.out.println(society.toString());
	}

	// ... Add many more @Test methods with many, many assertions here
}