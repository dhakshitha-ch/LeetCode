class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orginalcolor = image[sr][sc];

        if(orginalcolor == color)
        {
            return image;
        }
        int n = image.length;
        int m= image[0].length;

        Queue<int []> q= new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc]= color;

        int[] delRow={-1,1,0,0};
        int[] delCol={0,0,-1,1};

        while(!q.isEmpty())
        {

            int [] cell= q.poll();

            int r=cell[0];
            int c= cell[1];

            for(int i=0;i<4;i++)
            {
                int newRow= r+ delRow[i];
                int newCol= c+delCol[i];

                if(newRow >=0 && newRow<n && newCol >=0 && newCol <m
                && image[newRow][newCol]==orginalcolor)
                {
                    image[newRow][newCol] = color;

                    q.add(new int[]{newRow,newCol});
                } 
            }
        }
      return image;
    }
}