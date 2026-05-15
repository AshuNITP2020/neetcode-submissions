class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int length = heights.length;

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= i; j--) {
                int product = Math.min(heights[i], heights[j]) * Math.abs(i - j);

                maxWater = Math.max(maxWater, product);
            }
        }

        return maxWater;
    }
}
