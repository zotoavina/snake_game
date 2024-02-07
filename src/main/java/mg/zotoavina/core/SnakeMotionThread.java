package mg.zotoavina.core;

import mg.zotoavina.ui.SnakeFrame;
import mg.zotoavina.ui.SnakePanel;

public class SnakeMotionThread extends Thread {

    SnakeFrame snakeFrame;

    public SnakeMotionThread(SnakeFrame snakeFrame) {
        this.snakeFrame = snakeFrame;
    }

    @Override
    public void run() {
        Snake snake = snakeFrame.getSnake();
        SnakePanel snakePanel = snakeFrame.getSnakePanel();
        while (!snakeFrame.stopGame()) {
            try {
                if (snake.eatFood(snakeFrame.getFood(), 10)) {
                    snakeFrame.addFood();
                }

                snake.move(10);
                snakeFrame.checkGame();

                Thread.sleep(100);
                snakePanel.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
