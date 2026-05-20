class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, length = s.length();
        int[] st = new int[26];
        int maxFreq = 0;
        int result = 0;

        while(end < length) {
            int ch = s.charAt(end);
            st[ch - 'A']++;

            maxFreq = Math.max(maxFreq, st[ch - 'A']);

            if (((end - start + 1) - maxFreq) > k) {
                ch = s.charAt(start);
                st[ch - 'A']--;
                start++;
            }

            result = Math.max(result, (end - start + 1));
            end++;
        }

        return result;
    }
}
