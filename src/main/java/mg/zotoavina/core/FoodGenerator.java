package mg.zotoavina.core;

import java.awt.*;
import java.util.List;

public final class FoodGenerator {

    private static final List<Color> colors;

    static {
        colors = List.of(Color.BLACK, Color.GRAY,
                Color.LIGHT_GRAY, Color.BLUE, Color.red, Color.orange, Color.CYAN);
    }

    private FoodGenerator() {
    }

    public static Food generateFood(int minX, int minY, int maxX, int maxY, int bound) {
        int x = (int) (Math.random() * maxX + minX) - bound;
        int y = (int) (Math.random() * maxY + minY) - bound;

        int colorIndex = (int) (Math.random() * colors.size());

        return new Food((x / bound) * bound, (y / bound) * bound, colors.get(colorIndex), Shape.RECT);
    }
}
