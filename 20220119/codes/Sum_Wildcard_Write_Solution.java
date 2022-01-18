public static double sum(List<? extends Number> numbers) {
	...
	Number number = 1; Integer integer = 2; Double d = 3.4;
	numbers.add(number); // Error
	numbers.add(integer); // Error
	numbers.add(d); // Error
	numbers.add(null); // Pass
	return sum;
}