class Solution {

    int n;
    HashSet<String> set;

    public void dfs(int index, String s, StringBuilder sb, int open, int close) {
        if(index == n) {
            if(open == close) {
                set.add(sb.toString());
            }
            return;
        }

        char ch = s.charAt(index);

        if(Character.isLetter(ch)) {
            sb.append(ch);
            dfs(index + 1, s, sb, open, close);
            sb.deleteCharAt(sb.length() - 1);

            return;
        }

        if(ch == '(') {
            sb.append(ch);
            dfs(index + 1, s, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);

            dfs(index + 1, s, sb, open, close);

        } else {
            if(open > close) {
                sb.append(ch);
                dfs(index + 1, s, sb, open, close + 1);
                sb.deleteCharAt(sb.length() - 1);
            }

            dfs(index + 1, s, sb, open, close);

        }
    }
    

    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        set = new HashSet<>();

        dfs(0, s, new StringBuilder(), 0, 0);

        if(set.size() == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }

        int size = 0;

        for(String str : set) {
            size = Math.max(size, str.length());
        }

        List<String> ans = new ArrayList<>();

        for(String str : set) {
            if(str.length() == size) {
                ans.add(str);
            }
        }

        return ans;


    }
}