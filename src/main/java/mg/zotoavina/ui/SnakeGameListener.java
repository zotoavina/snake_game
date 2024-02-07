package mg.zotoavina.ui;

import mg.zotoavina.core.Direction;
import mg.zotoavina.core.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static mg.zotoavina.config.KeyCodeConst.*;

public class SnakeGameListener implements KeyListener {

    private final SnakeFrame snakeFrame;

    public SnakeGameListener(SnakeFrame snakeFrame) {
        this.snakeFrame = snakeFrame;
        snakeFrame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        Snake snake = snakeFrame.getSnake();
        if(keyCode == KEY_UP_CODE) snake.changeDirection(Direction.UP);
        if(keyCode == KEY_DOWN_CODE) snake.changeDirection(Direction.DOWN);
        if(keyCode == KEY_RIGHT_CODE) snake.changeDirection(Direction.RIGHT);
        if(keyCode == KEY_LEFT_CODE) snake.changeDirection(Direction.LEFT);
        if(keyCode == KEY_N_CODE) snakeFrame.reinitialize();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
