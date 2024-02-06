package mg.zotoavina.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FoodGeneratorTest {

    @Test
    void generateFood() {
        // arrange and act
        Food food = FoodGenerator.generateFood(0, 0, 200, 200, 10);

        // assert
        assertNotNull(food);
        assertNotNull(food.getColor());
        assertNotNull(food.getPosition());
    }

}