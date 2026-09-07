class Solution {
    static double calculate(double x,long N)
    { 
        if( N==0)
        {
            return 1 ;
        }
        double half=calculate(x, N/2);
        if (N% 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }

       
    }
    public double myPow(double x, int n) {
        long N=n;
        if(N<0)
        {
            x=1/x;
            N=-N;
        }
         return calculate(x,n);
        
    }
}