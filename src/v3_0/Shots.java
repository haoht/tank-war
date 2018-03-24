package v3_0;

class Shots implements Runnable {
    int x;
    int y;
    int direct;
    int speed = 1;
    // 判断子弹是否还活着
    boolean isLive = true;

    public Shots(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
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

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (this.direct) {
                case 0:
                    // 向上
                    this.y -= this.speed;
                    break;
                case 1:
                    // 向右
                    this.x += this.speed;
                    break;
                case 2:
                    // 向下
                    this.y += this.speed;
                    break;
                case 3:
                    // 向左
                    this.x -= this.speed;
                    break;
            }

            // 子弹何时死亡
            // 判断子弹是否到边缘
            if (this.x < 0 || this.x > 400 || this.y < 0 || this.y > 300) {
                this.isLive = false;
                break;
            }
        }
    }
}
