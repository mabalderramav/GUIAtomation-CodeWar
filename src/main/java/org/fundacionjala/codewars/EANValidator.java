package org.fundacionjala.codewars;

/**
 * Validate code EAN
 */
public class EANValidator {

    public static boolean validate(String value) {
        boolean isCorrect;
        int lastValue = Character.getNumericValue(value.charAt(value.length() - 1));
        int sum = calculateSum(value);
        isCorrect = calculateResult(lastValue, sum);
        return isCorrect;
    }

    private static int calculateSum(String value) {
        final int mod = 2;
        int sum = 0;
        int total;
        for (int index = 0; index < value.length() - 1; index++) {
            int number = Character.getNumericValue(value.charAt(index));
            boolean isPair = (((index + 1) % mod) == 0);
            total = calculateNumber(number, isPair);
            sum += total;
        }
        return sum;
    }

    private static int calculateNumber(int number, boolean isPair) {
        return isPair ? number * 3 : number;
    }

    private static boolean calculateResult(int lastValue, int sum) {
        final int mod = 10;
        boolean isCorrect;
        if ((sum % mod) == 0 && lastValue == 0) {
            isCorrect = true;
        } else {
            int checksum = 10 - (sum % mod);
            isCorrect = lastValue == checksum;
        }
        return isCorrect;
    }
}
