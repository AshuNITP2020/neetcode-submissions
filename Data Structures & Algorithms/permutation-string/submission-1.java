class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int start = 0, end = s1.length();

        while(end <= s2.length()) {
            if (isEqual(s2.substring(start, end), s1)) {
                return true;
            }
            start++;
            end++;
        }

        return false;
    }

    boolean isEqual(String s, String s1) {
        int[] st = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            st[s.charAt(i) - 'a']++;
            st[s1.charAt(i) - 'a']--;
        }

        for (int i : st) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
