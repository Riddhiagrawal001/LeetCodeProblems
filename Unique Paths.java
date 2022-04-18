// recursive approach 
 public static int countWays(int row,int col){
        
        //base cases
       if(row ==0 && col==0)
           return 1;
        if(row<0 || col<0) 
            return 0;
        
        int up=countWays(row-1,col);
         int left=countWays(row,col-1);
        
        return up+left;
    }
    public int uniquePaths(int m, int n) {
        int res=countWays(m-1,n-1);
        return res;
    }

// memoization 
 public static int countWays(int row,int col,int[][] dp){
        //base cases
       if(row ==0 && col==0)
           return 1;
        if(row<0 || col<0) 
            return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        int up=countWays(row-1,col,dp);
         int left=countWays(row,col-1,dp);
        
        return dp[row][col]=up+left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        int res=countWays(m-1,n-1,dp);
        return res;
    }

// tabular way
public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)  dp[0][0]=1 ; 
                else {
                    int left=0;
                    int right=0;
               if(i>0) left=dp[i-1][j];
             if(j>0) right=dp[i][j-1];
               
                dp[i][j]=left+right;
                }
            }
        }
        return dp[m-1][n-1];
    }

//tabulation with space optimization
public int uniquePaths(int m, int n) {
        int[]dp=new int[n+1];
            Arrays.fill(dp,0);
        for(int i=0;i<m;i++){
            int[] temp=new int[n+1];
            for(int j=0;j<n;j++){
                if(i==0 && j==0)  temp[0]=1 ; 
                else {
                    int left=0;
                    int right=0;
             left=dp[j];
             if(j>0)right=temp[j-1];
               
                temp[j]=left+right;
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
