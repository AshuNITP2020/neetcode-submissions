class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = piles[0];

        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int low = 1, answer = 1;

        while (low <= maxPile) {
            int mid = low + (maxPile - low) / 2;

            if (canFinish(piles, h, mid)) {
                answer = mid;
                maxPile = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    boolean canFinish(int[] piles, int h, int k) {

    int hours = 0;

    for (int pile : piles) {

        hours += (pile + k - 1) / k;

        if (hours > h) {
            return false;
        }
    }

    return hours <= h;
}
}
