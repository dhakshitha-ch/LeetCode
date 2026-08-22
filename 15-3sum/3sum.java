class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

      Arrays.sort(nums);
        int n = nums.length;
      for(int A=0;A<n-2;A++)
     {
        if (A > 0 && nums[A] == nums[A - 1]) {
                continue;
            }
      int B=A+1;
      int C=n-1;
      while(B < C)
       {
         int sum= nums[A] + nums[B] + nums[C];

         if(sum==0)
         {
                   List<Integer> triplet = new ArrayList<>();

            triplet.add(nums[A]);
           triplet.add(nums[B]);
           triplet.add(nums[C]);
            result.add(triplet);
            B++;
            C--;
            while (B < C && nums[B] == nums[B - 1]) {
                        B++;
                    }

                    // Skip duplicate C
                    while (B < C && nums[C] == nums[C + 1]) {
                        C--;
                    }
         }
         else if(sum <0)
         {
            B++;
         }
         else
         {
            C--;
         }
        }
     }
   
   return result;  
}
}