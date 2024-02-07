package mg.zotoavina.core;

import java.awt.*;
import java.util.List;
import java.util.Random;

public final class FoodGenerator {

    private static final List<Color> colors;
    private static final Random random;

    static {
        colors = List.of(Color.BLACK, Color.MAGENTA, Color.GREEN, Color.YELLOW,
                Color.PINK, Color.DARK_GRAY,
                Color.BLUE, Color.red, Color.orange, Color.CYAN);
        random = new Random();
    }

    private FoodGenerator() {
    }

    public static Food generateFood(int minX, int minY, int maxX, int maxY, int bound) {

        int x = random.nextInt(maxX - minX);
        int y = random.nextInt(maxY - minY);
        int colorIndex = random.nextInt(colors.size());

        return new Food((x / bound) * bound, (y / bound) * bound, colors.get(colorIndex), Shape.RECT);
    }
}
