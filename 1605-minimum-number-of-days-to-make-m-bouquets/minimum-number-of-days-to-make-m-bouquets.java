class Solution {
    public int maxfun(int [] bloomDay)
    {
        int max=bloomDay[0];
        for(int i=1 ;i< bloomDay.length;i++)
        {
            if(bloomDay[i]>max)
            {
                max= bloomDay[i];
            }
        }
        return max;
    }
    public int minfun(int [] bloomDay)
    {
        int min=bloomDay[0];
        for(int i=1;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<min)
            {
                min= bloomDay[i];
            }
        }
        return min;
    }
    public boolean isPossible(int [] bloomDay,int mid,int m,int k)
    {
         int count=0;
         int bouquet=0;

         for(int i=0;i<bloomDay.length;i++)
         {
            if(bloomDay[i] <=mid)
            {
                count++;
            }
            else
            {
                count=0;
            }
        if(count== k)
        {
            bouquet++;
            count=0;
        }
  
       }   
       if(bouquet >=m)
       {
        return true;
       }
       else
       {
        return false;
       }

    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k > bloomDay.length)
        {
            return -1;
        }
        int low=minfun(bloomDay);
        int high=maxfun(bloomDay);
        int ans= high;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(isPossible(bloomDay,mid,m,k))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
            
        }
        return ans;
        
    }
}