package mg.zotoavina.core;

import java.awt.*;
import java.util.Objects;

import static mg.zotoavina.core.Direction.*;

public class Part {
    private final Color color;
    private final Shape shape;
    private final Point position;

    private Part(Color color, Shape shape, Point position) {
        this.color = color;
        this.shape = shape;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    public Point getPosition() {
        return position;
    }

    public int getX() {
        return position.x;
    }

    public int getY() {
        return position.y;
    }


    /**
     * Factory method for creation a snake part
     *
     * @param color used for drawing the snake part
     * @param shape used for drawing the snake part
     * @return Part
     */
    public static Part buildPart(Color color, Shape shape, Point position) {
        Objects.requireNonNull(color, "The part color should not be null for a snake part");
        Objects.requireNonNull(shape, "The shape should not be null for a snake part");
        Objects.requireNonNull(position, "the position for the snake part should not be null");
        return new Part(color, shape, position);
    }

    /**
     * Show the next location after moving according to the direction and bound
     *
     * @param direction the direction of the move
     * @param bound     the bound for the move
     * @return Point
     */
    public Point locationAfterMove(Direction direction, int bound) {
        if (Objects.isNull(direction)) return new Point(position.x, position.y);

        int x = position.x;
        int y = position.y;

        bound *= direction.getCoefficient();

        if (direction.equals(UP) || direction.equals(DOWN)) {
            y += bound;
        }

        if (direction.equals(LEFT) || direction.equals(RIGHT)) {
            x += bound;
        }
        return new Point(x, y);
    }

    /**
     * Method for moving a part
     *
     * @param direction the direction of the move
     * @param bound     the bound for the move
     */
    public void move(Direction direction, int bound) {
        Point newLocation = locationAfterMove(direction, bound);
        position.setLocation(newLocation.x, newLocation.y);
    }

    /**
     * this method is used for a part to take the position of it's previous
     *
     * @param part the previous of the calling part
     */
    public void moveAccordingToPreviousPart(Part part) {
        position.setLocation(part.getX(), part.getY());
    }

    /**
     * Check other the head is in collision with other part
     *
     * @param part check if two part are in collision
     * @return boolean
     */
    public boolean isInCollision(Part part) {
        return getY() == part.getY() && getX() == part.getX();
    }

    /**
     * swap two parts
     *
     * @param part the part to be swapped with the head
     */
    public void swap(Part part) {
        if (Objects.isNull(part)) return;

        int xTemp = part.getX();
        int yTemp = part.getY();

        part.getPosition().x = getX();
        part.getPosition().y = getY();

        position.move(xTemp, yTemp);
    }

    /**
     * Check if a part has the given location
     * @param x x location
     * @param y y location
     * @return boolean
     */
    public boolean checkLocation(int x, int y) {
        return x == getX() && y == getY();
    }

    /**
     * Check if the calling part has the given shape
     * @param shape the shape to be compared to the calling
     * @return boolean
     */
    public boolean checkShape(Shape shape) {
        return this.shape.equals(shape);
    }


}