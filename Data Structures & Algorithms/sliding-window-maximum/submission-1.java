class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int currMax = Integer.MIN_VALUE;
        int length = nums.length;
        int[] result = new int[length - k + 1];

        int j = 0;

        for (int i = 0; i < length - k + 1; i++) {
            currMax = findMax(nums, i, k);

            result[j++] = currMax;
        }

        return result;
    }

    int findMax(int[] nums, int i, int k) {
        int currMax = Integer.MIN_VALUE;

        for (int j = i; j < i + k && j < nums.length; j++) {
            currMax = Math.max(currMax, nums[j]);
        }

        return currMax;
    }
}
