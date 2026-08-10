class Solution {
   public int maxfun(int [] weights)
   {
       int max= weights[0];

        for(int i=1;i<weights.length;i++)
        {
            if(weights[i]>max)
            {
                max=weights[i];
            }
        }
    
      return max;
   }
   public int sumfun(int [] weights)
   {
      int sum=0;
      for(int i=0;i<weights.length;i++)
      {
        sum+=weights[i];
      }
      return sum;
   }
   public boolean isPossible(int [] weights, int mid,int days)
   {
          int count=0;
          int day=1;
          for(int i=0;i<weights.length;i++)
          {
              if(weights[i]+count>mid)
              {
                day++;
                count=weights[i];
              }
              else
              {
                count+=weights[i];
              }
  
          }
         if(day<=days)
          {
            return true;
          }
           else
          {
            return false;
          }
   }

    public int shipWithinDays(int[] weights, int days) {
        int low=maxfun(weights) ;
        int high= sumfun(weights);
        int ans= high;
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            if(isPossible(weights,mid,days))
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