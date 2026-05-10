class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int count = 0;
        int[] result = new int[k];

        for(Map.Entry<Integer, Integer> m: list) {
            if (count < k) {
                result[count] = m.getKey();
            }
            count++;
        }

        return result;
    } 
}
