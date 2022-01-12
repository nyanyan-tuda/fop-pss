int[] a = {1, 2, 3, 4, 5};
try {
	System.out.println(a[6]);
	for (int n : a) {
		System.out.println(factorial(n));
	}
} catch (IndexOutOfBoundsException | NullPointerException e) {
	System.err.println("Invalid task");
} catch (IllegalArgumentException e) {
	throw e;
}
