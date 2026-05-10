class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                prefix[i] = 1;
            } else {
                prefix[i] = nums[i-1] * prefix[i - 1];
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                suffix[i] = 1;
            } else {
                suffix[i] = nums[i+1] * suffix[i + 1];
            }
        }

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}  
