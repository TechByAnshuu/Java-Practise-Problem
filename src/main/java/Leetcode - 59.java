// 1758. Minimum Changes To Make Alternating Binary String
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.

// The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.

// Return the minimum number of operations needed to make s alternating.

 

// Example 1:

// Input: s = "0100"
// Output: 1
// Explanation: If you change the last character to '1', s will be "0101", which is alternating.
// Example 2:

// Input: s = "10"
// Output: 0
// Explanation: s is already alternating.
// Example 3:

// Input: s = "1111"
// Output: 2
// Explanation: You need two operations to reach "0101" or "1010".
 

// Constraints:

// 1 <= s.length <= 104
// s[i] is either '0' or '



class Solution {
    public int minOperations(String s) {
        // Count operations needed to make string start with '0' (pattern: 010101...)
        int operationsForPattern0 = 0;
        int stringLength = s.length();
      
        // Check each character against the expected pattern starting with '0'
        for (int i = 0; i < stringLength; i++) {
            // For pattern starting with '0':
            // - Even indices (0, 2, 4, ...) should have '0'
            // - Odd indices (1, 3, 5, ...) should have '1'
            // Using bitwise AND: i & 1 gives 0 for even indices, 1 for odd indices
            char expectedChar = "01".charAt(i & 1);
          
            // If current character doesn't match expected, we need an operation
            if (s.charAt(i) != expectedChar) {
                operationsForPattern0++;
            }
        }
      
        // The other pattern (starting with '1') would need (stringLength - operationsForPattern0) operations
        // Return the minimum of the two patterns
        return Math.min(operationsForPattern0, stringLength - operationsForPattern0);
    }
}