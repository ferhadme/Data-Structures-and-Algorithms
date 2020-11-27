package com.ferhad;

import java.util.ArrayList;

/**
 * @author Ferhad Mehdizade
 */

public class Backtracking {

    /**
     * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each
     * other(vertically, horizontally, diagonally)
     * @param perm is all permutations for solution of N Queens problem, and should be empty ArrayList, so we can put
     * coordinates of queens in to this array.
     * @param numOfQueens is number of queens that we want to place on the N*N chessboard
     */
    public void nQueens(ArrayList<Integer> perm, int numOfQueens) {
        if (perm.size() == numOfQueens) { // when length of perm array is equal to n, print solution and stop execution
            System.out.println(perm.toString());
            System.exit(0);
        }

        for (int k = 0; k < numOfQueens; k++) {
            if (!perm.contains(k)) { // condition for checking vertical and horizontal line
                perm.add(k);
                if (checkQueensInDiagonal(perm)) {
                    nQueens(perm, numOfQueens); // if condition is true, this means k not conflict diagonally.
                }
                perm.remove(perm.size() - 1); // backtracking
            }
        }
    }

    /**
     * Function for checking diagonal
     * @param perm permutation
     * @return true if two queens don't attack each other diagonally, otherwise false
     */
    private boolean checkQueensInDiagonal(ArrayList<Integer> perm) {
        int length = perm.size() - 1;
        for (int i = 0; i < length; i++) {
            if (length - i == Math.abs(perm.get(length) - perm.get(i))) {
                return false;
            }
        }
        return true;
    }

}
