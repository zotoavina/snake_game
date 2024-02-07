package mg.zotoavina.ui;

import mg.zotoavina.core.Direction;
import mg.zotoavina.core.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        if(keyCode == 38) snake.changeDirection(Direction.UP);
        if(keyCode == 40) snake.changeDirection(Direction.DOWN);
        if(keyCode == 39) snake.changeDirection(Direction.RIGHT);
        if(keyCode == 37) snake.changeDirection(Direction.LEFT);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
