package mg.zotoavina.ui;

import mg.zotoavina.config.FrameConfig;
import mg.zotoavina.core.Food;
import mg.zotoavina.core.Part;
import mg.zotoavina.core.Shape;
import mg.zotoavina.core.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class SnakePanel extends JPanel {
    private final SnakeFrame frame;


    public SnakePanel(SnakeFrame frame) {
        super();
        this.frame = frame;
        frame.setContentPane(this);
    }

    public void paint(Graphics graphics) {
        clear(graphics);
        graphics.setColor(Color.black);
        drawSnake(frame.getSnake(), graphics);
        drawFood(frame.getFood(), graphics);
    }

    public static void clear(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, FrameConfig.FRAME_WIDTH, FrameConfig.FRAME_HEIGHT);
    }

    private static void drawSnackPart(Part part, Graphics graphics) {
        graphics.setColor(part.getColor());
        if (part.checkShape(Shape.RECT))
            graphics.fillRect(part.getX(), part.getY(), 10, 10);
        else
            graphics.drawRoundRect(part.getX(), part.getY(), 10, 10, 4, 4);
    }

    private static void drawHead(Part part, Graphics graphics, int bound) {
        graphics.drawRoundRect(part.getX(), part.getY(), 10, 10, 4, 4);
        int x = part.getX() + (bound / 2);
        int y = part.getY() + (bound / 2);
        graphics.setColor(Color.RED);
        graphics.fillRect(x, y, 2, 2);
    }

    public static void drawSnake(Snake snake, Graphics graphics) {
        LinkedList<Part> parts = snake.getSnakeCorpse();
        Part head = parts.poll();
        drawHead(head, graphics, 10);
        parts.forEach(p -> drawSnackPart(p, graphics));
    }

    public static void drawFood(Food food, Graphics graphics) {
        graphics.setColor(food.getColor());
        graphics.fillRect(food.getX(), food.getY(), 10, 10);
    }
}
