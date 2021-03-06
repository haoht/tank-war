package v3_0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TreeMap;
import java.util.Vector;

/**
 * 2.0
 * 1.画出坦克
 * 2.我的坦克可以上下左右
 */
public class TankWar2 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new TankWar2();
    }

    public TankWar2() throws HeadlessException {
        mp = new MyPanel();
        this.add(mp);
        // 注册监听
        this.addKeyListener(mp);
        // 启动mp线程
        Thread t = new Thread(mp);
        t.start();
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

/**
 * 我的面板
 */
class MyPanel extends JPanel implements KeyListener, Runnable {
    // 定义一个我的坦克
    MyTank myTank = null;

    // 定义多个敌人坦克
    Vector<EnemyTank> enemyTank = new Vector<EnemyTank>();
    // 敌人个数
    int enSize = 3;

    public MyPanel() {
        // 初始化我的坦克
        myTank = new MyTank(100, 100);
        // 初始化敌人坦克
        for (int i = 0; i < enSize; i++) {
            EnemyTank et = new EnemyTank((i + 1) * 50, 0);
            et.setDirect(2);
            et.setColor(0);
            enemyTank.add(et);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 400, 300);
        // 画出我的坦克
        this.drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), 1);
        // 画出我的子弹
        if (this.myTank.shots != null && this.myTank.shots.isLive == true) {
            g.draw3DRect(this.myTank.shots.getX(), this.myTank.shots.getY(), 1, 1, false);
        }
        // 画出敌人坦克
        for (int i = 0; i < enemyTank.size(); i++) {
            this.drawTank(enemyTank.get(i).getX(), enemyTank.get(i).getY(), g, enemyTank.get(i).getDirect(), 0);
        }
    }

    @Override
    public void run() {
        // 每隔100毫秒重绘
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
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
            // 向右
            case 1:
                // 1、画出上边矩形
                g.fill3DRect(x - 5, y, 30, 5, false);
                // 1.画出下边矩形
                g.fill3DRect(x - 5, y + 15, 30, 5, false);
                // 3.画出中间矩形
                g.fill3DRect(x, y + 5, 20, 10, false);
                // 4.画出圆形
                g.fillOval(x + 5, y + 5, 10, 10);
                // 5.画出线
                g.drawLine(x + 10, y + 10, x + 25, y + 10);
                break;
            // 向下
            case 2:
                // 画出坦克
                g.fill3DRect(x, y, 5, 30, false);
                // 1.画出右边矩形
                g.fill3DRect(x + 15, y, 5, 30, false);
                // 3.画出中间矩形
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                // 4.画出圆形
                g.fillOval(x + 5, y + 10, 10, 10);
                // 5.画出线
                g.drawLine(x + 10, y + 15, x + 10, y + 30);
                break;
            // 向左
            case 3:
                // 画出坦克
                // 1、画出上边矩形
                g.fill3DRect(x - 5, y, 30, 5, false);
                // 1.画出下边矩形
                g.fill3DRect(x - 5, y + 15, 30, 5, false);
                // 3.画出中间矩形
                g.fill3DRect(x, y + 5, 20, 10, false);
                // 4.画出圆形
                g.fillOval(x + 5, y + 5, 10, 10);
                // 5.画出线
                g.drawLine(x + 10, y + 10, x - 5, y + 10);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override // 按下a向左，s向下，w向上，d向右
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            // 设置坦克方向 默认向上
            this.myTank.setDirect(0);
            this.myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // 向左
            this.myTank.setDirect(3);
            this.myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // 向右
            this.myTank.setDirect(1);
            this.myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            // 向下
            this.myTank.setDirect(2);
            this.myTank.moveDown();
        }

        if (e.getKeyCode() == KeyEvent.VK_X) {
            // 判断是否按下发火
            this.myTank.shotEnemy();
        }
        // 重新绘制panel
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
