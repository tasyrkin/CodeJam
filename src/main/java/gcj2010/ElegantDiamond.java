package gcj2010;

import java.util.Scanner;

/**
 * Unsuccessful attempt to solve the Round2 2010 "Elegant Diamond"
 */
public class ElegantDiamond {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int[] kElementsAmount = findKElementsAmount(55);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while(caseNumber++ < T) {
            final int K = scanner.nextInt();

            int maxExpansion = 0;

            for(int i = 1; i <= 2*K-1; i++){
                int numElements = i <= K ? i : 2*K-i;
                int[]elements = new int[numElements];
                for(int j = 0; j < numElements; j++){
                    elements[j] = scanner.nextInt();
                }
                final int currExpansion = findMinExpansion(elements);
                if(currExpansion > maxExpansion)maxExpansion = currExpansion;
            }

            int cost = kElementsAmount[K+maxExpansion] - kElementsAmount[K];

            System.out.println(String.format("Case #%d: %d", caseNumber, cost));
        }

    }

    static int findMinExpansion(int[] elements){
        return Math.min(findMinExpansionAppendLeft(elements), findMinExpansionAppendRight(elements));
    }

    private static int findMinExpansionAppendLeft(int[] elements) {
        int[]reverse = new int[elements.length];
        for(int i = 0; i < elements.length; i++){
            reverse[i] = elements[elements.length-1-i];
        }
        return findMinExpansionAppendRight(reverse);
    }
    private static int findMinExpansionAppendRight(int[] elements) {
        int[] symmetricAttemptArray = new int[elements.length + elements.length - 1];

        for(int i = 0; i < elements.length; i++){
            symmetricAttemptArray[i] = elements[i];
        }

        for(int expand = 0; expand < elements.length - 1; expand++){
            for(int i = 0; i < expand; i++){
                symmetricAttemptArray[elements.length + expand - i - 1] = elements[i];
            }
            if(isSymmetric(symmetricAttemptArray, elements.length + expand)) {
                return expand;
            }
        }

        return elements.length - 1;
    }

    private static boolean isSymmetric(int[] symmetricAttemptArray, int length) {
        for(int i = 0; i < length / 2; i++){
            if(symmetricAttemptArray[i] != symmetricAttemptArray[length-i-1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] findKElementsAmount(int upToK) {

        int[]elementsAmount = new int[upToK+1];
        elementsAmount[0] = 0;
        elementsAmount[1] = 1;
        for(int i = 2; i <= upToK; i++){
            elementsAmount[i] = 2 + (2*(i-1) - 1) + elementsAmount[i-1];
        }

        return elementsAmount;
    }
}
