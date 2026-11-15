class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int [] > q = new LinkedList<>();
        int minutes=0;
        int fresh=0;
       int n= grid.length;
       int m = grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] ==2)
                {
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
       int [] delRow= {-1,1,0,0};
       int [] delCol={0,0,-1,1};
        while(!q.isEmpty() && fresh > 0){
         int size = q.size();
        for (int k = 0; k < size; k++) {

                int[] cell = q.poll();

                int r = cell[0];
                int c = cell[1];

                // Check all four directions
                for (int i = 0; i < 4; i++) {

                    int newRow = r + delRow[i];
                    int newCol = c + delCol[i];

                    if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < m &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;

                        q.add(new int[]{newRow, newCol});
                    }
                }
            }

            // One complete BFS level = one minute
            minutes++;
        }

        return fresh == 0 ? minutes :-1;
        
    }
}