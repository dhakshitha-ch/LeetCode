
class Solution {

    void bfs(int row, int col, char[][] board, boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 4; i++) {

                int nr = r + delRow[i];
                int nc = c + delCol[i];

                if (nr >= 0 && nr < board.length &&
                    nc >= 0 && nc < board[0].length &&
                    board[nr][nc] == 'O' && !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        if (n == 0 || m == 0) return;

        boolean[][] visited = new boolean[n][m];

        // First and last columns
        for (int i = 0; i < n; i++) {

            if (board[i][0] == 'O' && !visited[i][0]) {
                bfs(i, 0, board, visited);
            }

            if (board[i][m - 1] == 'O' && !visited[i][m - 1]) {
                bfs(i, m - 1, board, visited);
            }
        }

        // First and last rows
        for (int j = 0; j < m; j++) {

            if (board[0][j] == 'O' && !visited[0][j]) {
                bfs(0, j, board, visited);
            }

            if (board[n - 1][j] == 'O' && !visited[n - 1][j]) {
                bfs(n - 1, j, board, visited);
            }
        }

        // Convert surrounded O's into X's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
