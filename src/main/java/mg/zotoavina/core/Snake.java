package mg.zotoavina.core;

import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;

public class Snake {
    private Direction currentDirection;
    private final LinkedList<Part> body = new LinkedList<>();

    private Snake() {

    }

    public static Snake createSnake(int xPos, int yPos, Color color) {
        Snake snake = new Snake();
        snake.body.offer(Part.buildPart(color, Shape.ROUND, new Point(xPos, yPos)));
        return snake;
    }

    public static Snake createSnake(int xPos, int yPos, Color color, Direction direction) {
        Snake snake = createSnake(xPos, yPos, color);
        snake.changeDirection(direction);
        return snake;
    }


    public Direction getCurrentDirection() {
        return currentDirection;
    }


    /**
     * get the size of the snake
     *
     * @return int
     */
    public int getSize() {
        return body.size();
    }

    private void addAsPart(Part part) {
        if (Objects.isNull(part)) return;
        body.addLast(part);
    }

    /**
     * method for moving the snake
     *
     * @param bound the bound for the move
     */
    public void move(int bound) {
        Part head = body.get(0);
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).moveAccordingToPreviousPart(body.get(i - 1));
        }
        head.move(currentDirection, bound);
    }


    /**
     * method for eating food and convert it to snake's part
     *
     * @param food the food to be eaten by the snake
     * @return boolean
     */
    public boolean eatFood(Food food, int bound) {
        Part head = body.get(0);
        Point nextLocation = head.locationAfterMove(currentDirection, bound);
        Part part = food.convertToPart();
        if (part.checkLocation(nextLocation.x, nextLocation.y)) {
            addAsPart(part);
            return true;
        }
        return false;
    }

    public LinkedList<Part> getSnakeCorpse() {
        return new LinkedList<>(body);
    }

    /**
     * change the direction of the snake
     *
     * @param direction the new direction to take
     */
    public void changeDirection(Direction direction) {
        if (Objects.isNull(currentDirection)) {
            currentDirection = direction;
            return;
        }

        if (currentDirection.opposed(direction)) return;

        this.currentDirection = direction;
    }


    /**
     * Check whether the head of the snake is in collision with its body
     *
     * @return boolean
     */
    public boolean isInCollision() {
        Part head = body.get(0);
        return body.stream()
                .skip(1)
                .anyMatch(part -> part.checkLocation(head.getX(), head.getY()));
    }

    /**
     * used to check if the snake's head position is out of accepted range
     * @param minX min range for x
     * @param minY min range for y
     * @param maxX max range for x
     * @param maxY max range for y
     * @return boolean
     */
    public boolean isOutOfRange(int minX, int minY, int maxX, int maxY) {
        Part head = body.get(0);
        int xHead = head.getX();
        int yHead = head.getY();
        return xHead < minX || xHead > maxX || yHead < minY || yHead > maxY;
    }

    /**
     * Reinitialize the snake state
     */
    public void reinitialize(int xPos, int yPos){
        currentDirection = null;
        Part head = body.get(0);
        head.getPosition().x = xPos;
        head.getPosition().y = yPos;
        body.clear();
        body.offer(head);
    }

}

