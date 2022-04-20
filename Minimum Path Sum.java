// recursion 
class Solution {
    static int minSum(int row,int col,int[][] grid){
        if(row==0 && col==0 )
            return grid[0][0];
        if(row<0 || col<0 ) return 9999;
        
        int left=grid[row][col]+minSum(row,col-1,grid);
        int up=grid[row][col]+minSum(row-1,col,grid);
        return Math.min(left,up);
    }
    
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
         System.out.println(row+" "+col);
        int res=minSum(row-1,col-1,grid);
        return res;
    }
}

// memoization 
class Solution {
    static int minSum(int row,int col,int[][] grid,int[][] dp){
        if(row==0 && col==0 )
            return grid[0][0];
        if(row<0 || col<0 ) return 9999;
        if(dp[row][col]!=-1) return dp[row][col];
        
        int left=grid[row][col]+minSum(row,col-1,grid,dp);
        int up=grid[row][col]+minSum(row-1,col,grid,dp);
        return dp[row][col]=Math.min(left,up);
    }
    
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] dp=new int[row+1][col+1];

        for(int[] r: dp)
            Arrays.fill(r,-1);
        
        int res=minSum(row-1,col-1,grid,dp);
        return res;
    }
}

//tabulation 
   public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] dp=new int[row+1][col+1];

        for(int[] r: dp)
            Arrays.fill(r,-1);
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0) dp[i][j]=grid[0][0];
                else {
                int left=grid[i][j];
                int up=grid[i][j];
                if(j>0) left+=dp[i][j-1]; else left+=9999;
                 if (i>0) up+=dp[i-1][j]; else up+=9999;
                dp[i][j]=Math.min(left,up);
                }
            }
        }
        
        
      //  int res=minSum(row-1,col-1,grid,dp);
        return dp[row-1][col-1];
    }

// tabulation with space optimizaiton
  public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[]dp=new int[col+1];
            Arrays.fill(dp,-1);
        
        for(int i=0;i<row;i++){
            int[] temp=new int[col+1];
            for(int j=0;j<col;j++){
                if(i==0 && j==0) temp[j]=grid[i][j];
                else {
                int left=grid[i][j];
                int up=grid[i][j];
                if(j>0) left+=temp[j-1]; else left+=9999;
                 if (i>0) up+=dp[j]; else up+=9999;
                temp[j]=Math.min(left,up);
                }
            }
            dp=temp;
        }
        return dp[col-1];
    }
