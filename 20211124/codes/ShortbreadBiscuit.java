public class ShortbreadBiscuit implements Cookie {

  @Override
  public Recipe getRecipe() {
    Ingredient[] ingredients = {
      new Ingredient("Unsalted butter", 10, "tbsp"),
      new Ingredient("Confectioners' sugar", 0.5, "cup"),
      new Ingredient("Pure vanilla extract", 0.5, "tbsp"),
      new Ingredient("All-purpose flour 180g", 1.5, "cups"),
      new Ingredient("KKosher salt", 0.5, "tbsp")
    };
    return new Recipe(ingredients);
  }
}