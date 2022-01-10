public class Person {

    final String name;

    public Person(String name) {
        if (name==null) {
            throw new NullPointerException("Name cannot be null!");
        }
        this.name = name;
    }
}