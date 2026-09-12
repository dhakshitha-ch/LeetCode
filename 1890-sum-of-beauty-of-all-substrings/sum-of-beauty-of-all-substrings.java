class Solution {
    static int max(int [] freq,int n)
    {
          int maxim= freq[0];
          for(int i=0;i<n;i++)
          {
            if(freq[i] > maxim)
            {
                maxim= freq[i];
            }
          }
          return maxim;
    }
    static int min(int [] freq,int n)
    {
          int minim= Integer.MAX_VALUE;
          for(int i=0;i<n;i++)
          {
            if( freq[i] >0  && freq[i] < minim)
            {
                minim= freq[i];
            }
          }
          return minim;
    }
    public int beautySum(String s) {
        int n=26;
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            int [] freq= new int[n];
            for(int j= i;j<s.length();j++)
            {
                      freq[s.charAt(j) - 'a']++;
                      int maf= max(freq,n);
                      int mif= min(freq,n);
                      if (maf- mif !=0)
                      {
                        sum+=(maf-mif);
                      }
            }
                      
        }

        return sum;
    }
}