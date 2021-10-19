package environmentTesting;

import javax.swing.*;

public class Testing {
    public static void initWindow() {
        JFrame window = new JFrame("2D Testing");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlayArea env = new PlayArea();
        window.add(env);
        window.addKeyListener(env);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Testing::initWindow);
    }
}
