package test;

import static org.junit.jupiter.api.Assertions.*;
import model.Position;

import org.junit.jupiter.api.Test;

class PositionTest {

	@Test
	void positionTest() {
		double posOne = 0;
		double posTwo = 10;
		double posThree = -40;
		Position position = new Position(posOne, posOne);
		Position positionTwo = new Position(posTwo, posTwo);
		Position positionThree = new Position(posThree, posThree);
		
		assertEquals(posOne, position.getX());
		assertEquals(posOne, position.getY());
		
		assertEquals(posTwo, positionTwo.getX());
		assertEquals(posTwo, positionTwo.getY());
		
		assertEquals(posThree, positionThree.getX());
		assertEquals(posThree, positionThree.getY());
	}
}
