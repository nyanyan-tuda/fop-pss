private static ReturnData evaluateRecursively(char[] array, int startIndex) {
    char token = array[i];
    if (Character.isDigit(token)) {
        return new ReturnData(
            Character.getNumericValue(token),
            startIndex + 1
        );
    }
    // TODO
}
