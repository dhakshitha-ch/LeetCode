class Solution {
    public int findMin(int[] nums) {
       int low=0;
       int high=nums.length-1;
       int min=Integer.MAX_VALUE;
       while(low<=high)
       {
           if(nums[low]<=nums[high])
           {
             min=Math.min(nums[low],min);
             break;

           }
          int mid=low+(high-low)/2;
         if(nums[low]<=nums[mid])
           {
            min=Math.min(nums[low],min);
            low=mid+1;
           }
           else
           {
            high=mid-1;
            min=Math.min(nums[mid],min);
        

           }

       } 
       return min;
    }
}