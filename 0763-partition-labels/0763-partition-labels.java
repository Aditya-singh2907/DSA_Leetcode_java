class Solution {
    public List<Integer> partitionLabels(String s) {

        int[] arr = new int[26];

        for(int i = 0; i < s.length(); ++i) {
            arr[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();

        int j = 0;
        int rec = 0;

        for(int i = 0; i < s.length(); ++i) {
            j = Math.max(j, arr[s.charAt(i) - 'a']);
            if(i == j) {
                res.add(i - rec + 1);
                rec = i + 1;
                j = 0;
            }
        }

        return res;
    }
}