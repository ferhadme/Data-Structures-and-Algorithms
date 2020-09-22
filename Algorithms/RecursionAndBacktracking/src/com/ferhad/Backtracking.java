package com.ferhad;

import java.util.ArrayList;

/**
 * Backtracking is an improvement of the brute force approach. It systematically searches for a
 * solution to a problem among all available options. In backtracking, we start with one possible
 * option out of many available options and try to solve the problem if we are able to solve the
 * problem with the selected move then we will print the solution else we will backtrack and select
 * some other option and try to solve it. If none if the options work out we will claim that there is no
 * solution for the problem.
 */

public class Backtracking {

    /* The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each
     * other(vertically, horizontally, diagonally)
     * @param perm is all permutations for solution of N Queens problem.
     * @param numOfQueens is number of queens that we want to place on the N*N chessboard
     * @param perm should be empty ArrayList, so we can put coordinates of queens in to this array.
     * For Python code of this puzzle refer to my another Repository for Puzzles:
     * (https://github.com/ferhad2207/Puzzles/blob/master/NQueens/NQueens(Backtracking).py)
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
    // Function for checking diagonal
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
