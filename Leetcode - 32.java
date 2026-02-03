// 3637. Trionic Array I
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array nums of length n.

// An array is trionic if there exist indices 0 < p < q < n − 1 such that:

// nums[0...p] is strictly increasing,
// nums[p...q] is strictly decreasing,
// nums[q...n − 1] is strictly increasing.
// Return true if nums is trionic, otherwise return false.

 

// Example 1:

// Input: nums = [1,3,5,4,2,6]

// Output: true

// Explanation:

// Pick p = 2, q = 4:

// nums[0...2] = [1, 3, 5] is strictly increasing (1 < 3 < 5).
// nums[2...4] = [5, 4, 2] is strictly decreasing (5 > 4 > 2).
// nums[4...5] = [2, 6] is strictly increasing (2 < 6).
// Example 2:

// Input: nums = [2,1,3]

// Output: false

// Explanation:

// There is no way to pick p and q to form the required three segments.

 

// Constraints:

// 3 <= n <= 100
// -1000 <= nums[i] <= 1000



class Solution {
    /**
     * Checks if the array follows a trionic pattern:
     * 1. Strictly increasing sequence
     * 2. Followed by strictly decreasing sequence  
     * 3. Followed by strictly increasing sequence
     * All three segments must exist with at least one element each.
     * 
     * @param nums input array to check
     * @return true if array follows trionic pattern, false otherwise
     */
    public boolean isTrionic(int[] nums) {
        int arrayLength = nums.length;
        int currentIndex = 0;
      
        // Phase 1: Find the first strictly increasing segment
        // Move forward while elements are strictly increasing
        while (currentIndex < arrayLength - 2 && nums[currentIndex] < nums[currentIndex + 1]) {
            currentIndex++;
        }
      
        // If no increasing segment found at the beginning, pattern is invalid
        if (currentIndex == 0) {
            return false;
        }
      
        // Phase 2: Find the strictly decreasing segment
        // Save the peak position where decreasing starts
        int peakIndex = currentIndex;
      
        // Move forward while elements are strictly decreasing
        while (currentIndex < arrayLength - 1 && nums[currentIndex] > nums[currentIndex + 1]) {
            currentIndex++;
        }
      
        // Check if decreasing segment exists and doesn't reach the end
        // (we need room for the final increasing segment)
        if (currentIndex == peakIndex || currentIndex == arrayLength - 1) {
            return false;
        }
      
        // Phase 3: Find the final strictly increasing segment
        // Move forward while elements are strictly increasing
        while (currentIndex < arrayLength - 1 && nums[currentIndex] < nums[currentIndex + 1]) {
            currentIndex++;
        }
      
        // Pattern is valid only if we've reached the end of the array
        return currentIndex == arrayLength - 1;
    }
}