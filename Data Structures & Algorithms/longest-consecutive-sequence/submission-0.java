class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int num: nums) {
            set.add(num);
        }

        for (int num: nums) {
            int temp = checkProgressiveCount(num, set);

            result = Math.max(result, temp);
        }

        return result;
    }

    int checkProgressiveCount(int num, Set<Integer> set) {
        int temp = 0;

        while(set.contains(num)) {
            temp++;
            num++;
        }

        return temp;
    }
}
