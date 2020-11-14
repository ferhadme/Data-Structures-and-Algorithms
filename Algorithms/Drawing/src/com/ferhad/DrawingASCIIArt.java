package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Drawing ASCII Art
 *
 * For example;
 * for size = 4
 *
            +--------+
            |   /\   |
            |  /--\  |
            | /====\ |
            |<------>|
            | \====/ |
            |  \--/  |
            |   \/   |
            +--------+

 * I'm sure this looks like more beautiful in terminal :D
 */
public class DrawingASCIIArt {
    /**
     * Main method for starting drawing
     * @param size size of ASCII Art pattern
     */
    public void draw(int size) {
        int k = size - 1; // initial space
        int charSize = 0; // initial characterSize
        int incrementerForK = -1;
        int incrementerForCharSize = 2;
        boolean slashPattern = true; // indicates /\, in false case, indicates \/
        for (int i = 0; i < size * 2 + 1; i++) {
            if (i == 0 || i == size * 2) {
                drawFirstAndLastLine(size * 2 + 2);
            }

            else if (i == size) { // middle
                drawMiddle(size * 2 + 2, i % 2 == 1);
                incrementerForK = 1; // to down of the middle, spaces are incremented
                k = 1;
                charSize = size * 2 - 2;
                incrementerForCharSize = -2;
                charSize += incrementerForCharSize;
                slashPattern = false;
            }

            else {
                System.out.print("|");
                drawLine(i % 2 == 1, k, charSize, slashPattern);
                System.out.print("|");
                charSize += incrementerForCharSize;
                k += incrementerForK;
            }

            System.out.println();
        }
    }

    /**
     * Draws the first and last line of pattern
     * @param size
     */
    private void drawFirstAndLastLine(int size) {
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1)
                System.out.print("+");
            else
                System.out.print("-");
        }
    }

    /**
     * Draws middle line of pattern
     * @param size
     */
    private void drawMiddle(int size, boolean odd) {
        char character = odd ? '=' : '-';
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1)
                System.out.print("|");
            else if (i == 1)
                System.out.print("<");
            else if (i == size - 2)
                System.out.print(">");
            else
                System.out.print(character);
        }
    }

    /**
     * Draws any line of pattern except first, middle and last lines
     * @param odd defines drown column is odd or even. True if odd, otherwise(in false case even)
     * @param spaces defines printed number of spaces for each specific line
     * @param numberOfChars defines printed number of characters('-', '=') for each specific line
     * @param slashPattern defines drown line is above of middle, or not
     *                     if above '/\' pattern is implemented, otherwise(below) '\/' is implemented
     */
    private void drawLine(boolean odd, int spaces, int numberOfChars, boolean slashPattern) {
        char character = odd ? '=' : '-';

        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }

        if (slashPattern)
            System.out.print("/");
        else
            System.out.print("\\");

        for (int i = 0; i < numberOfChars; i++) {
            System.out.print(character);
        }

        if (slashPattern)
            System.out.print("\\");
        else
            System.out.print("/");

        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
    }
}
