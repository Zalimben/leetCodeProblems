package main.java.algorithm;

import java.util.Stack;

/**
 * 733. Flood Fill
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
 * of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color),
 * and so on. Replace the color of all of the aforementioned pixels with color.
 * Return the modified image after performing the flood fill.
 * <p>
 * Example 1:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected
 * by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * <p>
 * Example 2:
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 * Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 * <p>
 * Constraints:
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], color < 216
 * 0 <= sr < m
 * 0 <= sc < n
 */
public class FloodFill
{
    public static void main(String[] args)
    {
        int[][] paint = {{0, 0, 0}, {0, 0, 0}};
        int row = 0;
        int col = 0;
        int color = 0;
        int[][] paintedColor = floodFillIterative(paint, row, col, color);
        for(int[] rowPaint : paintedColor) {
            System.out.println();
            for(int i : rowPaint) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }


    public static int[][] floodFillIterative(int[][] image, int sr, int sc, int color)
    {
        int rowLen = image.length;
        int colLen = image[0].length;
        int[][] painted = new int[rowLen][colLen];
        int oldColor = image[sr][sc];

        Stack<int[]> toVisit = new Stack<>();
        toVisit.push(new int[]{sr, sc});

        while(!toVisit.isEmpty()) {
            int[] pop = toVisit.pop();
            int row = pop[0];
            int col = pop[1];
            painted[row][col] = 1;
            image[row][col] = color;

            if(row - 1 >= 0 && painted[row - 1][col] != 1) {
                int rowUp = image[row - 1][col];
                if(rowUp == oldColor) {
                    toVisit.push(new int[]{row - 1, col});
                }
            }
            if(row + 1 < rowLen && painted[row + 1][col] != 1) {
                int rowDown = image[row + 1][col];
                if(rowDown == oldColor) {
                    toVisit.push(new int[]{row + 1, col});
                }
            }
            if(col - 1 >= 0 && painted[row][col - 1] != 1) {
                int colLeft = image[row][col - 1];
                if(colLeft == oldColor) {
                    toVisit.push(new int[]{row, col - 1});
                }
            }
            if(col + 1 < colLen && painted[row][col + 1] != 1) {
                int colRight = image[row][col + 1];
                if(colRight == oldColor) {
                    toVisit.push(new int[]{row, col + 1});
                }
            }
        }
        return image;
    }

    public static int[][] floodFillRecursive(int[][] image, int sr, int sc, int newColor)
    {
        int color = image[sr][sc];
        if(color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }

    public static void dfs(int[][] image, int r, int c, int color, int newColor)
    {
        if(image[r][c] == color) {
            image[r][c] = newColor;
            if(r >= 1) {
                dfs(image, r - 1, c, color, newColor);
            }
            if(c >= 1) {
                dfs(image, r, c - 1, color, newColor);
            }
            if(r + 1 < image.length) {
                dfs(image, r + 1, c, color, newColor);
            }
            if(c + 1 < image[0].length) {
                dfs(image, r, c + 1, color, newColor);
            }
        }
    }
}
