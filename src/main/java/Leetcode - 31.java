// 3013. Divide an Array Into Subarrays With Minimum Cost II
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// You are given a 0-indexed array of integers nums of length n, and two positive integers k and dist.

// The cost of an array is the value of its first element. For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.

// You need to divide nums into k disjoint contiguous subarrays, such that the difference between the starting index of the second subarray and the starting index of the kth subarray should be less than or equal to dist. In other words, if you divide nums into the subarrays nums[0..(i1 - 1)], nums[i1..(i2 - 1)], ..., nums[ik-1..(n - 1)], then ik-1 - i1 <= dist.

// Return the minimum possible sum of the cost of these subarrays.

 

// Example 1:

// Input: nums = [1,3,2,6,4,2], k = 3, dist = 3
// Output: 5
// Explanation: The best possible way to divide nums into 3 subarrays is: [1,3], [2,6,4], and [2]. This choice is valid because ik-1 - i1 is 5 - 2 = 3 which is equal to dist. The total cost is nums[0] + nums[2] + nums[5] which is 1 + 2 + 2 = 5.
// It can be shown that there is no possible way to divide nums into 3 subarrays at a cost lower than 5.
// Example 2:

// Input: nums = [10,1,2,2,2,1], k = 4, dist = 3
// Output: 15
// Explanation: The best possible way to divide nums into 4 subarrays is: [10], [1], [2], and [2,2,1]. This choice is valid because ik-1 - i1 is 3 - 1 = 2 which is less than dist. The total cost is nums[0] + nums[1] + nums[2] + nums[3] which is 10 + 1 + 2 + 2 = 15.
// The division [10], [1], [2,2,2], and [1] is not valid, because the difference between ik-1 and i1 is 5 - 1 = 4, which is greater than dist.
// It can be shown that there is no possible way to divide nums into 4 subarrays at a cost lower than 15.
// Example 3:

// Input: nums = [10,8,18,9], k = 3, dist = 1
// Output: 36
// Explanation: The best possible way to divide nums into 4 subarrays is: [10], [8], and [18,9]. This choice is valid because ik-1 - i1 is 2 - 1 = 1 which is equal to dist.The total cost is nums[0] + nums[1] + nums[2] which is 10 + 8 + 18 = 36.
// The division [10], [8,18], and [9] is not valid, because the difference between ik-1 and i1 is 3 - 1 = 2, which is greater than dist.
// It can be shown that there is no possible way to divide nums into 3 subarrays at a cost lower than 36.
 

// Constraints:

// 3 <= n <= 105
// 1 <= nums[i] <= 109
// 3 <= k <= n
// k - 2 <= dist <= n 


class Multiset {
  public void add(int num) {
    map.merge(num, 1, Integer::sum);
    ++sz;
  }

  public void remove(int num) {
    map.merge(num, -1, Integer::sum);
    if (map.get(num) == 0)
      map.remove(num);
    --sz;
  }

  public int min() {
    return map.firstEntry().getKey();
  }

  public int max() {
    return map.lastEntry().getKey();
  }

  public int size() {
    return sz;
  }

  public boolean contains(int num) {
    return map.containsKey(num);
  }

  private TreeMap<Integer, Integer> map = new TreeMap<>();
  private int sz = 0;
}

class Solution {
  public long minimumCost(int[] nums, int k, int dist) {
    // Equivalently, the problem is to find nums[0] + the minimum sum of the top
    // k - 1 numbers in nums[i..i + dist], where i > 0 and i + dist < n.
    long windowSum = 0;
    Multiset selected = new Multiset();
    Multiset candidates = new Multiset();

    for (int i = 1; i <= dist + 1; ++i) {
      windowSum += nums[i];
      selected.add(nums[i]);
    }

    windowSum = balance(windowSum, selected, candidates, k);
    long minWindowSum = windowSum;

    for (int i = dist + 2; i < nums.length; ++i) {
      final int outOfScope = nums[i - dist - 1];
      if (selected.contains(outOfScope)) {
        windowSum -= outOfScope;
        selected.remove(outOfScope);
      } else {
        candidates.remove(outOfScope);
      }
      if (nums[i] < selected.max()) { // nums[i] is a better number.
        windowSum += nums[i];
        selected.add(nums[i]);
      } else {
        candidates.add(nums[i]);
      }
      windowSum = balance(windowSum, selected, candidates, k);
      minWindowSum = Math.min(minWindowSum, windowSum);
    }

    return nums[0] + minWindowSum;
  }

  // Returns the updated `windowSum` by balancing the multiset `selected` to
  // keep the top k - 1 numbers.
  private long balance(long windowSum, Multiset selected, Multiset candidates, int k) {
    while (selected.size() < k - 1) {
      final int minCandidate = candidates.min();
      windowSum += minCandidate;
      selected.add(minCandidate);
      candidates.remove(minCandidate);
    }
    while (selected.size() > k - 1) {
      final int maxSelected = selected.max();
      windowSum -= maxSelected;
      selected.remove(maxSelected);
      candidates.add(maxSelected);
    }
    return windowSum;
  }
}