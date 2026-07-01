class Solution {
    public int mostFrequentEven(int[] nums) {
        int maxFreq = 0;
        int result = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 != 0) continue;

            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > maxFreq || (count == maxFreq && nums[i] < result)) {
                maxFreq = count;
                result = nums[i];
            }
        }

        return result;
    }
}