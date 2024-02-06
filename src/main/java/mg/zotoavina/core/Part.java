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
     * @param color
     * @param shape
     * @return
     */
    public static Part buildPart(Color color, Shape shape, Point position) {
        Objects.requireNonNull(color, "The part color should not be null for a snake part");
        Objects.requireNonNull(shape, "The shape should not be null for a snake part");
        Objects.requireNonNull(position, "the position for the snake part should not be null");
        return new Part(color, shape, position);
    }

    /**
     * Method for moving a part
     *
     * @param direction the direction of the move
     * @param bound
     */
    public void move(Direction direction, int bound) {
        if (Objects.isNull(direction)) return;

        bound *= direction.getCoefficient();

        if (direction.equals(UP) || direction.equals(DOWN)) {
            position.setLocation(position.x, position.y + bound);
        }

        if (direction.equals(LEFT) || direction.equals(RIGHT)) {
            position.setLocation(position.x + bound, position.y);
        }
    }

    /**
     * this method is used for a part to take the position of it's previous
     * @param part
     */
    public void moveAccordingToPreviousPart(Part part) {
        position.setLocation(part.getX(), part.getY());
    }

    public boolean isInCollision(Part part){
        return getY() == part.getY() && getX() == part.getX();
    }

}
