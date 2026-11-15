
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // If both colors are same, no changes needed
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    void dfs(int[][] image, int row, int col,
             int originalColor, int color) {

        int n = image.length;
        int m = image[0].length;

        // Change current cell's color
        image[row][col] = color;

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        // Explore all 4 directions
        for (int i = 0; i < 4; i++) {

            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (newRow >= 0 && newRow < n &&
                newCol >= 0 && newCol < m &&
                image[newRow][newCol] == originalColor) {

                dfs(image, newRow, newCol, originalColor, color);
            }
        }
    }
}
