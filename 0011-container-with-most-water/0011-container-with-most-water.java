class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int i = 0, j = n-1;
        while(i<j){
            int width = j-i;
            int Height = Math.min(height[i],height[j]);
            int area = Height * width;
            maxArea = Math.max(maxArea,area);

            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxArea;
    }
}