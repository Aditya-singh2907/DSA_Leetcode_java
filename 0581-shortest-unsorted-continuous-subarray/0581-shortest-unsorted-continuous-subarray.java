class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        int left = 0, right = nums.length - 1;
        while(left < nums.length && nums[left] == arr[left]){
            ++left;
        }

        while(right >= 0 && nums[right] == arr[right]){
            --right;
        }
        if(left == nums.length) return 0;
        return right - left + 1;
    }
}