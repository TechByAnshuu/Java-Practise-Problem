/*  You are given an array of numbers.
You must choose any 2 or more numbers from the array.

Do bitwise OR of those selected numbers.

If the OR result is even (ends with 0 in binary → has trailing zero), return true.

If ALL OR results are odd (end with 1), return false.
*/

public class BitwiseOr {

    public static boolean hasTrailingZeros(int[] nums) {
        for (int n : nums) {
            if (n % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 9};

        boolean result = hasTrailingZeros(nums);

        System.out.println("Result: " + result);
    }
}
