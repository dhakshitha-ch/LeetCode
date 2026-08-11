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
    public int sumfun(int [] nums)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        return sum;
    }
    public boolean canSplit(int [] nums , int k,int mid)
    {
        int addup=0;
        int subarray=1;
        for(int i=0;i<nums.length;i++)
        {
            if(addup+nums[i] >mid)
            {
            subarray++;
            addup = nums[i];
            }
            else
            {
             addup+=nums[i];

            }
        }
        if(subarray<=k)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int splitArray(int[] nums, int k) {
        int low= maxfun(nums);
        int high=sumfun(nums);
        int ans=0;

        while(low<=high)
        {
           int  mid=low+(high-low)/2;
            if(canSplit(nums,k,mid))
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