package mg.zotoavina.ui;

import mg.zotoavina.config.FrameConfig;
import mg.zotoavina.core.Food;
import mg.zotoavina.core.Part;
import mg.zotoavina.core.Shape;
import mg.zotoavina.core.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import static mg.zotoavina.config.FrameConfig.FRAME_HEIGHT;
import static mg.zotoavina.config.FrameConfig.SNAKE_PANEL_WIDTH;
import static mg.zotoavina.config.GameConfig.*;

public class SnakePanel extends JPanel {
    private final SnakeFrame frame;


    public SnakePanel(SnakeFrame frame) {
        super();
        this.frame = frame;
        setBounds(0, 0, SNAKE_PANEL_WIDTH, FRAME_HEIGHT);
        frame.add(this);
    }

    @Override
    public void paint(Graphics graphics) {
        clear(graphics);
        graphics.setColor(Color.black);
        drawSnake(frame.getSnake(), graphics);
        drawFood(frame.getFood(), graphics);
    }

    public static void clear(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, FrameConfig.FRAME_WIDTH, FrameConfig.FRAME_HEIGHT);
    }

    private static void drawSnackPart(Part part, Graphics graphics) {
        graphics.setColor(part.getColor());
        if (part.checkShape(Shape.RECT))
            graphics.fillRect(part.getX(), part.getY(), PART_SIZE, PART_SIZE);
        else
            graphics.drawRoundRect(part.getX(), part.getY(), PART_SIZE, PART_SIZE, 4, 4);
    }

    private static void drawHead(Part part, Graphics graphics, int bound) {
        graphics.drawRoundRect(part.getX(), part.getY(), PART_SIZE, PART_SIZE, 4, 4);
        int x = part.getX() + (bound / 2);
        int y = part.getY() + (bound / 2);
        graphics.setColor(Color.RED);
        graphics.fillRect(x, y, 2, 2);
    }

    private static void drawSnake(Snake snake, Graphics graphics) {
        LinkedList<Part> parts = snake.getSnakeCorpse();
        Part head = parts.poll();
        drawHead(head, graphics, PART_SIZE);
        parts.forEach(p -> drawSnackPart(p, graphics));
    }

    private static void drawFood(Food food, Graphics graphics) {
        graphics.setColor(food.getColor());
        graphics.fillRect(food.getX(), food.getY(), PART_SIZE, PART_SIZE);
    }


}
