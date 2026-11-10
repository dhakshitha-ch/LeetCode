
class Solution {

    // Helper class to store coordinates
    class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }

        return count;
    }

    private void bfs(int ro, int co, int[][] visited, char[][] grid) {

        visited[ro][co] = 1;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(ro, co));

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {

            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();

            // Traverse in all 4 directions
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {

                    // Skip diagonal and current cell
                    if (Math.abs(delRow) + Math.abs(delCol) != 1) {
                        continue;
                    }

                    int nrow = row + delRow;
                    int ncol = col + delCol;

                    if (nrow >= 0 && nrow < n &&
                        ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == '1' &&
                        visited[nrow][ncol] == 0) {

                        visited[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}
