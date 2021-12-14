public class FastRobot extends Robot {

    public FastRobot(int x, int y, Direction direction, int numberOfCoins) {
        super(x, y, direction, numberOfCoins);
    }

    @Override
    public void move() {
        super.move();
        super.move();
    }
}
