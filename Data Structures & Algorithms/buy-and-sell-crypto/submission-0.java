class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int smallest = Integer.MAX_VALUE;

        for (int price: prices) {
            smallest = Math.min(smallest, price);
            maxProfit = Math.max(maxProfit, price - smallest);
        }

        return maxProfit;
    }
}
