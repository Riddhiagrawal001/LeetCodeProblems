//memoized approach
class Solution {
          public int countWays(int row,int col,int[][] obstacleGrid,int[][] dp){
            
      if(row>=0 && col>=0 && obstacleGrid[row][col]==1 || obstacleGrid[0][0]==1 ) return 0;
        if(row==0 && col==0)  return 1;
              if(row<0 || col<0 ) return 0;
   if(dp[row][col]!=-1) return dp[row][col];
                  int left=countWays(row,col-1, obstacleGrid,dp);
                   int up=countWays(row-1,col, obstacleGrid,dp);
                   return dp[row][col]=left+up;
          }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[][] dp=new int[row+1][col+1];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        int res=countWays(row-1,col-1,obstacleGrid,dp);
         return res;
        
    }
    

}
// tabulation
 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[][] dp=new int[row+1][col+1];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0 ;
                else if(i==0 && j==0) dp[0][0]=1;
                else{
                    int left=0;
                    if(j>0)left=dp[i][j-1];
                   int up=0;
                   if(i>0) up=dp[i-1][j];
                dp[i][j]=left+up;
                }
                 
            }
        }
         return dp[row-1][col-1];
    }

//tabulation with space optimization
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[] dp=new int[col+1];
            Arrays.fill(dp,-1);
        for(int i=0;i<row;i++){
            int [] temp=new int[col+1];
            for(int j=0;j<col;j++){
                if(obstacleGrid[i][j]==1) temp[j]=0 ;
                else if(i==0 && j==0) temp[0]=1;
                else{
                    int left=0;
                    if(j>0)left=temp[j-1];
                   int up=0;
                   if(i>0) up=dp[j];
                temp[j]=left+up;
                }
            }
            dp=temp;
        }
         return dp[col-1];
        
    }
