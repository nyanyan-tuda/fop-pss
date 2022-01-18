public static double sum(List<? extends Number> numbers) {
	double sum = 0;
	for (Number number : numbers) {
		sum += number.doubleValue();
	}
	return sum;
}