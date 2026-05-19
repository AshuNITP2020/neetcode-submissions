class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charArray = new int[128];

        int length = s.length(), start = 0, end = 0;
        int result = 0;

        while(end < length) {
            int ch = s.charAt(end);

            while(charArray[ch] > 0) {
                int stCh = s.charAt(start);
                start++;
                charArray[stCh]--;
            }

            charArray[ch]++;
            result = Math.max(result, end - start + 1);
            end++;
        }

        return result;
    }
}
