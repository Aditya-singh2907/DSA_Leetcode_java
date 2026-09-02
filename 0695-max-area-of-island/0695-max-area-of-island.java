class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int a=0;
        boolean[][]vis=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    a=Math.max(a,dfs(grid,vis,i,j));
                }
            }
        }
        return a;
    }
    public int dfs(int[][] grid,boolean[][]vis,int a,int b){
        if(a<0||b<0||a>=grid.length||b>=grid[0].length||vis[a][b]||grid[a][b]==0) return 0;
        vis[a][b]=true;
        return 1+dfs(grid,vis,a-1,b)+dfs(grid,vis,a+1,b)+dfs(grid,vis,a,b-1)+dfs(grid,vis,a,b+1);
    }
}