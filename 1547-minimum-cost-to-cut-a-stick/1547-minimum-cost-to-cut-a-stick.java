class Solution {
    // //-----------Recursive---------------
    // public int minCost(int n, int[] cuts) {
    //     int[] arr = new int[cuts.length + 2];
    //     arr[0] = 0;
    //     arr[arr.length-1] = n;
    //     for(int i=0;i<cuts.length;i++){
    //         arr[i+1] = cuts[i];
    //     } 
    
    //     Arrays.sort(arr);
    //     return cost(1,cuts.length,arr);
    // }

    // private int cost(int i, int j, int[] arr){
    //     if(i>j) return 0;
    //     int minCost = Integer.MAX_VALUE;
    //     for(int k=i;k<=j;k++){
    //         int len = arr[j+1] - arr[i-1];
    //         int totalCost = cost(i,k-1,arr) + cost(k+1,j,arr) + len;
    //         minCost = Math.min(minCost, totalCost);
    //     }
    //     return minCost;
    // }


    //---------------DP------------------
    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length-1] = n;
        for(int i=0;i<cuts.length;i++){
            arr[i+1] = cuts[i];
        } 
    
        Arrays.sort(arr);
        int m = arr.length;
        int[][] dp = new int[m-1][m-1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return cost(1,cuts.length,arr,dp);
    }

    private int cost(int i, int j, int[] arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int len = arr[j+1] - arr[i-1];
            int totalCost = cost(i,k-1,arr,dp) + cost(k+1,j,arr,dp) + len;
            minCost = Math.min(minCost, totalCost);
        }
        return dp[i][j] = minCost;
    }
}