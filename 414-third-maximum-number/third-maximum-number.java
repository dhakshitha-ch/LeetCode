class Solution {
    public int thirdMax(int[] nums) {
        int n= nums.length;
        for(int i=0;i<n-1;i++)
        {
            boolean swap = false;
            for(int j=0;j<n-i-1;j++)
            {
                if(nums[j]>nums[j+1])
                {
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    swap=true;
                }
            }
            if(!swap)
            {
                break;
            }
        }
        
        int count = 1;
        int prev = nums[n - 1];

        for(int i = n - 2; i >= 0; i--) {

            if(nums[i] != prev) {

                count++;
                prev = nums[i];

                if(count == 3) {
                    return nums[i];
                }
            }
        }

        // Less than 3 distinct elements
        return nums[n - 1];
    }
}
