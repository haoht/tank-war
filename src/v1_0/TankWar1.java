package v1_0;

import javax.swing.*;
import java.awt.*;

/**
 * 1.0
 * 1.画出坦克
 */
public class TankWar1 extends JFrame {
    public static void main(String[] args) {

    }

    public TankWar1() throws HeadlessException {
    }
}

/**
 * 我的面板
 */
class MyPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}

/**
 * 坦克类
 */
class Tank {
    // 横坐标
    int x = 0;
    // 纵坐标
    int y = 0;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 我的坦克
 */
class MyTank extends Tank {

    public MyTank(int x, int y) {
        super(x, y);
    }
}