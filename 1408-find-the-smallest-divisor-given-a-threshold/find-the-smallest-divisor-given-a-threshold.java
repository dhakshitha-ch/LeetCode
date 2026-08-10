class Solution {
    public int maxfun(int [] nums)
    {
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
            }
        }
        return max;
    }
    public boolean isPossible(int [] nums, int mid, int threshold)
    {

        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=(nums[i] + mid-1)/mid;
        }
        if(sum<=threshold)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high= maxfun(nums);
      int  ans=high;

        while(low<=high)
        {
            int mid= low+(high-low)/2;
            if(isPossible(nums,mid,threshold))
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