class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;

        int start = 0, end = length - 1;
        int result = Integer.MAX_VALUE;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid] < result) {
                result = nums[mid];
            }

            boolean leftSorted = nums[start] <= nums[mid];
            boolean rightSorted = nums[mid] <= nums[end];

            if (nums[start] < nums[end]) {
                end = start;
                result = Math.min(result, nums[start]);
            } else {
                if (leftSorted) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return result;
    }
}
