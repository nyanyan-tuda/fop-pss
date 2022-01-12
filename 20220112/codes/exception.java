File file = new File("path-to-file");
try {
	BufferedReader reader = new BufferedReader(new FileReader(file));
} catch (FileNotFoundException e) {
	System.err.println("File could not be found!");
}
