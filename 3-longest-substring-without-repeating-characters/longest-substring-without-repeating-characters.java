class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        for(int i = 0;i<n;i++){
            HashSet<Character> seen = new HashSet<>();
            for(int j = i;j<n;j++){
                char c = s.charAt(j);
                if(seen.contains(c)){
                    break;
                }
                seen.add(c);
                maxLen = Math.max(maxLen , j-i+1);

            }

        }
        return maxLen;
        
    }
}