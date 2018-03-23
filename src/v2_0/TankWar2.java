package v2_0;

import javax.swing.*;
import java.awt.*;

/**
 * 1.0
 * 1.画出坦克
 */
public class TankWar2 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new TankWar2();
    }

    public TankWar2() throws HeadlessException {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

/**
 * 我的面板
 */
class MyPanel extends JPanel {
    // 定义一个我的坦克
    MyTank myTank = null;

    public MyPanel() {
        myTank = new MyTank(10, 10);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 400, 300);
        this.drawTank(myTank.getX(), myTank.getY(), g, 0, 1);
    }

    // 画出坦克函数
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        // 判断坦克类型
        switch (type) {
            // 自己的坦克
            case 0:
                g.setColor(Color.CYAN);
                break;
            // 敌人的坦克
            case 1:
                g.setColor(Color.YELLOW);
                break;
        }
        // 判断方向
        switch (direct) {
            // 向上
            case 0:
                // 画出坦克
                // 1、画出左边矩形
                g.fill3DRect(x, y, 5, 30, false);
                // 1.画出右边矩形
                g.fill3DRect(x + 15, y, 5, 30, false);
                // 3.画出中间矩形
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                // 4.画出圆形
                g.fillOval(x + 5, y + 10, 10, 10);
                // 5.画出线
                g.drawLine(x + 10, y + 15, x + 10, y);
                break;

        }
    }
}

/**
 * 坦克类
 * x:横坐标
 * y:纵坐标
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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