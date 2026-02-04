// 3510. Minimum Pair Removal to Sort Array II
// Hard
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

// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109


class Solution {
  public int minimumPairRemoval(int[] nums) {
    final int n = nums.length;
    int ans = 0;
    int inversionsCount = 0;
    int[] nextIndices = new int[n];
    int[] prevIndices = new int[n];
    long[] values = Arrays.stream(nums).asLongStream().toArray();
    TreeSet<Pair<Long, Integer>> pairSums =
        new TreeSet<>(Comparator.comparingLong(Pair<Long, Integer>::getKey)
                          .thenComparingInt(Pair<Long, Integer>::getValue));

    for (int i = 0; i < n; ++i) {
      nextIndices[i] = i + 1;
      prevIndices[i] = i - 1;
    }

    for (int i = 0; i < n - 1; ++i)
      pairSums.add(new Pair<>((long) nums[i] + nums[i + 1], i));

    for (int i = 0; i < n - 1; ++i)
      if (nums[i + 1] < nums[i])
        ++inversionsCount;

    while (inversionsCount > 0) {
      ++ans;
      Pair<Long, Integer> smallestPair = pairSums.pollFirst();
      final long pairSum = smallestPair.getKey();
      final int currIndex = smallestPair.getValue();
      final int nextIndex = nextIndices[currIndex];
      final int prevIndex = prevIndices[currIndex];
      if (prevIndex >= 0) {
        final long oldPairSum = values[prevIndex] + values[currIndex];
        final long newPairSum = values[prevIndex] + pairSum;
        pairSums.remove(new Pair<>(oldPairSum, prevIndex));
        pairSums.add(new Pair<>(newPairSum, prevIndex));
        if (values[prevIndex] > values[currIndex])
          --inversionsCount;
        if (values[prevIndex] > pairSum)
          ++inversionsCount;
      }

      if (values[nextIndex] < values[currIndex])
        --inversionsCount;

      final int nextNextIndex = (nextIndex < n) ? nextIndices[nextIndex] : n;
      if (nextNextIndex < n) {
        final long oldPairSum = values[nextIndex] + values[nextNextIndex];
        final long newPairSum = pairSum + values[nextNextIndex];
        pairSums.remove(new Pair<>(oldPairSum, nextIndex));
        pairSums.add(new Pair<>(newPairSum, currIndex));
        if (values[nextNextIndex] < values[nextIndex])
          --inversionsCount;
        if (values[nextNextIndex] < pairSum)
          ++inversionsCount;
        prevIndices[nextNextIndex] = currIndex;
      }

      nextIndices[currIndex] = nextNextIndex;
      values[currIndex] = pairSum;
    }

    return ans;
  }
}