if (n < 0 || n % 2==1) {
  throw new AssertionError("Bad n!");
}
// Short form
assert  n>=0 && n % 2 == 0:"Bad n!";