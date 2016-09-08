package org.fundacionjala.codewars;

/**
 * Validate code EAN
 */
public class EANValidator {

    public static boolean validate(String value) {
        int lastValue = Character.getNumericValue(value.charAt(value.length() - 1));
        int sum = calculateSum(value);
        return calculateResult(lastValue, sum);
    }

    private static int calculateSum(String value) {
        final int mod = 2;
        int sum = 0;
        for (int index = 0; index < value.length() - 1; index++) {
            int number = Character.getNumericValue(value.charAt(index));
            boolean isPair = (index + 1) % mod == 0;
            sum += calculateNumber(number, isPair);
        }
        return sum;
    }

    private static int calculateNumber(int number, boolean isPair) {
        return isPair ? number * 3 : number;
    }

    private static boolean calculateResult(int lastValue, int sum) {
        final int mod = 10;
        final int checksum = sum % mod == 0 ? 0 : 10 - (sum % mod);
        return checksum == lastValue;
    }
}
