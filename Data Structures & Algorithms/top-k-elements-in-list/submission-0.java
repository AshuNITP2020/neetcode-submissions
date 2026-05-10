class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        map = map.entrySet()
        .stream()
        .sorted((a, b) -> b.getValue() - a.getValue())
        .collect(
             LinkedHashMap::new,
             (m, e) -> m.put(e.getKey(), e.getValue()),
             LinkedHashMap::putAll
         );

        int count = 0;
        int[] result = new int[k];

        for(Map.Entry<Integer, Integer> m: map.entrySet()) {
            if (count < k) {
                result[count] = m.getKey();
            }
            count++;
        }

        return result;
    } 
}
