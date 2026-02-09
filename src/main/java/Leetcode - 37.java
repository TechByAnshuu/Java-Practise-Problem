// 110. Balanced Binary Tree
// Easy
// Topics
// premium lock icon
// Companies
// Given a binary tree, determine if it is height-balanced.

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: true
// Example 2:


// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
// Example 3:

// Input: root = []
// Output: true
 

// Constraints:

// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104



class Solution {
  public boolean isBalanced(TreeNode root) {
    maxDepth(root);
    return ans;
  }

  private boolean ans = true;

  // Returns the height of root and sets ans to false if root unbalanced.
  public int maxDepth(TreeNode root) {
    if (root == null || !ans)
      return 0;
    final int left = maxDepth(root.left);
    final int right = maxDepth(root.right);
    if (Math.abs(left - right) > 1)
      ans = false;
    return Math.max(left, right) + 1;
  }
}


