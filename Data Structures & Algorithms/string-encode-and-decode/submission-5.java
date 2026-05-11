class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append("@").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        if (str.isEmpty()) {
            return result;
        }
        
        int i = 0;
        
        for (i = 0; i < str.length();) {
            int j = i;
            
            int index = str.indexOf("@", i);

            Integer size = Integer.parseInt(str.substring(j, index));

            String s = str.substring(index + 1, index + size + 1);
            result.add(s);

            i = index + 1 + size;
        }

        return result;
    }
}
