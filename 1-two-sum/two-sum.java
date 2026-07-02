class Solution {
    public int[] twoSum(int[] nums, int target) {

        for(int fix=0; fix<nums.length;fix++){
         for (int mov= fix+1; mov<nums.length;mov++)
         {
            if (nums[mov] + nums[fix] == target)
            {
                return new int [] {fix,mov};
            }
            
         }
        }
        return new int[] {};
    }
        
}