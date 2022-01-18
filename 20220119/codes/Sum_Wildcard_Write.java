public static double sum(List<? extends Number> numbers) {
	...
	Number number = 1; Integer integer = 2;
	Double d = 3.4;
	numbers.add(number); // Pass or Error?
	numbers.add(integer); // Pass or Error?
	numbers.add(d); // Pass or Error?
	return sum;
}