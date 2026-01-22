// 3507. Minimum Pair Removal to Sort Array I
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given an array nums, you can perform the following operation any number of times:

// Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
// Replace the pair with their sum.
// Return the minimum number of operations needed to make the array non-decreasing.

// An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).

 

// Example 1:

// Input: nums = [5,2,3,1]

// Output: 2

// Explanation:

// The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
// The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
// The array nums became non-decreasing in two operations.

// Example 2:

// Input: nums = [1,2,2]

// Output: 0

// Explanation:

// The array nums is already sorted.

 

// Constraints:

// 1 <= nums.length <= 50
// -1000 <= nums[i] <= 1000

class Solution {
  public int minimumPairRemoval(int[] nums) {
    int ans = 0;
    List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());

    while (hasInversion(numsList)) {
      List<Integer> pairSums = new ArrayList<>();
      for (int i = 0; i < numsList.size() - 1; ++i)
        pairSums.add(numsList.get(i) + numsList.get(i + 1));
      int minPairSum = Integer.MAX_VALUE;
      int minPairIndex = -1;
      for (int i = 0; i < pairSums.size(); ++i)
        if (pairSums.get(i) < minPairSum) {
          minPairSum = pairSums.get(i);
          minPairIndex = i;
        }
      numsList.set(minPairIndex, minPairSum);
      numsList.remove(minPairIndex + 1);
      ++ans;
    }

    return ans;
  }

  private boolean hasInversion(List<Integer> nums) {
    for (int i = 0; i < nums.size() - 1; ++i)
      if (nums.get(i) > nums.get(i + 1))
        return true;
    return false;
  }
}