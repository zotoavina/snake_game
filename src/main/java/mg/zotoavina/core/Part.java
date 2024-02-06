package mg.zotoavina.core;

import java.awt.*;
import java.util.Objects;

public class Part {
    private final Color color;
    private final Shape shape;

    private Part(Color color, Shape shape){
        this.color = color;
        this.shape = shape;
    }

    /**
     * Factory method for creation a snake part
     * @param color
     * @param shape
     * @return
     */
    public static Part buildPart(Color color, Shape shape){
        Objects.requireNonNull(color, "The part color should not be null for a snake part");
        Objects.requireNonNull(shape, "The shape should not be null for a snake part");
        return new Part(color, shape);
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }
}
