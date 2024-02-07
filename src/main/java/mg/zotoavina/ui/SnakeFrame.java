package mg.zotoavina.ui;

import mg.zotoavina.config.GameConfig;
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
    private final InfoPanel infoPanel;

    private final transient Snake snake;

    private transient Food food;
    private final AtomicBoolean pause = new AtomicBoolean(false);

    private final AtomicBoolean gameOver = new AtomicBoolean(false);

    private transient SnakeMotionThread motionThread;


    public SnakeFrame() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle(FRAME_TITLE);
        setLayout(null);

        this.food = FoodGenerator.generateFood(0, 0, SNAKE_PANEL_WIDTH - SNAKE_PANEL_MARGIN
                , FRAME_HEIGHT - SNAKE_PANEL_MARGIN, GameConfig.PART_SIZE);

        this.snake = Snake.createSnake(0, 0, Color.BLACK);

        this.snakePanel = new SnakePanel(this);

        this.infoPanel = new InfoPanel(this);

        new SnakeGameListener(this);

        setVisible(true);

        motionThread = new SnakeMotionThread(this);
        motionThread.start();

    }

    public SnakePanel getSnakePanel() {
        return snakePanel;
    }

    public InfoPanel getInfoPanel() {
        return infoPanel;
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
                , FRAME_HEIGHT - SNAKE_PANEL_MARGIN, GameConfig.PART_SIZE);
    }

    public boolean isGameOver() {
        return gameOver.get();
    }

    public void checkGame() {
        gameOver.set(
                snake.isInCollision() ||
                        snake.isOutOfRange(0, 0, SNAKE_PANEL_WIDTH, FRAME_HEIGHT - SNAKE_PANEL_MARGIN)
        );
    }

    /**
     * Stop game in case of pause or gam eover
     *
     * @return
     */
    public boolean stopGame() {
        return gameOver.get() || pause.get();
    }

    /**
     * Use for game reinitialization after game over
     */
    public void reinitialize() {
        snake.reinitialize(0, 0);
        pause.set(false);
        gameOver.set(false);
        addFood();
        snakePanel.repaint();
        infoPanel.repaint();
        if(!motionThread.isAlive()){
            motionThread = new SnakeMotionThread(this);
            motionThread.start();
        }
    }
}
