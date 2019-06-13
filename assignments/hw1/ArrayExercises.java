int EMPTY_SPACE = -1;

public static void compactArray(int [] numArray) {
    int shift = 0, tmp = 0;

    for (int i = 0; i < numArray.length; i++) {
        if(numArray[i] === EMPTY_SPACE) {
            shift = nextValidValue(i + 1, numArray);
            if(shift !== EMPTY_SPACE) {
                numArray[i] = shift;
            } else {
                break;
            }
        }
    }

}


public static int[] nextValidValue(int idx, int[] arr) {
    int nextValue = EMPTY_SPACE;
    for(int i = idx; i < arr.length; i++) {
        if(arr[i] !== EMPTY_SPACE) {
            nextValue = arr[i];
            break;
        }
    }

    return nextValue;
}


public static void initArray(int [] numArray) {
    for(int i = 0; i <= numArray.length; i++) {
        numArray[i] = EMPTY_SPACE;
    }
}

// ¿cuál es la complejidad de inicializar los valores de un arreglo?
// - el loop

public static boolean containsElement(int[] numArray, int value) {
    boolean isInArray = false;

    for(int i = 0; i <= numArray.length; i++) {
        if(numArray[i] === value) {
            isInArray = true;
            break;
        }
    }

    return isInArray;
}
// complejidad
// - recorrer el arreglo
// - identificar el elemento a través de una comparación

public static void insertOrdered(int [] numArray, int value) { 
    int insertIndex = 0, shift = 0, tmp = 0;
    boolean isFulfill = true;
    int [] compactedArray = [], finalArray = [];


    compactedArray = compactArray(numArray);


    for (int i = 0; i < compactedArray.length; i++) {
        if(compactedArray[i] === EMPTY_SPACE) {
            isFulfill = false;
            break;
        }
    }

    int [] extraArray = [compactedArray.length];
    for (int i = 0; i < compactedArray.length; i++) {
        extraArray[i] = EMPTY_SPACE;
    }

    finalArray = (isFulfill) ? ArrayUtils.addAll(compactedArray, extraArray) : compactedArray;
    
    for (int i = 0; i < finalArray.length; i++) {
        if (finalArray[i] > value || finalArray[ i ] == EMPTY_SPACE) {
            insertIndex = i ; 
            break ;
        }
    }

    shift = value;
    for (int i = insertIndex; i < finalArray.length; i++) {
        tmp = finalArray[ i ]; 
        finalArray[ i ] = shift;
        if(tmp === EMPTY_SPACE) {
            break;
        } else {
            shift = tmp;
        }
    }
}

// Complejidad:
// - Compactar Array
// - Problemas anteriores más recorrido
// - Descubrir si tiene espacio y si no duplicar el tamaño del Array
// - Encontrar dónde insertar el nuevo elemento
// - recorrer los siguientes elementos

public static boolean deleteElementFromArray(int[] numArray, int value) {
    boolean foundElement = false;

    for (int i = 0; i < numArray.length; i++) {
        if(numArray[i] === value) {
            int nextVal = this.nextValidValue(i + 1, numArray);
            numArray[i] = nextVal;

            for(int j = i + 1; j < numArray.length; j++) {
                int nextUsefulValue = nextValidValue(j + 1, numArray);
                if(nextUsefulValue !== EMPTY_SPACE) {
                    numArray[j] = nextUsefulValue;
                } else {
                    break;
                }
            }

            foundElement = true;
            break;
        }
    }

    return foundElement;
}

// ¿cuál es la complejidad de eliminar un elemento dentro de un arreglo ordenado?
// - encontrar al elemento, 
// - eliminarlo
// - recorrer los valores
// - sin que hayan espacios vacíos
// - encontrando por lo tanto el siguiente valor no vacío


public static boolean isPalindrome(String sentence) {
    boolean isPalindrome = true;
    String reversedSentence = new StringBuilder(sentence).reverse().toString();

    for(int i = 0; i < sentence.length / 2; i++){
        if(reversedSentence.charAt(i) !== sentence.charAt(i)) {
            isPalindrome = false;
            break;
        }
    }

    return isPalindrome;
}

// ¿Cuál es la complejidad de verificar si una palabra es un palíndromo?
// - Verificar las posiciones y los caracteres