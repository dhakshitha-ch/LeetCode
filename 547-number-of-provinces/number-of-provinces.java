class Solution {
     
    void bfs(int [][] isConnected , int start, boolean [] visited)
    {
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty())
        {
            int node=q.poll();
            for(int j=0;j<isConnected.length;j++)
            {
                if(isConnected[node][j]==1 && !visited[j])
                {
                    visited[j]=true;
                    q.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean [] visited = new boolean[n];
        int count=0;

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                count++;
                bfs(isConnected,i,visited);
            }
        }
        return count;
    }
}