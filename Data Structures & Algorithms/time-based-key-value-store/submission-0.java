class TimeMap {
    Map<MapKey, String> map = new HashMap<>();
    Map<String, List<Integer>> timestamps = new HashMap<>();

    static class MapKey {
        String firstKey;
        int secondKey;

        public MapKey(String firstKey, int secondKey) {
            this.firstKey = firstKey;
            this.secondKey = secondKey;
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstKey, secondKey);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            MapKey other = (MapKey) obj;

            return secondKey == other.secondKey && Objects.equals(firstKey, other.firstKey);
        }
    }

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        map.put(new MapKey(key, timestamp), value);

        timestamps.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
    }

    public String get(String key, int timestamp) {
        List<Integer> list = timestamps.get(key);

        if (list == null) {
            return "";
        }

        int left = 0;
        int right = list.size() - 1;

        int answerTimestamp = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) <= timestamp) {
                answerTimestamp = list.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (answerTimestamp == -1) {
            return "";
        }

        return map.get(new MapKey(key, answerTimestamp));
    }
}
