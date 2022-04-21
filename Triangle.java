// recursion 
class Solution {
    static int findWays(int row,int col,List<List<Integer>> triangle){
        if(row==triangle.size()-1)
            return triangle.get(row).get(col);
        int bottom=triangle.get(row).get(col)+findWays(row+1,col,triangle);
        int diag=triangle.get(row).get(col)+findWays(row+1,col+1,triangle);
        
        return Math.min(bottom,diag);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows=triangle.size();
        int res=findWays(0,0,triangle);
        return res;
    }
}

// memoization 
class Solution {
    static int findWays(int row,int col,List<List<Integer>> triangle,int[][] dp){
        if(row==triangle.size()-1)
            return triangle.get(row).get(col);
        if(dp[row][col]!=-1) return dp[row][col];
        int bottom=triangle.get(row).get(col)+findWays(row+1,col,triangle,dp);
        int diag=triangle.get(row).get(col)+findWays(row+1,col+1,triangle,dp);
        
        return dp[row][col]=Math.min(bottom,diag);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows=triangle.size();
        int [][] dp=new int[triangle.size()][triangle.size()];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        int res=findWays(0,0,triangle,dp);
        return res;
    }
}

// tabulation 
public int minimumTotal(List<List<Integer>> triangle) {
        int rows=triangle.size();
         int col=triangle.get(rows-1).size();
        int [][] dp=new int[triangle.size()][triangle.size()];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        
        for(int j=0;j<col;j++)
            dp[rows-1][j]=triangle.get(rows-1).get(j);
        for(int i=rows-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                 int bottom=0;
                int diag=0;
             bottom=triangle.get(i).get(j)+dp[i+1][j];
             diag=triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(bottom,diag);
            }
        }
        return dp[0][0];
    }

// tabulation with space optimization 
   public int minimumTotal(List<List<Integer>> triangle) {
        int rows=triangle.size();
         int col=triangle.get(rows-1).size();
        int [] dp=new int[triangle.size()];
        // for(int[] r : dp)
            Arrays.fill(dp,-1);
        
        for(int j=0;j<col;j++)
            dp[j]=triangle.get(rows-1).get(j);
        
        for(int i=rows-2;i>=0;i--){
            int[] temp=new int[triangle.size()];
            for(int j=i;j>=0;j--){
                 int bottom=0;
                int diag=0;
             bottom=triangle.get(i).get(j)+dp[j];
             diag=triangle.get(i).get(j)+dp[j+1];
                temp[j]=Math.min(bottom,diag);
            }
            dp=temp;
        }
        
        return dp[0];
    }
