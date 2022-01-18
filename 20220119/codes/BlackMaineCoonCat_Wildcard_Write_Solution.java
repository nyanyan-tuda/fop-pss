public static void addCat(List<? super BlackMaineCoonCat> cats,
						  BlackMaineCoonCat cat) {
	cats.add(cat); // Pass
	cats.add(new MaineCoonCat()); // Error
	cats.add(new Cat()); // Error
	cats.add(new Animal()); // Error
	cats.add(new Object()); // Error
}