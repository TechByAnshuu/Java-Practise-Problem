/*  You are given an array of numbers.
You must choose any 2 or more numbers from the array.

Do bitwise OR of those selected numbers.

If the OR result is even (ends with 0 in binary → has trailing zero), return true.

If ALL OR results are odd (end with 1), return false.
*/
class BitwiseOr {
    public boolean hasTrailingZeros(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (((nums[i] | nums[j]) & 1) == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
