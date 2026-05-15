class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);

                        result.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
