int a = 5, b = 0;
try {
  int c = a / b;
  System.out.println(c);
} catch (ArithmeticException e) {
  System.err.println("Divisor cannot be zero!");
}
