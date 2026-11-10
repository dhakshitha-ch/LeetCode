class Solution {
    void bfs(char [][] grid , boolean [][] visited,int row,int col)
    {
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[] {row,col});
        visited[row][col]=true;
        int [] delRow={-1,1,0,0};
        int[] delCol={0,0,-1,1};
        while(!q.isEmpty())
        {
            int[] cell=q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 4; i++) {

                int newRow = r + delRow[i];
                int newCol = c + delCol[i];

                if (newRow >= 0 && newRow < grid.length &&
                    newCol >= 0 && newCol < grid[0].length &&
                    grid[newRow][newCol] == '1' &&
                    !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol});
                }
            }
            
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] =='1' && !visited[i][j])
                {
                    count++;
                    bfs(grid, visited,i,j);
                }
            }
        }
        return count;
    }
}
