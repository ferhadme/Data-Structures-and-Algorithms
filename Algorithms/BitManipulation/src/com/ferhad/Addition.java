package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Addition of bit strings
 */
public class Addition {

    /**
     * Adds 2 String of bits
     * @param bitString1 first bit string
     * @param bitString2 second bit string
     * @return sum of 2 bits in the string form
     */
    public static String add(String bitString1, String bitString2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int i = bitString1.length() - 1;
        int j = bitString2.length() - 1;
        while (i >= 0 || j >= 0) {
            int bitSum = addBits(
                    (i >= 0) ? Character.getNumericValue(bitString1.charAt(i)) : 0,
                    (j >= 0) ? Character.getNumericValue(bitString2.charAt(j)) : 0,
                    carry
            );
            sum.insert(0, bitSum % 10);
            carry = bitSum / 10;
            i--;
            j--;
        }
        sum.insert(0, carry);
        return bitStringFilter(sum.toString());
    }

    /**
     * Adds 2 bits and carry
     * @param bit1 first bit
     * @param bit2 second bit
     * @param carry carry
     * @return sum of bits and carry such as - sum = sum % 10 and carry = sum / 10
     */
    private static int addBits(int bit1, int bit2, int carry) {
        int sum = bit1 + bit2 + carry;
        if (sum < 2)
            return sum;
        if (sum == 2)
            return 10;
        else
            return 11;
    }

    /**
     * Removes all unnecessary zeros from prefix of bit string
     * @param bitString bit string
     * @return bit string that not contains zero in the prefix
     */
    private static String bitStringFilter(String bitString) {
        int index;
        for (index = 0; index < bitString.length() - 1; index++) {
            if (bitString.charAt(index) == '1')
                break;
        }
        return bitString.substring(index);
    }

}
