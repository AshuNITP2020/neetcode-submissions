class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int remaining = -1 * (nums[i] + nums[j]);
                Integer index = map.get(remaining);

                if (index != null && (index != i && index != j)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], remaining);
                    Collections.sort(temp);

                    result.add(temp);
                }
            }
        }

        return new ArrayList<>(result);
    }
}
