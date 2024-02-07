package mg.zotoavina.ui;

import javax.swing.*;
import java.awt.*;

import static mg.zotoavina.config.FrameConfig.*;
public class InfoPanel extends JPanel {

    private final SnakeFrame frame;

    public InfoPanel(SnakeFrame frame) {
        this.frame = frame;
        setBounds(SNAKE_PANEL_WIDTH, 0, FRAME_WIDTH - SNAKE_PANEL_WIDTH, FRAME_HEIGHT);
        frame.add(this);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, FRAME_WIDTH - SNAKE_PANEL_WIDTH, FRAME_HEIGHT);
        drawScore(graphics);
    }

    private void drawScore(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        int score = frame.getSnake().getSize() - 1;
        graphics.drawString("Score: " + score, 15, 30);
    }
}
