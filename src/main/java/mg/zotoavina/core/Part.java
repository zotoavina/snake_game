package mg.zotoavina.core;

import java.awt.*;
import java.util.Objects;

public class Part {
    private final Color color;
    private final Shape shape;
    private final Point position;

    private Part(Color color, Shape shape, Point position) {
        this.color = color;
        this.shape = shape;
        this.position = position;
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

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    public Point getPosition() {
        return position;
    }
}
