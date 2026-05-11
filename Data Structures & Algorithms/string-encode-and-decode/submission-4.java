class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append(",");
        }

        sb.append("@");

        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        if (str.isEmpty() || str.equals("@")) {
            return result;
        }
        
        List<Integer> list = new ArrayList<>();
        int i = 0;

        int index = str.indexOf("@");

        String lengthSubString = str.substring(0, index);

        String[] strList = lengthSubString.split(",");

        for (String s : strList) {
            list.add(Integer.parseInt(s));
        }

        int j = index + 1;
        String remaining = str.substring(j, str.length());

        for (int length : list) {
            result.add(str.substring(j, j + length));
            j += length;
        }

        return result;
    }
}
