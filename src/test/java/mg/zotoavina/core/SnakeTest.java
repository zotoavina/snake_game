package mg.zotoavina.core;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {


    @Test
    void createSnake() {
        // arrange
        Snake snake = Snake.createSnake(100, 100, Color.BLACK);

        // act and assert
        assertNotNull(snake);
        assertNull(snake.getCurrentDirection());
    }

    @Test
    void getSize() {
        // arrange
        Snake snake = Snake.createSnake(100, 100, Color.BLACK);

        // act and assert
        assertEquals(1, snake.getSize());
    }

    @Test
    void changeFromOneDirectionToItsOppositeIsImpossible() {
        // arrange
        Snake snake = Snake.createSnake(100, 100, Color.BLACK, Direction.UP);

        // act
        snake.changeDirection(Direction.DOWN);

        // assert
        assertEquals(Direction.UP, snake.getCurrentDirection());
    }

    @Test
    void changeDirection() {
        // arrange
        Snake snake = Snake.createSnake(100, 100, Color.BLACK, Direction.LEFT);

        // act
        snake.changeDirection(Direction.DOWN);

        // assert
        assertEquals(Direction.DOWN, snake.getCurrentDirection());
    }


}