class Car {

    String name;
    double distance;

    Car(String name) {
        this.name = name;
        distance = 0;
    }

    void drive(double distance) {
        this.distance += distance;
    }
}
