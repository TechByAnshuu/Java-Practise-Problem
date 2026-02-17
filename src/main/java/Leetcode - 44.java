// 401. Binary Watch
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.

// For example, the below binary watch reads "4:51".


// Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

// The hour must not contain a leading zero.

// For example, "01:00" is not valid. It should be "1:00".
// The minute must consist of two digits and may contain a leading zero.

// For example, "10:2" is not valid. It should be "10:02".
 

// Example 1:

// Input: turnedOn = 1
// Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// Example 2:

// Input: turnedOn = 9
// Output: []
 

// Constraints:

// 0 <= turnedOn <= 10


class Solution {
  public List<String> readBinaryWatch(int turnedOn) {
    List<String> ans = new ArrayList<>();
    dfs(turnedOn, 0, 0, 0, ans);
    return ans;
  }

  private int[] hours = new int[] {1, 2, 4, 8};
  private int[] minutes = new int[] {1, 2, 4, 8, 16, 32};

  private void dfs(int turnedOn, int s, int h, int m, List<String> ans) {
    if (turnedOn == 0) {
      final String time = String.valueOf(h) + ":" + (m < 10 ? "0" : "") + String.valueOf(m);
      ans.add(time);
      return;
    }

    for (int i = s; i < hours.length + minutes.length; ++i)
      if (i < 4 && h + hours[i] < 12)
        dfs(turnedOn - 1, i + 1, h + hours[i], m, ans);
      else if (i >= 4 && m + minutes[i - 4] < 60)
        dfs(turnedOn - 1, i + 1, h, m + minutes[i - 4], ans);
  }
}