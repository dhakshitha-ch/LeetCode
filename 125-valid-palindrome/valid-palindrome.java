class Solution {
    public boolean isPalindrome(String s) {
        String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
       
        int left=0;
        int right= result.length()-1;
        while(left<= right)
        {
            if(result.charAt(left)== result.charAt(right))
            {
                left++;
                right--;

            }
            else
            {
                return false;
            }
        }
        return true;

    }
}