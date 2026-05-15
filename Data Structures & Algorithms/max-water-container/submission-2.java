class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int length = heights.length;
        int left = 0, right = length - 1;

        while (left < right) {
            int product = Math.min(heights[left], heights[right]) * (right - left);

            maxWater = Math.max(maxWater, product);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
