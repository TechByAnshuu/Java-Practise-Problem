class Solution {

    boolean check(int speed, int[] piles, int h) {
        long hrsRequired = 0;

        for (int i = 0; i < piles.length; i++) {
            hrsRequired += (piles[i] + speed - 1) / speed; // a/b = (a+b-1)/b

            if (hrsRequired > h)
                return false;
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1, high = (int) 1e9;

        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, piles, h) == true) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}