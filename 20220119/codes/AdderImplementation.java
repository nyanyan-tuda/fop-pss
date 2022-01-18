public class IntegerAdder implements NumberAdder {

    @Override
    public Integer add(Number a, Number b) {
        return a.intValue() + b.intValue();
    }
}

public class DoubleAdder implements NumberAdder {
    @Override
    public Number add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }
}
