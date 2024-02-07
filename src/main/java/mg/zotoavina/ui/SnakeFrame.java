package mg.zotoavina.ui;

import mg.zotoavina.core.Food;
import mg.zotoavina.core.FoodGenerator;
import mg.zotoavina.core.Snake;
import mg.zotoavina.core.SnakeMotionThread;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static mg.zotoavina.config.FrameConfig.*;

public class SnakeFrame extends JFrame {

    private final SnakePanel snakePanel;

    private final transient Snake snake;

    private transient Food food;
    private final AtomicBoolean pause = new AtomicBoolean(false);

    private final AtomicBoolean gameOver = new AtomicBoolean(false);

    public SnakeFrame() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(true);
        setTitle(FRAME_TITLE);
        setLayout(null);

        this.food = FoodGenerator.generateFood(0, 0, SNAKE_PANEL_WIDTH - SNAKE_PANEL_MARGIN
                , FRAME_HEIGHT - SNAKE_PANEL_MARGIN, 10);

        this.snake = Snake.createSnake(100, 100, Color.BLACK);

        this.snakePanel = new SnakePanel(this);
        snakePanel.setBounds(0, 0, SNAKE_PANEL_WIDTH, FRAME_HEIGHT);

        new SnakeGameListener(this);

        setVisible(true);

        SnakeMotionThread motionThread = new SnakeMotionThread(this);
        motionThread.start();

    }

    public SnakePanel getSnakePanel() {
        return snakePanel;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public void pause() {
        pause.set(!pause.get());
    }

    public boolean getPause() {
        return pause.get();
    }

    public void addFood() {
        this.food = FoodGenerator.generateFood(0, 0, SNAKE_PANEL_WIDTH - SNAKE_PANEL_MARGIN
                , FRAME_HEIGHT - SNAKE_PANEL_MARGIN, 10);
    }

    public void gameOver() {
        gameOver.set(true);
    }

    public void checkGame() {
        gameOver.set(snake.isInCollision());
    }

    public boolean stopGame() {
        return gameOver.get() || pause.get();
    }
}
