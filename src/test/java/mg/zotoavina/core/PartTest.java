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
                () -> Part.buildPart(null, Shape.ROUND, new Point(0,0)));

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

}