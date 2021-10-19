package environmentTesting;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Player {
    private BufferedImage image;
    private Point pos;

    public Player() {
        loadImage(126,126);
        pos = new Point((int) (PlayArea.getDimensions()[0]-image.getWidth())/2,(int) (PlayArea.getDimensions()[1]-image.getHeight())/2);
    }

    private void loadImage(int width,int height) {
        try {
            BufferedImage fullSize = ImageIO.read(new File("resources/Goowah.png"));
            image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = image.createGraphics();
            graphics2D.drawImage(fullSize,0,0,width,height,null);
            graphics2D.dispose();

        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                image,
                pos.x,
                pos.y,
                observer
        );
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 87 || key == KeyEvent.VK_UP) {
            pos.translate(0, -1);
        }
        if (key == 65 || key == KeyEvent.VK_LEFT) {
            pos.translate(-1, 0);
        }
        if (key == 83 || key == KeyEvent.VK_DOWN) {
            pos.translate(0, 1);
        }
        if (key == 68 || key == KeyEvent.VK_RIGHT) {
            pos.translate(1, 0);
        }
    }

    public void tick() {
        if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= PlayArea.getDimensions()[0] - image.getWidth()) {
            pos.x = (int) PlayArea.getDimensions()[0] - image.getHeight() - 1;
        }
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= PlayArea.getDimensions()[1] - image.getHeight()) {
            pos.y = (int) PlayArea.getDimensions()[1] - image.getHeight() - 1;
        }
    }

    public Point getPos() {
        return pos;
    }
}
