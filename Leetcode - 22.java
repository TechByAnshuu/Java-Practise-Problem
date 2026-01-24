// 1877. Minimize Maximum Pair Sum in Array
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.

// For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
// Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:

// Each element of nums is in exactly one pair, and
// The maximum pair sum is minimized.
// Return the minimized maximum pair sum after optimally pairing up the elements.

 

// Example 1:

// Input: nums = [3,5,2,3]
// Output: 7
// Explanation: The elements can be paired up into pairs (3,3) and (5,2).
// The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
// Example 2:

// Input: nums = [3,5,4,2,4,6]
// Output: 8
// Explanation: The elements can be paired up into pairs (3,5), (4,4), and (6,2).
// The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.
 

// Constraints:

// n == nums.length
// 2 <= n <= 105
// n is even.
// 1 <= nums[i] <= 

class Solution {
public:
    int minPairSum(vector<int>& nums) {
        // Sort the array in ascending order
        sort(nums.begin(), nums.end());
      
        // Initialize the maximum pair sum
        int max_pair_sum = 0;
        int n = nums.size();
      
        // Pair the smallest with the largest, second smallest with second largest, etc.
        // This greedy approach minimizes the maximum pair sum
        for (int i = 0; i < n / 2; ++i) {
            // Calculate the sum of current pair (i-th smallest and i-th largest)
            int current_pair_sum = nums[i] + nums[n - i - 1];
          
            // Update the maximum pair sum if current pair sum is larger
            max_pair_sum = max(max_pair_sum, current_pair_sum);
        }
      
        return max_pair_sum;
    }
};
