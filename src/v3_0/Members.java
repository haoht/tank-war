package v3_0;

/**
 * 坦克类
 */
class Tank {
    // 横坐标
    int x = 0;
    // 纵坐标
    int y = 0;
    // 坦克方向 0上 1右 2下 3左
    int direct = 0;
    // 设置坦克速度
    int speed = 1;
    int color;

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

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

/**
 * 敌人的坦克
 */
class EnemyTank extends Tank {
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}

/**
 * 我的坦克
 */
class MyTank extends Tank {

    public MyTank(int x, int y) {
        super(x, y);
    }

    // 坦克向上移动
    public void moveUp() {
        this.y -= this.speed;
    }

    // 坦克向右移动
    public void moveRight() {
        this.x += this.speed;
    }

    // 坦克向左移动
    public void moveLeft() {
        this.x -= this.speed;
    }

    // 坦克向下移动
    public void moveDown() {
        this.y += this.speed;
    }

}
