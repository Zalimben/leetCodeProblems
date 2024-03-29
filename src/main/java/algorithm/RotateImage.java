package main.java.algorithm;

/**
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * Constraints:
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class RotateImage
{
    public static void main(String[] args)
    {
        int[][] image = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        rotateImage(image);
    }

    public static void rotateImage(int[][] image) {
        int row = image.length;
        for (int r = 0; r < (row + 1) / 2; r++) {
            for (int c = 0; c < row / 2; c++) {
                int temp = image[row - 1 - c][r];
                image[row - 1 - c][r] = image[row - 1 - r][row - c - 1];
                image[row - 1 - r][row - c - 1] = image[c][row - 1 -r];
                image[c][row - 1 - r] = image[r][c];
                image[r][c] = temp;
            }
        }
    }

}
