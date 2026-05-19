class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int[] prefixMax = new int[length];
        int[] suffixMax = new int[length];

        int max = height[0];

        for (int i = 0; i < length; i++) {
            max = Math.max(max, height[i]);
            prefixMax[i] = max;
        }

        max = height[length - 1];

        for (int i = length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            suffixMax[i] = max;
        }

        int result = 0;

        for (int i = 0; i < length; i++) {
            int temp = Math.min(prefixMax[i], suffixMax[i]) - height[i];

            if (temp > 0)
            result += temp;
        }

        return result;
    }
}
