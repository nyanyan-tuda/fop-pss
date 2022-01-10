public static int evaluate(char[]array){
    ReturnData data=evaluateRecursively(array,0);
    // Alternatively: return evaluateRecursively(array, 0).result;
    return data.result;
    }
