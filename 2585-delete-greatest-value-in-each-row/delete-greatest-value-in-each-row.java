import java.util.Arrays;

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        // Sort each row
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int ans = 0;
        int cols = grid[0].length;

        // Find the maximum in each column
        for (int j = 0; j < cols; j++) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                max = Math.max(max, grid[i][j]);
            }
            ans += max;
        }

        return ans;
    }
}