package mg.zotoavina.core;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodTest {


    @Test
    void createPart() {
        // arrange
        Food food = new Food(4, 10, Color.BLACK, Shape.RECT);

        // act
        Part part = food.convertToPart();

        // assert
        assertAll(
                () -> assertEquals(4, part.getX()),
                () -> assertEquals(10, part.getY()),
                () -> assertEquals(Color.BLACK, part.getColor()),
                () -> assertEquals(Shape.RECT, part.getShape())
        );
    }

}