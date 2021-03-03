package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Addition of bit strings
 */
public class Addition {

    /**
     *
     * @param bitString1 first bit string
     * @param bitString2 second bit string
     * @return sum of 2 bits in the string form
     */
    public static String add(String bitString1, String bitString2) {
        bitString1 = bitStringFilter(bitString1);
        bitString2 = bitStringFilter(bitString2);
        StringBuilder sumSequence = new StringBuilder();
        String minBitSequence = bitString1.length() <= bitString2.length() ? bitString1 : bitString2;
        String maxBitSequence = bitString1.length() > bitString2.length() ? bitString1 : bitString2;
        int carry = 0;
        int maxBitSeqIndex = maxBitSequence.length() - 1;
        for (int i = minBitSequence.length() - 1; i >= 0; i--, maxBitSeqIndex--) {
            int bitSum = addBits(Character.getNumericValue(minBitSequence.charAt(i)),
                    Character.getNumericValue(maxBitSequence.charAt(maxBitSeqIndex)), carry);
            sumSequence.append(bitSum % 10);
            carry = bitSum / 10;
        }
        while (maxBitSeqIndex >= 0) {
            int bitSum = addBits(Character.getNumericValue(maxBitSequence.charAt(maxBitSeqIndex)), carry, 0);
            sumSequence.append(bitSum % 10);
            carry = bitSum / 10;
            maxBitSeqIndex--;
        }
        sumSequence.append(carry);
        return bitStringFilter(sumSequence.reverse().toString());
    }

    /**
     * Adds 2 bits and carry
     * @param bit1 first bit
     * @param bit2 second bit
     * @param carry carry
     * @return sum of bits and carry
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
