package mg.zotoavina.core;

import java.awt.*;

public class Food {
    private final Point position;
    private final Color color;
    private final Shape shape;

    public Food(int x, int y, Color color, Shape shape) {
        position = new Point(x, y);
        this.color = color;
        this.shape = shape;
    }

    public Part convertToPart() {
        Point point = new Point(position.x, position.y);
        return Part.buildPart(color, shape, point);
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

    public Color getColor() {
        return color;
    }
}
