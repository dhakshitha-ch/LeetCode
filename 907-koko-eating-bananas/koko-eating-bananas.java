class Solution {

    public int maxfun(int[] piles) {
        int maxnum = piles[0];

        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > maxnum) {
                maxnum = piles[i];
            }
        }
        return maxnum;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = maxfun(piles);
        int ans = high;

        while (low <= high) {

            long hours = 0;
            int mid = low + (high - low) / 2;

            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + mid - 1) / mid;
            }

            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}