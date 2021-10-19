package environmentTesting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayArea extends JPanel implements ActionListener,KeyListener {
    private final int DELAY = 25;
    private static final long serialVersionUID = 490905409104883233L;
    private Timer timer;
    private Player player;
    private static Dimension dimensions;

    public PlayArea() {
        dimensions = new Dimension(512,512);
        setPreferredSize(dimensions);
        setBackground(new Color(223, 135, 241));
        player = new Player();
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public static double[] getDimensions() {
        return new double[]{dimensions.getWidth(), dimensions.getHeight()};
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.tick();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g,this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ;
    }
}