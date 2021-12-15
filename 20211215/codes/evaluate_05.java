private static ReturnData evaluateRecursively(char[] array, int startIndex) {
    char token = array[i];
    if (Character.isDigit(token)) {
        return new ReturnData(
            Character.getNumericValue(token), startIndex + 1);
    }
    ReturnData leftOperand = evaluateRecursively(array, startIndex + 1);
    ReturnData rightOperand = evaluateRecursively(array,
        leftOperand.nextIndex);
    return new ReturnData(
        leftOperand.result - rightOperand.result,
        rightOperand.nextIndex);
}
