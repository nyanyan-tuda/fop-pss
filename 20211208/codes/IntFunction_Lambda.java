IntFunction fct;

fct = (a, b) -> a + b;
fct = (a, b) -> return a + b;
fct = (a, b) -> {
  return a + b;
}:

fct.apply(5, 6); // Returns 11

fct = (a, b) -> a * 3 - b;

fct.apply(5, 6); // Returns 9
