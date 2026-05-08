class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;
        boolean[] visited = new boolean[length];
        List<List<String>> list = new ArrayList<>();

        for(int i = 0; i < length; i++) {
            List<String> subList = new ArrayList<>();
            if (visited[i]) {
                continue;
            }
            
            subList.add(strs[i]);
            visited[i] = true;
            
            for (int j = i + 1; j < length; j++) {
                boolean isAnagram = !visited[j] ? checkAnagram(strs[i], strs[j]) : false;

                if (isAnagram) {
                    subList.add(strs[j]);
                    visited[j] = true; 
                }
            }

            list.add(new ArrayList<>(subList));
        }

        return list;
    }

    public boolean checkAnagram(String s1, String s2) {
        int[] arr = new int[26];

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }

        for (int i: arr) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
