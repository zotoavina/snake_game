package mg.zotoavina.core;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PartTest {

    @Test
    void buildPart() {
        // arrange, act and assert
        assertThrows(NullPointerException.class,
                () -> Part.buildPart(Color.BLACK, null, new Point(0, 0)));

        assertThrows(NullPointerException.class,
                () -> Part.buildPart(null, Shape.ROUND, new Point(0, 0)));

        assertNotNull(Part.buildPart(Color.BLACK, Shape.RECT, new Point(0, 0)));
    }

    @Test
    void getColor() {
        // arrange
        Part part = Part.buildPart(Color.BLACK, Shape.RECT, new Point(0, 0));

        // act and assert
        assertEquals(Color.BLACK, part.getColor());
    }

    @Test
    void getShape() {
        // arrange
        Part part = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(0, 0));

        // act and assert
        assertEquals(Shape.ROUND, part.getShape());
    }

    @Test
    void moveUp() {
        // arrange
        Part part = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 5));

        // act
        part.move(Direction.UP, 1);

        // assert
        assertEquals(4, part.getY());
    }

    @Test
    void testMoveDown() {
        // arrange
        Part part = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 5));

        // act
        part.move(Direction.DOWN, 2);

        // assert
        assertEquals(7, part.getY());
    }

    @Test
    void moveLeft() {
        // arrange
        Part part = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 5));

        // act
        part.move(Direction.LEFT, 1);

        // assert
        assertEquals(4, part.getX());
        assertEquals(5, part.getY());
    }

    @Test
    void moveRight() {
        // arrange
        Part part = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 5));

        // act
        part.move(Direction.RIGHT, 3);

        // assert
        assertEquals(8, part.getX());
        assertEquals(5, part.getY());
    }


    @Test
    void moveAccordingToPreviousPart() {
        // arrange
        Part part1 = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 5));
        Part part2 = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 6));

        // act
        part2.moveAccordingToPreviousPart(part1);

        // assert
        assertEquals(5, part2.getX());
        assertEquals(5, part2.getY());
    }


    @Test
    void testCollisionBetweenPart() {
        // arrange
        Part part1 = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 5));
        Part part2 = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 5));
        Part part3 = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(15, 5));


        // act and assert
        assertTrue(part1.isInCollision(part2));
        assertFalse(part3.isInCollision(part1));
    }

    @Test
    void testSwap() {
        // arrange
        Part part1 = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 5));
        Part part3 = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(15, 20));

        // act
        part1.swap(part3);

        // assert
        assertEquals(15, part1.getX());
        assertEquals(5, part3.getX());
        assertEquals(20, part1.getY());
        assertEquals(5, part3.getY());
    }

    @Test
    void checkLocation() {
        // arrange
        Part part1 = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 5));

        // act and assert
        assertTrue(part1.checkLocation(5, 5));
        assertFalse(part1.checkLocation(6, 10));
    }

    @Test
    void checkShape() {
        // arrange
        Part part1 = Part.buildPart(Color.WHITE, Shape.ROUND, new Point(5, 5));

        // act and assert
        assertEquals(Shape.ROUND, part1.getShape());
        assertNotEquals(Shape.RECT, part1.getShape());
    }
}