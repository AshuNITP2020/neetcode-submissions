class Solution {
    public String minWindow(String s, String t) {
        int[] window = new int[128];
        int[] matched = new int[128];

        for (char ch: t.toCharArray()) {
            matched[ch]++;
        }

        int minWindowLength = Integer.MAX_VALUE;
        int start = 0, end = 0, characterMatched = 0;
        int startingIndex = 0;

        while(end < s.length()) {
            char ch = s.charAt(end);

            window[ch]++;

            if (window[ch] <= matched[ch]) {
                characterMatched++;
            }

            while(t.length() == characterMatched) {

                if ((end - start + 1) < minWindowLength) {
                    minWindowLength = end - start + 1;
                    startingIndex = start;
                }


                char c = s.charAt(start);
                window[c]--;

                if (window[c] < matched[c]) {
                    characterMatched--;
                }

                start++;
             }

             end++;
        }

        return minWindowLength == Integer.MAX_VALUE 
                ? "" 
                : s.substring(startingIndex, startingIndex + minWindowLength);
    }
}
