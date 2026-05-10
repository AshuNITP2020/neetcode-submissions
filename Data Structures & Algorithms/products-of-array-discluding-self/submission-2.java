class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 0;
        int zeroesCount = 0;

        for (int num: nums) {
            if (num != 0) {
                product = product == 0 ? 1 : product;
                product *= num;
                continue;
            }
            zeroesCount++;
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (zeroesCount > 1) {
                break;
            }

            if (zeroesCount == 1) {
                if (nums[i] == 0) {
                    result[i] = product;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = product/nums[i];
            }
        }

        return result;
    }
}  
