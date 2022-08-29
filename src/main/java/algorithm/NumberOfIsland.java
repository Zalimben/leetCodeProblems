package main.java.algorithm;

/**
 * 200. Number of Islands
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
 * all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * Input: grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * Input: grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * Output: 3
 * <p>
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIsland
{
    public static void main(String[] args)
    {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '1'}
        };
        System.out.println(numberOfIsland(grid));
    }

    public static int numberOfIsland(char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] map, int row, int col)
    {
        if(row < 0 || col < 0 || row >= map.length
            || col >= map[0].length || map[row][col] == '0') {
            return;
        }

        map[row][col] = '0'; // mark visited

        dfs(map, row - 1, col);
        dfs(map, row, col - 1);
        dfs(map, row + 1, col);
        dfs(map, row, col + 1);
    }
}
