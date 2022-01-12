Animal animal = new Dog();
try {
	Dog dog = (Dog) animal;
} catch (ClassCastException e) {
	// ...
}
int a = 10;
int b = 42;
try {

	int c = a / b;
} catch (ArithmeticException e) {
	// ..
}