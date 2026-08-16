class Solution {
    public void sortColors(int[] nums) {
    
      int low=0;
      int mid=0;
      int high= nums.length-1;
      while(mid<=high)
      {
        if(nums[mid]==0)
        {
            int temp1=nums[low];
            nums[low]=nums[mid];
            nums[mid]=temp1;
            low++;
            mid++;
        }
         else if(nums[mid]==1)
        {
            mid++;
        }
        else
        {
            int temp2=nums[mid];
            nums[mid]=nums[high];
            nums[high]=temp2;
            high--;
        }
      }

    }
}