
    class Solution {

    static final long MOD = 1000000007;

    static long power(long x, long n) {

        if (n == 0) {
            return 1;
        }

        long half = power(x, n / 2);

        half = (half * half) % MOD;

        if (n % 2 == 0) {
            return half;
        }

        return (half * x) % MOD;
    }

    public int countGoodNumbers(long n) {

        // Number of even indices
        long even = (n + 1) / 2;

        // Number of odd indices
        long odd = n / 2;

        long evenWays = power(5, even);
        long oddWays = power(4, odd);

        return (int) ((evenWays * oddWays) % MOD);
    }
}
    
