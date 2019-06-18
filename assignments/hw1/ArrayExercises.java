import java.util.Arrays;


public class ArrayExercises {
    public static final int EMPTY_SPACE = -1;
    public static int [] numbers = {1, 3, -1, 6, 8, 9, -1, 10, -1};

    public static void main(String[] args) {
        System.out.println( "original array: " + Arrays.toString( numbers ) );
        System.out.println( numbers.length );

        int [] compactedArray = new int[numbers.length]; 
        compactedArray = compactArray(numbers);

        System.out.println( "compacted array: " +  Arrays.toString( compactedArray ));
        System.out.println( compactedArray.length );

        int [] duplicatedArray = new int[compactedArray.length]; 
        duplicatedArray = duplicateArray(compactedArray);

        System.out.println( "duplicatedArray array: " +  Arrays.toString( duplicatedArray ));
        System.out.println( duplicatedArray.length );

        boolean hasFive = containsElement(compactedArray, 5);
        System.out.println( "contains 5 in compacted array: " +  hasFive);
        
        boolean hasEight = containsElement(compactedArray, 8);
        System.out.println( "contains 8 in compacted array: " +  hasEight);

        compactedArray = insertOrdered(compactedArray, 4);
        System.out.println( "compactedArray after inserting num 4: " +  Arrays.toString( compactedArray ));
        
        compactedArray = insertOrdered(compactedArray, 5);
        System.out.println( "compactedArray after inserting num 5: " +  Arrays.toString( compactedArray ));
        
        compactedArray = insertOrdered(compactedArray, 2);
        System.out.println( "compactedArray after inserting num 2: " +  Arrays.toString( compactedArray ));
        
        compactedArray = insertOrdered(compactedArray, 7);
        System.out.println( "compactedArray after inserting num 7 (ITS SUPPOSE TO DUPLICATE ARRAY DUE TO SIZE CONSTRAINS): " +  Arrays.toString( compactedArray ));
        
        
        boolean elementDeleted = deleteElementFromArray(compactedArray, 7);
        System.out.println( "deleted num 7 " + elementDeleted + " from ARRAY: " +  Arrays.toString( compactedArray ));
        
        
        boolean isPalindrome = isPalindrome("isPalindrome");
        System.out.println( "isPalindrome the word 'isPalindrome'??? " +  isPalindrome);
        
        boolean exem = isPalindrome("otto");
        System.out.println( "isPalindrome the word 'otto'??? " +  exem);

    }


    public static int[] compactArray(int [] numArray) {
        int shift = 0;

        for (int i = 0; i < numArray.length; i++) {
            if(numArray[i] == EMPTY_SPACE) {
                shift = nextValidValue(i + 1, numArray);
                if(shift != EMPTY_SPACE) {
                    numArray[i] = shift;
                } else {
                    break;
                }
            }
        }

        return numArray;

    }


    public static int[] duplicateArray(int [] originalArray) {
        int [] duplicated = new int[originalArray.length * 2];
        duplicated = initArray(duplicated);

        for (int i = 0; i < originalArray.length; i++) {
            duplicated[i] = originalArray[i];
        }

        return duplicated;

    }


    public static int nextValidValue(int idx, int[] arr) {
        int nextValue = EMPTY_SPACE;
        for(int i = idx; i < arr.length; i++) {
            if(arr[i] != EMPTY_SPACE) {
                nextValue = arr[i];
                arr[i] = EMPTY_SPACE;
                break;
            }
        }

        return nextValue;
    }


    public static int[] initArray(int [] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = EMPTY_SPACE;
        }

        return array;
    }

    // ¿cuál es la complejidad de inicializar los valores de un arreglo?
    // - el loop

    public static boolean containsElement(int[] numArray, int value) {
        boolean isInArray = false;

        for(int i = 0; i < numArray.length; i++) {
            if(numArray[i] == value) {
                isInArray = true;
                break;
            }
        }

        return isInArray;
    }
    // complejidad
    // - recorrer el arreglo
    // - identificar el elemento a través de una comparación

    public static int[] insertOrdered(int [] numArray, int value) { 
        int insertIndex = 0, shift = 0, tmp = 0;
        boolean isFulfill = true;
        int [] compactedArray = new int[numArray.length];


        compactedArray = compactArray(numArray);


        for (int i = 0; i < compactedArray.length; i++) {
            if(compactedArray[i] == EMPTY_SPACE) {
                isFulfill = false;
                break;
            }
        }

        // System.out.println("isFulfill" + isFulfill + " VALUE " + value);

        int [] finalArray = (isFulfill) ? new int[compactedArray.length * 2] : new int[compactedArray.length];
        finalArray = (isFulfill) ? duplicateArray(compactedArray) : compactedArray;
        
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
            if(tmp == EMPTY_SPACE) {
                break;
            } else {
                shift = tmp;
            }
        }

        return finalArray;
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
            if(numArray[i] == value) {
                int nextVal = nextValidValue(i + 1, numArray);
                numArray[i] = nextVal;

                for(int j = i + 1; j < numArray.length; j++) {
                    int nextUsefulValue = nextValidValue(j + 1, numArray);
                    if(nextUsefulValue != EMPTY_SPACE) {
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

        for(int i = 0; i < sentence.length() / 2; i++){
            if(reversedSentence.charAt(i) != sentence.charAt(i)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}

