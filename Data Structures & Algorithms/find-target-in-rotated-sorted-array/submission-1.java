class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int start = 0, end = length - 1;
        int result = -1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            boolean leftSorted = nums[start] <= nums[mid];
            boolean rightSorted = nums[mid] <= nums[end];

            if (nums[mid] == target) {
                result = mid;
                break;
            }

            if (leftSorted) {
                if (nums[start] <= target && nums[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return result;
    }
}
