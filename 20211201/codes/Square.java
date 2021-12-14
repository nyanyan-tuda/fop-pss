public class Square extends Rectangle {
    public Square(double length) {
        super(length, length);
    }

    @Override
    public double getCircumference() {
        return 4 * getWidth();
    }

    public double getDiagonalLength() {
        return Math.sqrt(2 * getWidth() * getWidth());
    }
}
