package main.java.leetCodeProblems.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *          1
 *         1 1
 *        1 2 1
 *       1 3 3 1
 *      1 4 6 4 1
 *
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= numRows <= 30
 *
 */
public class PascalTriangle
{

    public static void main(String[] args)
    {
        int numRow = 10;
        pascalTriangle(numRow).forEach( row -> {
            row.forEach( x -> {
                System.out.print(x);
                System.out.print(" ");
            });
            System.out.println();
        });
    }

    private static List<List<Integer>> pascalTriangle(int numRow)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);
        // First Row
        List<Integer> rowBefore;
        int init;
        int value;
        for(int idx = 1; idx < numRow; idx++) {
            row = new ArrayList<>();
            rowBefore = result.get(idx - 1);
            init = 0;
            while(init <= rowBefore.size()) {
                if(init == 0 || init == rowBefore.size()) {
                    value = 1;
                } else {
                    value = rowBefore.get(init - 1) + rowBefore.get(init);
                }
                row.add(value);
                init++;
            }
            result.add(row);
        }
        return result;
    }

}
