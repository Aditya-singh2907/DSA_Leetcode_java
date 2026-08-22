class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<numbers.length;i++)
        {
            if(!hm.containsKey(target-numbers[i]))
            hm.put(numbers[i],i);
            else
            return new int[] {hm.get(target-numbers[i])+1,i+1};
        }
        return new int[] {-1,-1};
    }
}