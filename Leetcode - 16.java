// 1895. Largest Magic Square
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// A k x k magic square is a k x k grid filled with integers such that every row sum, every column sum, and both diagonal sums are all equal. The integers in the magic square do not have to be distinct. Every 1 x 1 grid is trivially a magic square.

// Given an m x n integer grid, return the size (i.e., the side length k) of the largest magic square that can be found within this grid.

 

// Example 1:


// Input: grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
// Output: 3
// Explanation: The largest magic square has a size of 3.
// Every row sum, column sum, and diagonal sum of this magic square is equal to 12.
// - Row sums: 5+1+6 = 5+4+3 = 2+7+3 = 12
// - Column sums: 5+5+2 = 1+4+7 = 6+3+3 = 12
// - Diagonal sums: 5+4+3 = 6+4+2 = 12
// Example 2:


// Input: grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
// Output: 2
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// 1 <= grid[i][j] <= 106



class Solution {
  public int largestMagicSquare(int[][] grid) {
    final int m = grid.length;
    final int n = grid[0].length;
    // prefixRow[i][j] := the sum of the first j numbers in the i-th row
    int[][] prefixRow = new int[m][n + 1];
    // prefixCol[i][j] := the sum of the first j numbers in the i-th column
    int[][] prefixCol = new int[n][m + 1];

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j) {
        prefixRow[i][j + 1] = prefixRow[i][j] + grid[i][j];
        prefixCol[j][i + 1] = prefixCol[j][i] + grid[i][j];
      }

    for (int k = Math.min(m, n); k >= 2; --k)
      if (containsMagicSquare(grid, prefixRow, prefixCol, k))
        return k;

    return 1;
  }

  // Returns true if the grid contains any magic square of size k x k.
  private boolean containsMagicSquare(int[][] grid, int[][] prefixRow, int[][] prefixCol, int k) {
    for (int i = 0; i + k - 1 < grid.length; ++i)
      for (int j = 0; j + k - 1 < grid[0].length; ++j)
        if (isMagicSquare(grid, prefixRow, prefixCol, i, j, k))
          return true;
    return false;
  }

  // Returns true if grid[i..i + k)[j..j + k) is a magic square.
  private boolean isMagicSquare(int[][] grid, int[][] prefixRow, int[][] prefixCol, int i, int j,
                                int k) {
    int diag = 0;
    int antiDiag = 0;
    for (int d = 0; d < k; ++d) {
      diag += grid[i + d][j + d];
      antiDiag += grid[i + d][j + k - 1 - d];
    }
    if (diag != antiDiag)
      return false;
    for (int d = 0; d < k; ++d) {
      if (getSum(prefixRow, i + d, j, j + k - 1) != diag)
        return false;
      if (getSum(prefixCol, j + d, i, i + k - 1) != diag)
        return false;
    }
    return true;
  }

  // Returns sum(grid[i][l..r]) or sum(grid[l..r][i]).
  private int getSum(int[][] prefix, int i, int l, int r) {
    return prefix[i][r + 1] - prefix[i][l];
  }
}