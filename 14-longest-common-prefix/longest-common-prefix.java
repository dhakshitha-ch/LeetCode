class Solution {
     public String commonPrefix(String a, String b) {

        int min = Math.min(a.length(), b.length());

        for (int i = 0; i < min; i++) {

            if (a.charAt(i) != b.charAt(i)) {
                return a.substring(0, i);
            }
        }

        return a.substring(0, min);
    }
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb= new StringBuilder();
         String prefix= strs[0];
     for(int i=1;i<strs.length;i++)
     {
        
        prefix = commonPrefix(prefix, strs[i]);

     }
     return prefix;
    }
}