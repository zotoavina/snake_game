package mg.zotoavina.core;

import mg.zotoavina.config.GameConfig;
import mg.zotoavina.ui.InfoPanel;
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
        InfoPanel infoPanel = snakeFrame.getInfoPanel();
        while (!snakeFrame.stopGame()) {
            try {
                if (snake.eatFood(snakeFrame.getFood(), GameConfig.PART_SIZE)) {
                    snakeFrame.addFood();
                }

                snake.move(GameConfig.PART_SIZE);
                snakeFrame.checkGame();

                Thread.sleep(GameConfig.SPEED);
                snakePanel.repaint();
                infoPanel.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
