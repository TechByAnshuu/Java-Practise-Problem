class Solution {
    public int countDigits(int num) {
        int originalNum = num;
        int count = 0;
        while (num > 0){
            int lastDigit = num % 10 ;
            if(originalNum % lastDigit == 0){
                count = count + 1;

            }
            
            num = num/10;
        }
        return count;
    }
    
}