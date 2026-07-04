class Solution {
    public int[] nextGreaterElements(int[] nums) {
          Stack<Integer> st = new Stack<>();
          int n=nums.length;
          int[] ans = new int[n];
           Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * n; i++) {

   int  idx = i % n;

    while (!st.isEmpty() &&  nums[idx] > nums[st.peek()]) {
         ans[st.pop()] = nums[idx];
    }

    if (i < n) {
        st.push(idx);
    }
}
return ans;
    }
}