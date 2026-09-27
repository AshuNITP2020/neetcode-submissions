class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();

        for (char c: ch) {
            if (c == '{' || c == '(' || c == '[') {
                st.push(c);
            } else if (st.isEmpty()) {
                return false;
            } else {
                char prev = st.pop();
                if (c == '}' && prev != '{') {
                    return false;
                } else if (c == ']' && prev != '[') {
                    return false;
                } else if (c == ')' && prev != '(') {
                    return false;
                }
            }
        }
        return st.isEmpty() ? true : false;
    }
}
