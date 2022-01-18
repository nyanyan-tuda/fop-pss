public static void addCat(List<? super BlackMaineCoonCat> cats,
						  BlackMaineCoonCat cat) {
	cats.add(cat); // Pass or error?
	cats.add(new MaineCoonCat()); // Pass or error?
	cats.add(new Cat()); // Pass or error?
	cats.add(new Animal()); // Pass or error?
	cats.add(new Object()); // Pass or error?
}